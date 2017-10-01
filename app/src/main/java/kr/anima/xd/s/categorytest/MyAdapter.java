package kr.anima.xd.s.categorytest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Created by PC on 2017-09-24.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Item> list;

    public MyAdapter() {
    }

    public MyAdapter(ArrayList<Item> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entries, parent, false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SimpleDateFormat date=new SimpleDateFormat("MM/dd");
        holder.TV_Date.setText(date.format(list.get(position).date));
        holder.TV_Msg.setText(list.get(position).title);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView TV_Date, TV_Msg;

        public ViewHolder(View itemView) {
            super(itemView);
            TV_Date=itemView.findViewById(R.id.TV_Date);
            TV_Msg=itemView.findViewById(R.id.TV_Message);
        }
    }
}
