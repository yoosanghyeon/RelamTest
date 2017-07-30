package yoosanghyeon.relamtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yoosanghyeon.relamtest.read.ReadActivitiy;
import yoosanghyeon.relamtest.search.SearchActivity;
import yoosanghyeon.relamtest.wirte.WriteActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button readBtn;
    private Button writeBtn;
    private Button searchBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readBtn = (Button) findViewById(R.id.list_all_btn);
        writeBtn = (Button) findViewById(R.id.list_wirte_btn);
        searchBtn = (Button) findViewById(R.id.list_search_btn);

        readBtn.setOnClickListener(this);
        writeBtn.setOnClickListener(this);
        searchBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {

        Intent intent;

        switch (v.getId()) {
            case R.id.list_all_btn:
                intent = new Intent(MainActivity.this, ReadActivitiy.class);
                startActivity(intent);
                break;
            case R.id.list_wirte_btn:
                intent = new Intent(MainActivity.this, WriteActivity.class);
                startActivity(intent);
                break;
            case R.id.list_search_btn:
                intent = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }


}
