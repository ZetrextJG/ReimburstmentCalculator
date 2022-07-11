package singletons;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DataSingleton {
    private static final DataSingleton singleton = new DataSingleton();

    private double mileRate = 0.3;
    private double allowance = 15;
    private Map<String, Double> receiptValues;

    private DataSingleton() {
        this.receiptValues = new HashMap<>();
        this.receiptValues.put("taxi", 10.0);
        this.receiptValues.put("hotel", 60.0);
        this.receiptValues.put("air ticket", 50.0);
        this.receiptValues.put("train", 30.0);

    }

    public static DataSingleton getInstance() {
        return singleton;
    }

    public static JSONArray getJSONizedList() {
        List<String> list = new ArrayList<>(singleton.receiptValues.keySet());
        return new JSONArray(list);
    }

    public static void updateValues(double mileRate, double allowance, Map<String, Double> receiptValues) {
        singleton.mileRate = mileRate;
        singleton.allowance = allowance;
        singleton.receiptValues = receiptValues;
    }

    public static JSONObject calculate( double miles, double daysOfAllowance, List<String> userReceipts){
        Map<String, Double> map = new HashMap<>();
        double value = (miles * singleton.mileRate) + (daysOfAllowance * singleton.allowance);
        for(String key : userReceipts){
            value += singleton.receiptValues.getOrDefault(key, 0.0);
        }
        map.put("value", Math.round(value * 100) / 100.0);
        return new JSONObject(map);
    }
}
