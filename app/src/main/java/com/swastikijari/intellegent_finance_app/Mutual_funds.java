package com.swastikijari.intellegent_finance_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Mutual_funds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mutual_funds);
        ImageView ma = findViewById(R.id.ma);
        ImageView mb = findViewById(R.id.mb);
        ImageView mc = findViewById(R.id.mc);
        ImageView md = findViewById(R.id.md);

        ma.animate().rotationBy(720f).setDuration(2000);
        mb.animate().translationYBy(100).translationYBy(-100).setDuration(1000);
        mc.animate().translationYBy(100).translationYBy(-100).setDuration(1000);
        md.animate().translationYBy(100).translationYBy(-100).setDuration(1000);

    }
}
