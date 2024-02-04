package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.adapters.MyAdapter;
import com.example.myapplication.functions.Client;
import com.example.myapplication.functions.Debts;
import com.example.myapplication.functions.Orders;
import com.example.myapplication.functions.Payments;
import com.example.myapplication.functions.Price_list;
import com.example.myapplication.functions.Reports;
import com.example.myapplication.functions.Tasks;
import com.example.myapplication.functions.Track;
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
        setContentView(R.layout.main_layout);
        /*
        try {
            String result = oneCRequest.sendGetRequest(GlobalVar.url);
            System.out.println(result);
        }
        catch (Exception e){
            e.printStackTrace();

        }

         */
        /*
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemList = new ArrayList<>();
        for(int i = 0;i<50;i++){
            itemList.add(new Item("Product "+i));
        }

        adapter = new MyAdapter(itemList);
        recyclerView.setAdapter(adapter);

         */

    }

    public void onClick_Track(View view) {
        Intent intent = new Intent(this, Track.class);
        System.out.println("YES");
        startActivity(intent);
    }

    public void onClick_Orders(View view) {
        Intent intent = new Intent(this, Orders.class);
        System.out.println("YES");
        startActivity(intent);
    }

    public void onClick_Debts(View view) {
        Intent intent = new Intent(this, Debts.class);
        System.out.println("YES");
        startActivity(intent);
    }

    public void onClick_Payments(View view) {
        Intent intent = new Intent(this, Payments.class);
        System.out.println("YES");
        startActivity(intent);
    }

    public void onClick_Clients(View view) {
        Intent intent = new Intent(this, Client.class);
        System.out.println("YES");
        startActivity(intent);
    }

    public void onClick_Price_list(View view) {
        Intent intent = new Intent(this, Price_list.class);
        System.out.println("YES");
        startActivity(intent);
    }

    public void onClick_Reports(View view) {
        Intent intent = new Intent(this, Reports.class);
        System.out.println("YES");
        startActivity(intent);
    }

    public void onClick_Tasks(View view) {
        Intent intent = new Intent(this, Tasks.class);
        System.out.println("YES");
        startActivity(intent);
    }
}