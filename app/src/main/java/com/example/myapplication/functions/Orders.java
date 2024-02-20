package com.example.myapplication.functions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.json.JsonReader;
import com.example.myapplication.new_types.Product_orders;
import com.example.myapplication.requests.OneC_Request;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class Orders extends AppCompatActivity {

    private List<Product_orders> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        System.out.println("YES");
        JsonReader jsonReader = new JsonReader();
        fetchData(jsonReader);
    }

    private void fetchData(final JsonReader jsonReader) {
        OneC_Request.sendRequest(new OneC_Request.OnRequestListener() {
            @Override
            public void onRequestComplete(String result) {
                System.out.println(result);
                arrayList = jsonReader.getObject(result);
                if (arrayList != null) {
                    handleData(arrayList);
                } else {
                    System.out.println("Failed to parse JSON");
                }
            }
        });
    }

    private void handleData(List<Product_orders> arrayList) {

    }

}
