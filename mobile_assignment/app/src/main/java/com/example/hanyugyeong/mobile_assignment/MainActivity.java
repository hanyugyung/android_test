package com.example.hanyugyeong.mobile_assignment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView t;
    LinearLayout layout;
    Intent intent;
    String content;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //액션바 타이틀 변경, setContentView 보다 먼저 와야함.
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setTitle("My Memo");
        setContentView(R.layout.activity_main);
        //setContentView 는 무조건 한번만 호출해야함.
        //처음에 setContentView(layout) 을 추가해서 xml 파일이 안 먹었던 거임.
        layout=(LinearLayout)findViewById(R.id.layout);

    }


    //메모 추가 아이콘을 누르면 메모 작성 엑티비티로
    //옵션메뉴생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.memo,menu);
        return super.onCreateOptionsMenu(menu);
    }
    //옵션메뉴 항목 선택 이벤트 처리 -> 글 작성 액티비티에서 액티비티 결과를 가져와야 한다.
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.plusIcon) {
            intent = new Intent(MainActivity.this, MemoWriteActivity.class);
            startActivityForResult(intent, 1);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            t = new TextView(this);                                        //자바 코드에서 텍스트 뷰 동적 생성
            t.setText(data.getStringExtra("INPUT_TITLE"));
            layout.addView(t);
            content = new String(data.getStringExtra("INPUT_CONTENT"));
       }
        //메인화면에 텍스트 t 가 클릭되면 메모텍스트엑티비티 클래스로 넘어가는 부분.
        // 텍스트 뷰 클릭 이벤트 처리
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                intent.setClass(MainActivity.this, MemoTextActivity.class);
                intent.putExtra("CONTENT", content);
                setResult(RESULT_OK, intent);
                startActivityForResult(intent, 1);
            }
        });
    }


}
