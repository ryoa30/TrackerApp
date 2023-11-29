package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private TextView textView_total;
    private TextView textView_total2;
    private ListView listView;
    private Button button;
    int count=0;
    int count2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView_total = findViewById(R.id.textView_total);
        textView_total2 = (TextView) findViewById(R.id.textView_total2);
        listView = (ListView) findViewById(R.id.listView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyText(String ExerciseName, String setNumber) {
        int temp = Integer.parseInt(setNumber);
        count = count+temp;
        count2++;
        textView_total.setText("Total Set: " + count + " Set");
        textView_total2.setText("Total Exercise: " + count2 + " Move");

        String input = ExerciseName.concat(" - ").concat(setNumber).concat(" Set ");
        itemsAdapter.add(input);
    }
}