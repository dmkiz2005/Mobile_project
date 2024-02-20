package com.example.myapplication.json;

import com.example.myapplication.new_types.Product_orders;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
public class JsonReader {

    public List<Product_orders> getObject(String jsonString) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Product_orders>>(){}.getType();
        return gson.fromJson(jsonString, listType);
    }
}
