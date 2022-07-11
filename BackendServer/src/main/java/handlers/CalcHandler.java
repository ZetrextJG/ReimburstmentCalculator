package handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONArray;
import org.json.JSONObject;
import singletons.DataSingleton;
import utils.CORSRemover;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CalcHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String response = "{value: 0}";
        CORSRemover.apply(httpExchange);

        if (httpExchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            httpExchange.sendResponseHeaders(204, -1);
            return;
        }

        OutputStream os = httpExchange.getResponseBody();
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
        }
        JSONObject jsonObject = new JSONObject(textBuilder.toString());
        try {
            double miles = jsonObject.getDouble("miles");
            double days_of_allowance = jsonObject.getDouble("days");
            List<String> receiptList = new ArrayList<>();
            JSONArray receiptArray = jsonObject.getJSONArray("receiptList");
            for(int i = 0; i < receiptArray.length(); i++){
                receiptList.add(receiptArray.getString(i));
            }
            response = DataSingleton.calculate(miles, days_of_allowance, receiptList).toString();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        httpExchange.sendResponseHeaders(200, response.getBytes().length);
        os.write(response.getBytes());

    }
}
