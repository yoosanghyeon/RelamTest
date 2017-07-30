package yoosanghyeon.relamtest.read;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import yoosanghyeon.relamtest.R;
import yoosanghyeon.relamtest.data.TestData;
import yoosanghyeon.relamtest.read.adapter.ReadTestAdapter;

public class ReadActivitiy extends AppCompatActivity {


    private static final String TAG = ReadActivitiy.class.getName();

    Realm realm;

    private RecyclerView recyclerView;
    private ReadTestAdapter readTestAdapter;

    private ArrayList<String> datas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_activitiy);
        Toolbar toolbar = (Toolbar) findViewById(R.id.read_toolbar);
        setSupportActionBar(toolbar);

        realm = Realm.getDefaultInstance();

        RealmQuery<TestData> query = realm.where(TestData.class);
        RealmResults<TestData> testDatas = query.findAll();

            for (TestData testData : testDatas){
                Log.e(TAG, testData.getName());
                datas.add(testData.getName());
            }


            Log.e(TAG, "result size :: " +testDatas.size());

        recyclerView = (RecyclerView) findViewById(R.id.read_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        readTestAdapter = new ReadTestAdapter(datas);
        recyclerView.setAdapter(readTestAdapter);

    }

}
