import com.sun.net.httpserver.HttpServer;
import handlers.CalcHandler;
import handlers.FetchHandler;
import handlers.RootHandler;
import handlers.UpdateHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 9000;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        System.out.println("Starting a server on port " + port);
        server.createContext("/", new RootHandler());
        server.createContext("/fetch", new FetchHandler());
        server.createContext("/update", new UpdateHandler());
        server.createContext("/calculate", new CalcHandler());
        server.setExecutor(null);
        server.start();
    }
}