package utils;

import com.sun.net.httpserver.HttpExchange;

public class CORSRemover {
    public static void apply(HttpExchange httpExchange){
        httpExchange.getResponseHeaders().add("Content-Type", "application/json");
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Headers", "*");
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Credentials", "true");
        httpExchange.getResponseHeaders().add("id", "*");
        httpExchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
    }
}
