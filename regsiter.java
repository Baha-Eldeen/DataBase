package com.example.bahaeldeen.database;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.R.attr.id;
import static android.R.attr.name;


public class regsiter extends AppCompatActivity {

    Button button;
    EditText txNmae,txpass,txphone, txEmail ;
    DataBaseHelper db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regsiter);

        txNmae=(EditText)findViewById(R.id.name_regsiter);
        txEmail=(EditText)findViewById(R.id.email_regsiter);
        txphone=(EditText)findViewById(R.id.phone_regsiter);
        txpass=(EditText)findViewById(R.id.pass_regsiter);

        button=(Button)findViewById(R.id.button);

        regData();
    }

    private void regData() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean res = db.RegData(
                                         txNmae.getText().toString(),
                                         txpass.getText().toString(),
                                         txEmail.getText().toString(),
                                         txphone.getText().toString());
                if (res==true) {
                    Toast.makeText(regsiter.this, "Data was added successfully", Toast.LENGTH_LONG).show();
                    Intent i=new Intent(regsiter.this,MainActivity.class);
                    startActivity(i);


                }
                else
                    Toast.makeText(regsiter.this,"Data wasn't added ",Toast.LENGTH_LONG).show();

            }
        });
    }

}
