package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;
import singletons.DataSingleton;
import utils.CORSRemover;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;

public class UpdateHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "failed";
        CORSRemover.apply(httpExchange);
        OutputStream os = httpExchange.getResponseBody();

        if (httpExchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            httpExchange.sendResponseHeaders(204, -1);
            return;
        }

        InputStream requestsData = httpExchange.getRequestBody();
        StringBuilder textBuilder = new StringBuilder();

        try (Reader reader = new BufferedReader(new InputStreamReader(
                requestsData,
                Charset.forName(StandardCharsets.UTF_8.name())))
        ) {
            int c = 0;
            while ((c = reader.read()) != -1) {
                textBuilder.append((char) c);
            }
        } catch (Exception exp){
            System.out.println(exp.getMessage());
        }
        System.out.println(textBuilder.toString());
        JSONObject jsonObject = new JSONObject(textBuilder.toString());
        try {
            double mileRate = jsonObject.getDouble("mileRate");
            double allowance = jsonObject.getDouble("allowance");
            JSONObject receivedTypes = jsonObject.getJSONObject("receipts");
            HashMap<String, Double> processedTypes = new HashMap<>();
            for (Iterator<String> it = receivedTypes.keys(); it.hasNext(); ) {
                String key = it.next();
                Double value = receivedTypes.getDouble(key);
                processedTypes.put(key, value);
            }
            DataSingleton.updateValues(mileRate,
                    allowance,
                    processedTypes);
            response = "success";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        os.write(response.getBytes());
    } }