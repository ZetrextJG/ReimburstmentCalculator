package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import singletons.DataSingleton;
import utils.CORSRemover;

import java.io.IOException;
import java.io.OutputStream;

public class FetchHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        httpExchange.getResponseHeaders().add("Content-Type", "application/json");
        CORSRemover.apply(httpExchange);
        OutputStream os = httpExchange.getResponseBody();
        String response = DataSingleton.getJSONizedList().toString();

        if (httpExchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            httpExchange.sendResponseHeaders(204, -1);
            return;
        }

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        os.write(response.getBytes());
    }
}
