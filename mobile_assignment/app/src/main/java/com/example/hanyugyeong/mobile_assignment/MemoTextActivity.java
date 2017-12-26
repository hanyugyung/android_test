package com.example.hanyugyeong.mobile_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.TextView;

public class MemoTextActivity extends AppCompatActivity {

    TextView textView;


    //    Intent intent;
    //옵션메뉴생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.delete,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //액션바 타이틀 변경
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("Memo Text");
        setContentView(R.layout.activity_memo_text);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        data = getIntent();
        textView = new TextView(this);
        textView.setText(data.getStringExtra("CONTENT"));
    }
}
