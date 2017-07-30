package yoosanghyeon.relamtest.wirte;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.realm.Realm;
import yoosanghyeon.relamtest.R;
import yoosanghyeon.relamtest.data.TestData;

public class WriteActivity extends AppCompatActivity {


    private EditText testDataStringEdittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wirte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.write_toolbar);
        setSupportActionBar(toolbar);


        testDataStringEdittext = (EditText) findViewById(R.id.test_data_string_edit_text);
        findViewById(R.id.wirte_ok_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(testDataStringEdittext.getText().toString())) {

                    Log.e(TAG, "onClick");
                    onCommitTestTwo(testDataStringEdittext.getText().toString());
                }

            }
        });

    }


    private static final String TAG = WriteActivity.class.getName();

    private void onCommitData(final String data) {
        Realm realm = Realm.getDefaultInstance();

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm bgRealm) {
                TestData testData = new TestData(data);
                TestData realmTestData = bgRealm.copyToRealm(testData);
                bgRealm.commitTransaction();
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
                Log.e(TAG, "onSuccess() ");
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
                Log.e(TAG, "onError() ");
            }
        });
    }


    private void onCommitTestTwo(String data){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        TestData user = realm.createObject(TestData.class); // Create a new object
        user.setName(data);
        realm.commitTransaction();
    }


}
