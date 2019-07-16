package com.example.cs441_project_5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter myAdapter;
    RecyclerView.LayoutManager layoutManager;
    Button addButton;
    Button clearButton;

    EditText editText;
    ArrayList input = new ArrayList<String>();
    int total = 0;
    TextView totalTV;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleView);
        addButton = findViewById(R.id.addButton);

        clearButton = findViewById(R.id.button2);


        layoutManager= new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);



        editText = findViewById(R.id.editText);
        totalTV = findViewById(R.id.textTotal);


        myAdapter = new recycleAdapter(input);
        recyclerView.setAdapter(myAdapter);


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.add(editText.getText().toString());
                System.out.println(input);
                totalTV.setText(Integer.toString(sum()));
                myAdapter.notifyDataSetChanged();

            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input.clear();
                myAdapter.notifyDataSetChanged();
                totalTV.setText("0");
            }
        });





    }
    public int sum(){
        total = 0;
        for(int i = 0;i<input.size();i++){
            total+=Integer.parseInt(input.get(i).toString());
        }
        return total;
    }

}
