package com.example.hanyugyeong.termproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class OrderList extends AppCompatActivity {
    private ListView m_ListView;
    private ArrayAdapter<String> m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.setTitle("Order List");
        setContentView(R.layout.activity_order_list);

        m_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        m_ListView = (ListView) findViewById(R.id.list);

    }

    @Override
    protected void onStart(){
        super.onStart();

        OnClickListItem onClickListItem = new OnClickListItem();

        m_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        m_ListView = (ListView) findViewById(R.id.list);
        m_ListView.setAdapter(m_Adapter);
        m_ListView.setOnItemClickListener(onClickListItem);
    }

    class OnClickListItem implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            Intent intent = new Intent(getApplicationContext(), OrderPage.class);
            startActivity(intent);
        }
    }

}
