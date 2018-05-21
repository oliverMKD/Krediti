package com.oliver.krediti.adapteri;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oliver.krediti.BankiActivity;
import com.oliver.krediti.R;
import com.oliver.krediti.klasi.Banki;
import com.oliver.krediti.klasi.Krediti;
import com.oliver.krediti.klasi.NLB;
import com.oliver.krediti.listeners.OnRowKrediti;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Krediti_adapter extends RecyclerView.Adapter<Krediti_adapter.ViewHolder> {
    Context context;
    private List<Banki> notes;
    Banki banki;
    TextView textView;

//    public void setItems(ArrayList<NLB> _nlbs) {
//        nlbs = _nlbs;
//    }
//    public Krediti_adapter( ArrayList<NLB>nlbs1,Context context1,OnRowKrediti onRowKrediti) {
//        this.nlbs = nlbs1;
//        this.context = context1;
//        this.onClick = onRowKrediti;
//    }
//    public Krediti_adapter(Context context2){
//        context = context2;
//    }
//    public Krediti_adapter(OnRowKrediti onClick1){
//        this.onClick = onClick1;
//    }




    public Krediti_adapter(List<Banki> notes) {
        this.notes = notes;
    }
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
        Banki banki = notes.get(position);
        holder.textView.setText(banki.getMax_iznos());
    }

    @Override
    public int getItemCount() {
        if (notes==null){
            return 0;
        }else
        return notes.size();
    }

    public void updateList(List<Banki> notes) {
        // Allow recyclerview animations to complete normally if we already know about data changes
        if (notes.size() != this.notes.size() || !this.notes.containsAll(notes)) {
            this.notes = notes;
            notifyDataSetChanged();
        }
    }

    public void removeItem(int position) {
        notes.remove(position);
        notifyItemRemoved(position);
    }

    public Banki getItem(int position) {
        return notes.get(position);
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_na_krediti)
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
    public void bind(Banki note) {
        this.banki = note;
        textView.setText(note.getMax_iznos());
    }
}
