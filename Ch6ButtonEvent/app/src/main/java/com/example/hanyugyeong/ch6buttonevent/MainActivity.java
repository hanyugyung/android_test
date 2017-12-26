package com.example.hanyugyeong.ch6buttonevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View v){

        if(v.getId() == R.id.button)
            Toast.makeText(getApplicationContext(), "Button pressed!", Toast.LENGTH_LONG).show();
    }
    public void onClick2(View v){





        Toast.makeText(getApplicationContext(), "Button pressed!", Toast.LENGTH_LONG);
    }
}
