package com.example.cs441_project_5;


import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class recycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    int [] item;
    public recycleAdapter(int [] item ){

        this.item = item;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View row =LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text,parent,false);
        Item itemHolder = new Item(row);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((Item)holder).textView.setText(item[position]);

    }

    @Override
    public int getItemCount() {
        return item.length;
    }
    public class Item extends  RecyclerView.ViewHolder {
        TextView textView;

        public Item(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }
    }
}