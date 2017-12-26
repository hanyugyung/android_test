package com.example.hanyugyeong.bookmark;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddBookMark extends AppCompatActivity {
    Button writeBtn;
    EditText u, b; //북마크이름, 유알엘
    //String fileName = "bookmark.txt";
    //파일생성
    File file = new File("bookmark.txt");
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book_mark);



        u = (EditText)findViewById(R.id.urlmark);
        b = (EditText)findViewById(R.id.bmark);
        writeBtn = (Button)findViewById(R.id.addButton);

        //북마크 url 입력받은 것을 파일에 쓰고 다시 메인 화면으로 이동
        // 파일쓰는 형태는
        //한줄 당 '북마크','유알엘' 형태
        writeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try {

                    if(file.exists())
                        fos = openFileOutput(file.toString(), Context.MODE_PRIVATE);
                    else {
                        //파일 쓰기(기존 파일에 이어서 쓰기)
                        fos = openFileOutput(file.toString(), Context.MODE_APPEND);
                    }

                    //FileOutputStream fos = openFileOutput(file.toString(), Context.MODE_APPEND);
                    fos.write(b.getText().toString().getBytes());
                    fos.write("\n".getBytes());
                    fos.write(u.getText().toString().getBytes());
                    fos.write("\n".getBytes());
                    fos.close();
                    //북마크인 부분은 메인 액티비티에 인텐트에 넣어서 보내준다.
                    Intent intent = getIntent();
                    intent.putExtra("BookMark", b.getText().toString());
                    setResult(RESULT_OK, intent);
                }catch (IOException e){
                    e.printStackTrace();
                }
                finish();
            }
        });
    }
}
