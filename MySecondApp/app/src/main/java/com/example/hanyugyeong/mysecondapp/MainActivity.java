package com.example.hanyugyeong.mysecondapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 누르면 무명클래스로 버튼이 보내지면? 화면이 전환됨. 꼭 메니페스트.xml 파일에서 새로운 액티비티를 생성해줘야함.
        button = (Button)findViewById(R.id.loginButton);
        ed1 = (EditText)findViewById(R.id.name);
        ed2 = (EditText)findViewById(R.id.pass);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ed1.getText().toString().equals("hanyugyeong") && ed2.getText().toString().equals("likelion")) {
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    startActivity(intent);
                }
                else
                    finish();
            }
        });
    }
}
