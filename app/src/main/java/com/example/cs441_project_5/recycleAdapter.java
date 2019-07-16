package com.example.cs441_project_5;


import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class recycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ArrayList items = new ArrayList<String>();
    public recycleAdapter(ArrayList<String>items){

        this.items = items;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View row =LayoutInflater.from(parent.getContext()).inflate(R.layout.my_text,parent,false);
        Item itemHolder = new Item(row);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {
        ((Item)holder).textView.setText(items.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class Item extends  RecyclerView.ViewHolder {
        TextView textView;

        public Item(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.textView);
        }

    }


}
