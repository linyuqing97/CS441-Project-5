package com.example.cs441_project_5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
        loadData();

        recyclerView = findViewById(R.id.recycleView);
        addButton = findViewById(R.id.addButton);

        clearButton = findViewById(R.id.button2);


        layoutManager= new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);



        editText = findViewById(R.id.editText);
        editText.setInputType(InputType.TYPE_CLASS_NUMBER);
        totalTV = findViewById(R.id.textTotal);
        totalTV.setText(String.valueOf(sum()));





        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);
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
    public void onPause(){
        super.onPause();
        saveData();
    }


    public int sum(){
        total = 0;
        for(int i = 0;i<input.size();i++){
            total+=Integer.parseInt(input.get(i).toString());
        }
        return total;
    }
    private void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(input);
        editor.putString("Input list",json);
        editor.apply();
    }
    private void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("Input list",null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        input = gson.fromJson(json,type);

        if(input == null){
            input= new ArrayList<>();
        }


    }



    ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT|ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            input.remove(viewHolder.getAdapterPosition());
            myAdapter.notifyDataSetChanged();
            totalTV.setText(String.valueOf(sum()));
        }
    };

}
