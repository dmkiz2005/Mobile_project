package com.example.myapplication.json;

import com.example.myapplication.new_types.Product_orders;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
public class JsonReader {

    public List<Product_orders> getObject(String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Product_orders>>(){}.getType();
        return gson.fromJson(jsonString, listType);
    }

    public static String convertProductAndProductNameToJson(List<Product_orders> productOrdersList) {
        Gson gson = new Gson();
        JsonArray jsonArray = new JsonArray();
        for (Product_orders productOrders : productOrdersList) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Product", productOrders.getProduct());
            jsonObject.addProperty("ProductName", productOrders.getProductName());
            jsonArray.add(jsonObject);
        }
        return gson.toJson(jsonArray);
    }
}
