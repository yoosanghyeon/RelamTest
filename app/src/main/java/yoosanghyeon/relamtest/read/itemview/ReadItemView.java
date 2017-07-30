package yoosanghyeon.relamtest.read.itemview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import yoosanghyeon.relamtest.R;

/**
 * Created by yoosanghyeon on 2017-07-30.
 */

public class ReadItemView extends RecyclerView.ViewHolder{

    private TextView testTextView;


    public ReadItemView(View itemView) {
        super(itemView);
        testTextView = (TextView) itemView.findViewById(R.id.test_text_view);
    }

    public void onBindViewdata(String data){
        testTextView.setText(data);
    }
}
