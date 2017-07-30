package yoosanghyeon.relamtest.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import io.realm.Realm;
import io.realm.RealmResults;
import yoosanghyeon.relamtest.R;
import yoosanghyeon.relamtest.data.TestData;

public class SearchActivity extends AppCompatActivity {


       /*<EditText
    android:id="@+id/search_string_edit_text"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />

        <Button
    android:id="@+id/search_ok_btn"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="wirte_ok_btn" />

        <TextView
    android:text="result data = "
    android:id="@+id/search_result_textivew"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />*/

    private EditText editText;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editText = (EditText) findViewById(R.id.search_string_edit_text);
        textView = (TextView) findViewById(R.id.search_result_textivew);

        findViewById(R.id.search_ok_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(editText.getText().toString())){
                    onSearchQurey(editText.getText().toString());
                }

            }
        });
    }

    private void onSearchQurey(String data){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<TestData> results = realm.where(TestData.class).equalTo("name", data).findAll();
        for (TestData testData : results){
            textView.setText(textView.getText() + " :: " + testData.getName());
        }

    }
}
