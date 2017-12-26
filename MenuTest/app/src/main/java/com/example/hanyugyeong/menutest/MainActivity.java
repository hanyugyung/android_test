package com.example.hanyugyeong.menutest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, ActionMode.Callback {
    TextView text;
    TextView text2;
    ActionMode mActionMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.TextView01);
        //플로팅모드
        //컨텍스트 메뉴 등록 onCreateContextMenuLister 를 설정
       registerForContextMenu(text);

        //컨텍스트 액션모드
        text2=(TextView)findViewById(R.id.TextView02);
        text2.setOnLongClickListener(this);
    }


    //플로팅을 위한 함수
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("컨텍스트 메뉴");
        //1,2,3 은 메뉴항목의 아이디
        menu.add(0,1,0,"RED");
        menu.add(0,2,0,"GREEN");
        menu.add(0,3,0,"BLUE");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch(item.getItemId()){
            case 1:
                text.setBackgroundColor(Color.RED);
                return true;
            case 2:
                text.setBackgroundColor(Color.GREEN);
                return true;
            case 3:
                text.setBackgroundColor(Color.BLUE);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }

    //컨텍스트 액션모드를 위한 함수
    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu){
        MenuInflater inflater = mode.getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
        return true;
    }
    //onCreateActionMode 가 호출된 후 호출
    //액션메뉴를 refresh 하는 목적으로 여러 번 호출 가능
    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu){
        return false;   //액션메뉴가 업데이트 되면 true 반환
    }

    //사용자가 액션 메뉴 항목을 클릭했을 때 호출
    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item){
        switch(item.getItemId()){
            case R.id.menuItem:
                //필요한 작업
                mode.finish();
                return true;
            default:
                return false;
        }
    }

    //사용자가 컨텍스트 액션모드를 빠져나갈 때 호출
    @Override
   public void onDestroyActionMode(ActionMode mode){
        mActionMode=null;
    }

    //사용자가 롱클릭으로 해당 뷰를 클릭했을 때 호출
    @Override
    public boolean onLongClick(View v){
        //액션모드를 빠져나가지 않았다면
        if(mActionMode!=null) return false;

        mActionMode = this.startSupportActionMode(this);
        v.setSelected(true);
        return true;

    }


}
