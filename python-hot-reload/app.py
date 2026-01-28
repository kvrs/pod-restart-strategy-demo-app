import threading
import time
from flask import Flask, jsonify
import yaml
import os
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler

CONFIG_PATH = os.getenv("CONFIG_PATH", "/config/config.yaml")

app = Flask(__name__)
app_config = {"message": "default", "flag": False, "version": 1}

def load_config():
    global app_config
    try:
        with open(CONFIG_PATH, "r", encoding="utf-8") as f:
            data = yaml.safe_load(f) or {}
            app_config.update(data)
            print(f"[CONFIG] Reloaded: {app_config}")
    except Exception as e:
        print(f"[CONFIG] Error: {e}")

class ConfigChangeHandler(FileSystemEventHandler):
    def on_modified(self, event):
        if event.src_path.endswith("config.yaml"):
            print("[WATCHER] Config changed")
            load_config()
    def on_created(self, event):
        if event.src_path.endswith("config.yaml"):
            print("[WATCHER] Config re-created")
            load_config()

def start_watcher():
    directory = os.path.dirname(CONFIG_PATH)
    observer = Observer()
    observer.schedule(ConfigChangeHandler(), directory, recursive=False)
    observer.start()

    def poller():
        last = None
        while True:
            try:
                ts = os.stat(CONFIG_PATH).st_mtime
                if last is None:
                    last = ts
                elif ts != last:
                    last = ts
                    print("[POLL] Config changed")
                    load_config()
            except Exception:
                pass
            time.sleep(5)

    threading.Thread(target=poller, daemon=True).start()

@app.route("/config")
def get_config():
    return jsonify(app_config)

@app.route("/")
def root():
    return jsonify({"status": "running", "config": app_config})

if __name__ == "__main__":
    load_config()
    start_watcher()
    app.run(host="0.0.0.0", port=8080)