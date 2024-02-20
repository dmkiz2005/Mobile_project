package com.example.myapplication.functions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.json.JsonReader;
import com.example.myapplication.new_types.Product_orders;
import com.example.myapplication.requests.OneC_Request;

import java.util.List;

public class Orders extends AppCompatActivity {

    private List<Product_orders> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        System.out.println("YES");
        JsonReader jsonReader = new JsonReader();
        OneC_Request.sendRequest(new OneC_Request.OnRequestListener() {
            @Override
            public void onRequestComplete(String result) {
                arrayList = jsonReader.getObject(result);
            }
        });
        for(int i = 0;i<arrayList.size();i++)
        {
            System.out.println(arrayList.get(i));
        }
    }
}