package com.example.hanyugyeong.mypizzaorderapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.hanyugyeong.mypizzaorderapp.R.id.nap;
import static com.example.hanyugyeong.mypizzaorderapp.R.id.orgn;
import static com.example.hanyugyeong.mypizzaorderapp.R.id.thi;

public class MainActivity extends AppCompatActivity {
    TextView total;                 //TextView 를 나타내는 변수를 total에 담음.
    Integer sum=0, sumR=0, sumC = 0;    //Integer는 객체형. 참조형 변수.
    RadioGroup groupR;              //라디오버튼들을 그룹에 묶으면 중복체크는 막을 수 있다.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        total = (TextView)findViewById(R.id.total);         //뷰 파일에 있는 total 이라는 id 를 자바 파일의 total변수와 같게 쓰일 수 있도록 지정.
        total.setText("0");                                 //처음에 텍스트뷰는 0으로 초기화해놓음.
        groupR = (RadioGroup)findViewById(R.id.groupR);     //뷰 파일에 있는 라디오버튼 그룹 groupR 이라는 id를 자바 파일의 groupR 변수가 같게 쓰일 수 있도록 지정.
    }


    //라디오 그룹 안의 라디오 버튼이 눌릴 때마다 호출된다.
    public void onRadioButton(View v){
      //  groupR.check(v.getId());            //void check(int id) : groupR 안의 라디오버튼 중 선택된 것을 설정한다. 필요없어서 주석처리함.
        sumR = 0;                               //다른 버튼으로 눌릴 때마다 그 전에 일단 먼저 sumR을 0으로 맞춰줘야 total 값이 더해지지 않는다.
        if(v.getId() == R.id.orgn){             //각 버튼에 따라 값이 정해진다.
            sumR += 10000;
        }
        else if(v.getId() == R.id.nap){
            sumR += 15000;
        }
        else{
            sumR += 13000;
        }
        sum = sumR + sumC;                      // sumR : 라디오 버튼 중 눌린 버튼의 가격, sumC : 체크박스 버튼 중 눌린 버튼의 가격
        total.setText(sum.toString());          // sum : 총 가격   ---- 총 가격을 문자열로 변환하여 텍스트 뷰에 나타나도록 한다.
    }

    //체크 박스 버튼이 눌릴 때마다 호출된다.
    public void onCheckBox(View v){
        boolean checked = ((CheckBox)v).isChecked();            //체크 박스가 선택되었으면 참, 아니면 거짓.
        if (checked) {                                          //버튼이 눌렸고,
            if (v.getId() == R.id.peper)                        //그 버튼이 무스 버튼이냐에 따라 금액 추가
                sumC += 3000;
            else if (v.getId() == R.id.pota)
                sumC += 2000;
            else
                sumC += 4000;
        }
        else{                                                   //버튼이 취소되면 금액 취소
            if (v.getId() == R.id.peper)
                sumC -= 3000;
            else if (v.getId() == R.id.pota)
                sumC -= 2000;
            else
                sumC -= 4000;
        }
        sum = sumR+sumC;                        // sumR : 라디오 버튼 중 눌린 버튼의 가격, sumC : 체크박스 버튼 중 눌린 버튼의 가격
        total.setText(sum.toString());          // sum : 총 가격   ---- 총 가격을 문자열로 변환하여 텍스트 뷰에 나타나도록 한다.
    }



}
