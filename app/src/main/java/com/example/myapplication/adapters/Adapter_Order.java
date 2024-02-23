package com.example.myapplication.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.new_types.Item_debts;
import com.example.myapplication.new_types.Product_orders;

import java.util.ArrayList;

public class Adapter_Order extends RecyclerView.Adapter<Adapter_Order.ViewHolder> {
    private Context mContext;
    private ArrayList<Product_orders> mItem_Order;

    public Adapter_Order(Context context, ArrayList<Product_orders> item_order) {
        mContext = context;
        mItem_Order = item_order;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_orders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product_orders currentDataModel = mItem_Order.get(position);

        holder.textView1.setText(currentDataModel.getProductName());
        holder.textView2.setText(currentDataModel.getBarCode());
        holder.textView3.setText(currentDataModel.getBox());
        /*if (position % 2 != 0) {
            holder.itemView.setBackgroundColor(Color.GRAY);
        } else {
            holder.itemView.setBackgroundColor(Color.WHITE);
        }

         */
    }

    @Override
    public int getItemCount() {
        return mItem_Order.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView1;
        TextView textView2;
        TextView textView3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            textView3 = itemView.findViewById(R.id.textView3);
        }
    }
}


