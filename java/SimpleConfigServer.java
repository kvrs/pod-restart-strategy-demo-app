import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;

public class SimpleConfigServer {

    private static final Path CONFIG_FILE = Path.of("/config/message");
    private static volatile String message = "Not loaded";

    public static void main(String[] args) throws Exception {

        message = Files.readString(CONFIG_FILE).trim();
        System.out.println("Config loaded: " + message);

        Executors.newSingleThreadScheduledExecutor()
                .scheduleAtFixedRate(() -> {
                    try {
                        String newMessage = Files.readString(CONFIG_FILE).trim();
                        if (!newMessage.equals(message)) {
                            message = newMessage;
                            System.out.println("Config reloaded: " + message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }, 5, 5, TimeUnit.SECONDS);

        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        server.createContext("/", exchange -> {
            exchange.sendResponseHeaders(200, message.length());
            exchange.getResponseBody().write(message.getBytes());
            exchange.close();
        });
        server.start();

        System.out.println("Java app running on port 8080");
    }
}
