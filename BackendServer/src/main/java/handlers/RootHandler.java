package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import singletons.DataSingleton;
import utils.CORSRemover;

import java.io.IOException;
import java.io.OutputStream;

public class RootHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = DataSingleton.getJSONizedList().toString();
        CORSRemover.apply(httpExchange);
        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        OutputStream os = httpExchange.getResponseBody();
        os.write(response.getBytes());
    }
}
