 package com.oliver.krediti;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.oliver.krediti.adapteri.Krediti_adapter;
import com.oliver.krediti.klasi.Krediti;
import com.oliver.krediti.listeners.OnRowKrediti;
import com.oliver.krediti.model.Krediti_model;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

 public class PocetnoActivity extends AppCompatActivity {
    @BindView(R.id.MyRV)RecyclerView rv;
    Context context;
   public Krediti_adapter adapter;
    public Krediti krediti;
    public Krediti_model model;
     List<Krediti> kreditiList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetno);
        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);
        adapter =  new Krediti_adapter(kreditiList, context, new OnRowKrediti() {
            @Override
            public void onRowClick(Krediti krediti, int position) {
                Intent intent = new Intent(PocetnoActivity.this,VtoraStrana.class);
                intent.putExtra("kredit",krediti.naziv);
                startActivity(intent);
            }
        });


        adapter.setItems(generateList());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
     ArrayList<Krediti> generateList() {
         ArrayList<Krediti> kreditis = new ArrayList<>();

         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Goran"));
         kreditis.add(new Krediti("Pane"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         kreditis.add(new Krediti("Oliver"));
         return kreditis;
     }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pocetno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
