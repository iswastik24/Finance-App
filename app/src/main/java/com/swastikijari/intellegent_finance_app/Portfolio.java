package com.swastikijari.intellegent_finance_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.PieChart;

import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Portfolio extends AppCompatActivity {
    RadioButton a, b, c, d;
    LinearLayout l;
    RadioGroup rg;
    int q, s;
    Button bt;
    TextView tv_display, tv_count, tv1_graph;
    // declaring 4 integer variables which stores risk factors
    private int m = 0, n = 0, o = 0, p = 0;
    private double avg = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        //initilization of widgits
        tv_display = findViewById(R.id.tv_display);
        tv_count = findViewById(R.id.r_count);
        //Radio group and radio button
        rg = (RadioGroup) findViewById(R.id.radio_option);
        a = (RadioButton) findViewById(R.id.r1);
        b = (RadioButton) findViewById(R.id.r2);
        c = (RadioButton) findViewById(R.id.r3);
        d = (RadioButton) findViewById(R.id.r4);
        //Next button
        bt = (Button) findViewById(R.id.btn_next);
        l = findViewById(R.id.linear_layout);
        a.setVisibility(View.INVISIBLE);
        b.setVisibility(View.INVISIBLE);
        d.setVisibility(View.INVISIBLE);
        c.setVisibility(View.INVISIBLE);
        l.animate().scaleXBy(0.2f).scaleYBy(0.5f).setDuration(2000).start();
        q = 0;
        s = 0;
    }

    public void quiz(View v) {

        switch (q) {
            case 0: {
                bt.setText("Next");
                rg.setVisibility(View.VISIBLE);
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                a.setVisibility(View.VISIBLE);
                b.setVisibility(View.VISIBLE);
                d.setVisibility(View.VISIBLE);
                c.setVisibility(View.VISIBLE);
                l.setVisibility(View.INVISIBLE);
                a.setEnabled(true);
                b.setEnabled(true);
                c.setEnabled(true);
                d.setEnabled(true);

                s = 0;

                tv_display.setText("My goal for this account is to  _____");
                a.setText("Prepare for retirement");
                b.setText("Save for major upcomming expenses(Education,Health,Car,House)");
                c.setText("Build a rain day fund for emergencies");
                d.setText("Build long term wealth");

                if (a.isChecked()) {
                    m = m + 25;
                } else if (b.isChecked()) {
                    n += 100;
                } else if (c.isChecked()) {
                    o += 75;
                } else {
                    p += 50;
                }

                q = 1;
                tv_count.setText(Integer.toString(q));

                break;
            }
            case 1: {

                tv_display.setText("i have __ understanding of stocks bonds and ETFs");
                a.setText("No");
                b.setText("Some");
                c.setText("Good");
                d.setText("extensive");
                if (a.isChecked()) {
                    m = m + 25;
                } else if (b.isChecked()) {
                    n += 50;
                } else if (c.isChecked()) {
                    o += 75;
                } else {
                    p += 100;
                }

                q = 2;
                tv_count.setText(Integer.toString(q));

                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                break;
            }
            case 2: {
                tv_display.setText("when i hear risk related to my finances ____");
                a.setText("i wory i could be left with nothing");
                b.setText("i understand that its an inherent part of investnment ");
                c.setText("i see opportunity for great returns");
                d.setText("i think of the thrill of investing");
                if (a.isChecked()) {
                    m = m + 100;
                } else if (b.isChecked()) {
                    n += 75;
                } else if (c.isChecked()) {
                    o += 50;
                } else {
                    p += 25;
                }


                q = 3;

                tv_count.setText(Integer.toString(q));
                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                break;
            }
            case 3: {

                tv_display.setText("How much % of return r u expecting for your investnment in first year ");
                a.setText("10% - 20%");
                b.setText("20% - 30%");
                c.setText("30% - 40%");
                d.setText("50% and above");
                a.setTag("25");
                b.setTag("50");
                c.setTag("75");
                d.setTag("100");
                if (a.isChecked()) {
                    m = m + 75;
                } else if (b.isChecked()) {
                    n += 100;
                } else if (c.isChecked()) {
                    o += 25;
                } else {
                    p += 50;
                }
                q = 4;
                tv_count.setText(Integer.toString(q));

                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                break;
            }
            case 4: {
                tv_display.setText("When it comes to making important financial decisions___\n");
                a.setText("i try to avoid making decisions");
                b.setText("i reluctraty make decisions");
                c.setText("i confidently make decisions and dont look back");
                d.setText("i ask some one");

                if (a.isChecked()) {
                    m = m + 75;
                } else if (b.isChecked()) {
                    n += 100;
                } else if (c.isChecked()) {
                    o += 25;
                } else {
                    p += 50;
                }
                q = 5;
                tv_count.setText(Integer.toString(q));

                a.setChecked(false);
                b.setChecked(false);
                c.setChecked(false);
                d.setChecked(false);
                bt.setText("Finish");

                break;
            }
            case 5: {
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                tv_display.setText("");

                //calculating the average of all risk points and adding to get an average points
                avg = (m / 5) + (n / 5) + (o / 5) + (p / 5);
                Log.d("A", String.valueOf(avg));
                if (avg > 0 && avg <= 100) {
                   Intent ip1  = new Intent(Portfolio.this,PieChartDisplay.class);
                   ip1.putExtra("Avg",avg);
                   startActivity(ip1);
                }
                //Low risk 25 points
                //high risk 100 points

                bt.setVisibility(View.INVISIBLE);
                a.setVisibility(View.INVISIBLE);
                b.setVisibility(View.INVISIBLE);
                d.setVisibility(View.INVISIBLE);
                c.setVisibility(View.INVISIBLE);

                q = 0;
                break;
            }
        }
    }

}