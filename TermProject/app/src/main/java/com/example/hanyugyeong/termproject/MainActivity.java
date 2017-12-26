package com.example.hanyugyeong.termproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setTitle("Our Store");
        setContentView(R.layout.activity_main_store);

    }

    //메뉴등록 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menus, menu);
        return true;
    }
    //add 메뉴 클릭 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add:
                intent = new Intent(this, AddMenu.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.sales:
                intent = new Intent(this, TotalSales.class);
                startActivity(intent);
                break;
            case R.id.order:
                intent = new Intent(this, OrderList.class);
                startActivity(intent);
                break;
        }
        return true;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

    }



}
