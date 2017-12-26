package com.example.hanyugyeong.termproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddMenu extends AppCompatActivity {


    EditText title, cost;
    Button complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setTitle("Add Menu");
        setContentView(R.layout.add_menu);

        title = (EditText)findViewById(R.id.title);
        cost = (EditText)findViewById(R.id.cost);
        complete = (Button) findViewById(R.id.complete);

        complete.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = getIntent();
                intent.putExtra("TITLE", title.getText());
                intent.putExtra("COST", cost.getText());
                setResult(1,intent);
            }
        });

    }



}
