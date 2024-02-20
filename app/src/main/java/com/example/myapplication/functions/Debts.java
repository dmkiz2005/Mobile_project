package com.example.myapplication.functions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.adapters.Adapter_Debts;
import com.example.myapplication.new_types.Item_debts;

import java.util.ArrayList;
import java.util.List;

public class Debts extends AppCompatActivity {


    private ArrayList<Item_debts> itemList;
    private RecyclerView recyclerView;
    private Adapter_Debts adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debts);

        recyclerView = findViewById(R.id.recyclerView2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            itemList.add(new Item_debts("Company "+i, false, "Adress" + i, "0"));
        }

        adapter = new Adapter_Debts(this, itemList);
        recyclerView.setAdapter(adapter);
    }
}