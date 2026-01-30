import time
from http.server import BaseHTTPRequestHandler, HTTPServer

CONFIG_FILE = "/config/message"
message = "Not loaded"

def load_config():
    global message
    with open(CONFIG_FILE, "r") as f:
        message = f.read().strip()
    print("Config loaded:", message)

class Handler(BaseHTTPRequestHandler):
    def do_GET(self):
        self.send_response(200)
        self.end_headers()
        self.wfile.write(message.encode())

if __name__ == "__main__":
    load_config()

    # Poll config every 5 seconds
    def poll_config():
        global message
        while True:
            time.sleep(5)
            with open(CONFIG_FILE, "r") as f:
                new_message = f.read().strip()
            if new_message != message:
                message = new_message
                print("Config reloaded:", message)

    import threading
    threading.Thread(target=poll_config, daemon=True).start()

    server = HTTPServer(("0.0.0.0", 5000), Handler)
    print("Python app running on port 5000")
    server.serve_forever()
