package com.swastikijari.intellegent_finance_app;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class PieChartDisplay extends AppCompatActivity {
    PieChart pieChart;
    BarChart barChart;
    int n;
    //Stock A
    float stockPrice[] = {18f,32f,30f,20f};
    String companyName[] = {"TCS","INFY","WIPRO","RIL"};
    //Stock B
    float stockPrice2[] = {10f,12f,14f,7f,6f,7f,4f,10f,20f,10f};
    String companyName2[] = {"HCL","INFY","TCS","RIL","SBI","HDFC","NCF","APX","JJX","ACCENT"};
    //Stock price 3
    float stockPrice3[] = {1.8f,3.2f,3.0f,2.0f,18f,12f,30f,15f,15f};
    String companyName3[] = {"MRPL.NS","HDFC","ICICI","RIL","HCL","TCS","ASIANPAINTS","RELIANCE","ARVIND"};
    //Stock B
    float stockPrice4[] = {1f,21f,10f,7f,6f,7f,4f,10f,20f,10f};
    String companyName4[] = {"MRPL","HDFC","TCS","PIL","SBI","WIPRO","ASIANPAINT","RELIANCE","ICICI","RIL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart_display);
        Intent receiveIntent = this.getIntent();
        Double average_value=  receiveIntent.getDoubleExtra("Avg", 0);
        //getting chart reference from xml
        pieChart = findViewById(R.id.piechart);
        List<PieEntry> pieEntries = new ArrayList<>();

        Log.d("A", String.valueOf(average_value));
        if (average_value >= 0 && average_value <= 25) {
            n= stockPrice.length;
            for(int i = 0;i<n;i++){
                pieEntries.add(new PieEntry(stockPrice[i],companyName[i]));

            }
        }
        if (average_value > 25 && average_value <= 50) {
            n= stockPrice2.length;
            for(int i = 0;i<n;i++){
                pieEntries.add(new PieEntry(stockPrice2[i],companyName2[i]));

            }
        }
        if (average_value > 50 && average_value <= 75) {
            n= stockPrice3.length;
            for(int i = 0;i<n;i++){
                pieEntries.add(new PieEntry(stockPrice3[i],companyName3[i]));

            }

        }
        if (average_value > 75 && average_value <= 100) {
            n= stockPrice4.length;
            for(int i = 0;i<n;i++){
                pieEntries.add(new PieEntry(stockPrice4[i],companyName4[i]));

            }
        }
        //Creating a list of data entry in Listof pieEntry

        //adding the both array data into pieEntries

        //creating a pie dataset which holds pie Entries and label assigned to it
        PieDataSet pieDataSet = new PieDataSet(pieEntries,"Stock");
        //Seting colors automatically using ColorTemplate
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        //Creating a pie Data
        PieData data = new PieData(pieDataSet);
        //Set Pie Data to xml widgid


        //Invalidate to display

        //set description


        if (average_value >= 0 && average_value <= 25) {
            // High risk factor involved
            Toast.makeText(this, "Low risk " + " " + average_value, Toast.LENGTH_LONG).show();
            pieChart.setData(data);
            data.setValueTextSize(13f);
            data.setValueTextColor(Color.DKGRAY);
            pieChart.invalidate();

        }
        if (average_value >25 && average_value <= 50) {
            // High risk factor involved
            Toast.makeText(this, "Medium risk " + " " + average_value, Toast.LENGTH_LONG).show();
            pieChart.setData(data);
            data.setValueTextSize(13f);
            data.setValueTextColor(Color.DKGRAY);
            pieChart.invalidate();

        }
        if (average_value >50 && average_value <= 75) {
            // High risk factor involved
            Toast.makeText(this, "Average risk " + " " + average_value, Toast.LENGTH_LONG).show();
            pieChart.setData(data);
            data.setValueTextSize(13f);
            data.setValueTextColor(Color.DKGRAY);
            pieChart.invalidate();

        }
        if (average_value >75 && average_value <= 100) {
            // High risk factor involved
            Toast.makeText(this, "High risk " + " " + average_value, Toast.LENGTH_LONG).show();
            pieChart.setData(data);
            data.setValueTextSize(13f);
            data.setValueTextColor(Color.DKGRAY);
            pieChart.invalidate();

        }




    }
}
