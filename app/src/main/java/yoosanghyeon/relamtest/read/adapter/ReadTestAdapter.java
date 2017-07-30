package yoosanghyeon.relamtest.read.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import yoosanghyeon.relamtest.R;
import yoosanghyeon.relamtest.read.itemview.ReadItemView;

/**
 * Created by yoosanghyeon on 2017-07-30.
 */

public class ReadTestAdapter extends RecyclerView.Adapter<ReadItemView> {

    ArrayList<String> datas;

    public ReadTestAdapter(ArrayList<String> datas) {
        this.datas = datas;
    }

    @Override
    public ReadItemView onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ReadItemView(LayoutInflater.from(parent.getContext()).inflate(R.layout.read_itemview, parent, false));
    }



    @Override
    public void onBindViewHolder(ReadItemView holder, int position) {
        holder.onBindViewdata(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
