 package com.oliver.krediti;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.oliver.krediti.adapteri.Krediti_adapter;
import com.oliver.krediti.klasi.Banki;
import com.oliver.krediti.klasi.Krediti;
import com.oliver.krediti.klasi.NLB;
import com.oliver.krediti.listeners.OnRowKrediti;
import com.oliver.krediti.model.Krediti_model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

 public class PocetnoActivity extends AppCompatActivity {
    @BindView(R.id.MyRV)RecyclerView rv;
    Context context;
   public Krediti_adapter adapter;
//    @BindView (R.id.tekst2)
//    android.widget.TextView vtoro;
//    @BindView (R.id.tekst3)
//    android.widget.TextView treto;
//    @BindView (R.id.tekst4)
//    android.widget.TextView cetrvrto;
//    @BindView (R.id.tekst5)
//    android.widget.TextView petto;

//    public Krediti krediti;
//    public Krediti_model model;
//     List<Krediti> kreditiList = new ArrayList<>();
//     ArrayList<NLB>nlbs = new ArrayList<>();
//     @BindView(R.id.tekst1)
//     android.widget.TextView prvo;
     DatabaseReference database;
     private DatabaseReference reference;
     DataSnapshot dataSnapshot;
     String TAG = "";
     public List<Banki>bankis;
     int position;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetno);
        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

        database = FirebaseDatabase.getInstance().getReference();
        adapter = new Krediti_adapter(Collections.<Banki>emptyList());
//        adapter.getItem(position);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);







//        prvo.setText("ПОТРОШУВАЧКИ КРЕДИТИ");
//        vtoro.setText("СТАНБЕНИ КРЕДИТИ");
//
//        prvo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(PocetnoActivity.this,VtoraStrana.class);
//                startActivity(intent);
//            }
//        });
//        vtoro.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent2 = new Intent(PocetnoActivity.this,VtoraStrana.class);
//                startActivity(intent2);
//            }
//        });
        ;

//        GenericTypeIndicator<Map<String, List<Krediti>>> genericTypeIndicator = new GenericTypeIndicator<Map<String, List<Krediti>>>() {};
//        Map<String, List<Krediti>> hashMap = dataSnapshot.getValue(genericTypeIndicator);
//
//        for (Map.Entry<String,List<Krediti>> entry : hashMap.entrySet()) {
//            List<Krediti> educations = entry.getValue();
//            for (Krediti education: educations){
//                Log.i(TAG, education.naziv);
//
//            }
//        }


//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        mDatabase = FirebaseDatabase.getInstance();
//        reference = mDatabase.getReference("Banki");
//        mDatabase.child("pederski").child("pederPrv").child("uuu").child("kamata").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String playerName = dataSnapshot.getValue(String.class);
//                prvo.setText(playerName);
//                prvo.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(PocetnoActivity.this,VtoraStrana.class);
//                        startActivity(intent);
//                    }
//                });
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
//        mDatabase.child("stanben").child("portokalov").child("kamata").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                String kamata = dataSnapshot.getValue(String.class);
//                vtoro.setText(kamata);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

     @Override
     protected void onResume() {
         super.onResume();

         database.child("Banki").child("NLB").child("Krediti").child("Potrosuvacki").addValueEventListener(new ValueEventListener() {
             @Override
             public void onDataChange(DataSnapshot dataSnapshot) {
                 List<Banki> notes = new ArrayList<>();
                 for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                     Banki note = noteDataSnapshot.getValue(Banki.class);
                     notes.add(note);
                 }

                 adapter.updateList(notes);
                 adapter.notifyDataSetChanged();
             }

             @Override
             public void onCancelled(DatabaseError databaseError) {

             }
         });

     }
//    private void LoadData(DatabaseReference reference){
//        reference.setValue(Krediti_model.getKrediti)
//
//    }


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
