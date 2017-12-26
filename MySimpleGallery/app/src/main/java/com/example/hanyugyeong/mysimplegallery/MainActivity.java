package com.example.hanyugyeong.mysimplegallery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import static com.example.hanyugyeong.mysimplegallery.R.drawable.apple;
import static com.example.hanyugyeong.mysimplegallery.R.drawable.grape;
import static com.example.hanyugyeong.mysimplegallery.R.drawable.straberry;

public class MainActivity extends AppCompatActivity {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView)findViewById(R.id.big);                //이미지뷰 위젯의 아이디를 img 라는 변수에 할당한다.
        img.setImageResource(R.drawable.apple);                 //제일 왼쪽에 위치한 사과 사진으로 처음 이미지뷰를 설정한다.
    }

    //이미지 버튼이 눌릴 때마다 호출된다.
    //어떤 이미지가 눌렸냐에 따라 각각 이미지뷰에 설정된다.
    //스위치문을 이용하여 눌린 id 에 따라,
    //setImageResource() 함수를 사용하여 이미지뷰에 눌린 이미지버튼의 사진이 설정되도록 하였다.

    public void imageClicked(View v){
        switch(v.getId()) {
            case R.id.ap:
                img.setImageResource(R.drawable.apple);
                break;
            case R.id.gr:
                img.setImageResource(R.drawable.grape);
                break;
            case R.id.ban:
                img.setImageResource(R.drawable.banana);
                break;
            case R.id.stra:
                img.setImageResource(R.drawable.straberry);
                break;
        }
    }

}
