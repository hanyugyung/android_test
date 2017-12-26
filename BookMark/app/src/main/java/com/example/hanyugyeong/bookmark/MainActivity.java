package com.example.hanyugyeong.bookmark;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView m_ListView;
    private ArrayAdapter<String> m_Adapter;
    private Intent intent;
    ArrayList<String> array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        array = new ArrayList<>();

        // string 자리에 입력받은 것의 string 형의 것이 와야함. 예를들면,,, google, naver 등
        m_Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        m_ListView = (ListView) findViewById(R.id.list);
        m_ListView.setAdapter(m_Adapter);
        m_ListView.setOnItemClickListener(onClickListItem);

    }

    //북마크 클릭 이벤트 처리
    private AdapterView.OnItemClickListener onClickListItem = new AdapterView.OnItemClickListener() {
        @Override

        //이부분에서 파일에서 읽어오는 값으로 url 을 가져올 수 있도록 고쳐야함.
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //ArrayList 의 contains 메소드는 리스트 안에 매개변수와 같은 문자열이 있을 경우 true 를 반환한다.
            //indexOf 는 매개변수의 인덱스 값을 반환한다.
            if(array.contains(view.getId())) {
                int number = array.indexOf(view.getId());
                //사이트로 바로 이동하기
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(array.get(number + 1)));
                startActivity(intent);
            }
            else
                Toast.makeText (getApplicationContext(), "저장된 경로가 없습니다.", Toast. LENGTH_SHORT ).show();
        }


    };
    //메뉴등록 메소드
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuoverflow, menu);
        return true;
    }
    //add 메뉴 클릭 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        intent = new Intent(this, AddBookMark.class);
        startActivityForResult(intent,1);
        return true;
    }





    //받은 북마크명을 스택에 넣어 리스트뷰에 추가
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == 1 && resultCode == RESULT_OK) {
            try{
                BufferedReader bufferedReader = new BufferedReader(new FileReader("bookmark.txt"));
                //FileInputStream fis = openFileInput("bookmark.txt");
                //byte[] buffer = new byte[fis.available()];
                while(bufferedReader.read() != -1){
                    array.add(bufferedReader.readLine());
                }
                bufferedReader.close();
            }catch(IOException e){
                e.printStackTrace();
            }
            m_Adapter.add(data.getStringExtra("BookMark"));
        }
    }
}
