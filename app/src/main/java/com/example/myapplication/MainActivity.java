package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.myapplication.adapters.MyAdapter;
import com.example.myapplication.new_types.Item;
import com.example.myapplication.requests.OneC_Request;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    OneC_Request oneCRequest = new OneC_Request();
    private List<Item> itemList;
    private RecyclerView recyclerView;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        try {
            String result = oneCRequest.sendGetRequest(GlobalVar.url);
            System.out.println(result);
        }
        catch (Exception e){
            e.printStackTrace();

        }

         */
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            itemList.add(new Item("Product "+i));
        }

        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}