package com.example.bahaeldeen.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.R.attr.name;

public class welcome extends AppCompatActivity {

    TextView Tx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        Tx=(TextView)findViewById(R.id.text);
        Tx.setText(getIntent().getStringExtra("name"));


    }
}
