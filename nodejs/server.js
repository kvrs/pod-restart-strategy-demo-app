const fs = require("fs");
const http = require("http");

const CONFIG_FILE = "/config/message";
let message = "Not loaded";

// Initial load
message = fs.readFileSync(CONFIG_FILE, "utf8").trim();
console.log("Config loaded:", message);

// Poll every 5 seconds
setInterval(() => {
  const newMessage = fs.readFileSync(CONFIG_FILE, "utf8").trim();
  if (newMessage !== message) {
    message = newMessage;
    console.log("Config reloaded:", message);
  }
}, 5000);

// HTTP server
http.createServer((req, res) => {
  res.end(message);
}).listen(3000, () => {
  console.log("Node app running on port 3000");
});
