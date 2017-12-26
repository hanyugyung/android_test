package com.example.hanyugyeong.mobile_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoWriteActivity extends AppCompatActivity {

    Button button;
    EditText title;
    EditText content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //액션바 타이틀 변경
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Add Memo");
        setContentView(R.layout.activity_memo_write);
        button=(Button)findViewById(R.id.button);
        title=(EditText)findViewById(R.id.editTitle);
        content=(EditText)findViewById(R.id.editContent);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent =  getIntent();
                intent.putExtra("INPUT_TITLE", title.getText().toString());
                intent.putExtra("INPUT_CONTENT", content.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
                //취소버튼을 누를 시에도 추가로 구현하자!

            }
        });


    }
}
