package com.oliver.krediti.adapteri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oliver.krediti.R;
import com.oliver.krediti.klasi.Krediti;
import com.oliver.krediti.listeners.OnRowKrediti;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Krediti_adapter extends RecyclerView.Adapter<Krediti_adapter.ViewHolder> {
    Context context;
    List<Krediti> kreditiList = new ArrayList<>();
    OnRowKrediti onClick;

    public void setItems(List<Krediti> krediti) {
        kreditiList = krediti;
    }
    public Krediti_adapter(List<Krediti> kreditiList,Context context1,OnRowKrediti onRowKrediti) {
        this.kreditiList = kreditiList;
        this.context = context1;
        this.onClick = onRowKrediti;
    }
//    public Krediti_adapter(Context context2){
//        context = context2;
//    }
//    public Krediti_adapter(OnRowKrediti onClick1){
//        this.onClick = onClick1;
//    }

    @Override
    public Krediti_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.krediti_recycler_row, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(Krediti_adapter.ViewHolder holder,  final int position) {
        final Krediti krediti5 = kreditiList.get(position);
        holder.textView.setText(krediti5.getNaziv());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    onClick.onRowClick(krediti5,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return kreditiList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_na_krediti)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
