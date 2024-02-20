package com.example.myapplication.json;

import com.example.myapplication.new_types.Item;
import com.example.myapplication.new_types.Product_orders;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class JsonReader {

    public List<Product_orders> getObject(String json)
    {
        ObjectMapper mapper = new ObjectMapper();
        List<Product_orders> methodList = new ArrayList<>();
        try {
            methodList = Arrays.asList(mapper.readValue(json, Product_orders[].class));
        }
        catch (IOException e){
            System.out.println(e);
        }


        return methodList;
    }
}
