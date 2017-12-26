package com.example.hanyugyeong.bagicwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtNum1, edtNum2;
    TextView tvResult;
    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNum1 = (EditText)findViewById(R.id.editNum1);
        edtNum2 = (EditText)findViewById(R.id.editNum2);
        tvResult = (TextView)findViewById(R.id.tvResult);
    }

    public void mOnClick(View v){
        num1 = edtNum1.getText().toString();
        num2 = edtNum2.getText().toString();
        switch(v.getId()){
            case R.id.btnAdd:
                result = Integer.parseInt(num1) + Integer.parseInt(num2);
                tvResult.setText("계산결과 : " + result.toString());
                break;
            case R.id.btnSub:
                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                tvResult.setText("계산결과 : " + result.toString());
                break;
            case R.id.btnMul:
                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                tvResult.setText("계산결과 : " + result.toString());
                break;
            case R.id.btnDiv:
                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                tvResult.setText("계산결과 : " + result.toString());
                break;
            case R.id.btnClr:
                edtNum1.setText("");
                edtNum2.setText("");
                tvResult.setText("");
                break;
            default:
                break;
        }
    }


}
