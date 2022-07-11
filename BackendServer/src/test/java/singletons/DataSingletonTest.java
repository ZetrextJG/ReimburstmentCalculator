package singletons;

import org.json.JSONArray;
import org.json.JSONObject;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataSingletonTest{

    @Test
    @Order(1)
    @DisplayName("Fetching default receipts dictionary")
    void fetchTest(){
        JSONArray jsonArray = DataSingleton.getJSONizedList();
        assertFalse(jsonArray.isEmpty());
    }
    @Test
    @Order(2)
    @DisplayName("Checking contents of fetched receipts dictionary")
    void fetchContentsTest(){
        JSONArray jsonArray = DataSingleton.getJSONizedList();
        assertTrue(
                jsonArray.toList().contains("taxi")
        );
    }
    @Test
    @Order(3)
    @DisplayName("Validating update method")
    void updateTest(){
        Map<String, Double> mockReceipts = new HashMap<>();
        mockReceipts.put("taxi", 50.0);
        DataSingleton.updateValues(0.5, 20.0, mockReceipts);
        JSONArray jsonArray = DataSingleton.getJSONizedList();
        assertEquals("taxi", jsonArray.getString(0));
    }
    @Test
    @Order(4)
    @DisplayName("Validating update method")
    void calculateTest(){
        Map<String, Double> mockReceipts = new HashMap<>();
        mockReceipts.put("taxi", 20.0);
        mockReceipts.put("train", 50.0);
        mockReceipts.put("food", 10.0);
        DataSingleton.updateValues(0.3, 15.0, mockReceipts);
        List<String> mockList = new ArrayList<>();
        mockList.add("taxi");
        mockList.add("taxi");
        mockList.add("food");
        JSONObject jso = DataSingleton.calculate(1000, 10, mockList);
        assertEquals(500, jso.getDouble("value"));
    }
}