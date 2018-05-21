package com.oliver.krediti;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.oliver.krediti.klasi.Banki;

public class BankiActivity extends AppCompatActivity {
    private static final String EXTRA_NOTE = "NOTE";

    private DatabaseReference database;
    private TextView titleTextView;
    private Banki banki;
    public static Intent newInstance(Context context, Banki banki) {
        Intent intent = new Intent(context, BankiActivity.class);
        if (banki != null) {
            intent.putExtra(EXTRA_NOTE, banki);
        }

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banki);

        database = FirebaseDatabase.getInstance().getReference();

        titleTextView = (TextView) findViewById(R.id.note_title);
        banki = getIntent().getParcelableExtra(EXTRA_NOTE);
        if (banki != null) {
            titleTextView.setText(banki.getMax_iznos());
        }
    }
}
