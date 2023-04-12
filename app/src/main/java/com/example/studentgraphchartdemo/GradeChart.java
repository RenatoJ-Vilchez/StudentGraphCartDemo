package com.example.studentgraphchartdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.content.Intent;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
//I tried to make sure all of the imports and the information necessary for the graph chart to be
//displayed was correct, including the modifications conducted in the build.gradle and settings gradle//
import java.util.ArrayList;

public class GradeChart extends AppCompatActivity {
//Earlier when testing out the java codes, my emulator was display the generated graph normally
    //However, after testing it out more, it no longer shows the graph after hitting the button
    //in the MainActivity. Although, it still shows the toast message with the ratios//
    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;

//Bar Chart, Bar Data, and Bar Datset declared
    ArrayList barEntriesArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_chart);

//idBarChart android ID from XML file of GradeChart declared
        barChart = findViewById(R.id.idBarChart);


        getBarEntries();

//Grade Chart label
        barDataSet = new BarDataSet(barEntriesArrayList,
                "Grade Chart");


        barData = new BarData(barDataSet);


        barChart.setData(barData);


        barDataSet.setColors(ColorTemplate.MATERIAL_COLORS);


        barDataSet.setValueTextColor(Color.BLACK);

//One way I attempted to fix the issue regarding the bar chart not showing up was by double checking
        //if the variables for the data sets were declared correctly. In addition, I also made sure
        //the android idea from the Grade Chart XML 'idBarChart' was typed in correctly
        //as perhaps a small error would have led to the chart not being display//
        //Still, the problem stayed. However, these attempts were made.
        barDataSet.setValueTextSize(14f);

        barChart.getDescription().setEnabled(false);
        //Another solution I tried with was to lower the text value size of the BarDataSet from 20 to 14, as
        //lower levels. However, that did not solve my issue//
    }
    private void getBarEntries() {

        barEntriesArrayList = new ArrayList<>();


        Intent intent = getIntent();
        String total = intent.getStringExtra("students");
        String a = intent.getStringExtra("group a");
        String b = intent.getStringExtra("group b");
        String c = intent.getStringExtra("group c");
        String d = intent.getStringExtra("group d");
        String f = intent.getStringExtra("group f");

        barEntriesArrayList.add(new BarEntry(1f, Float.parseFloat(total.toString())));

        barEntriesArrayList.add(new BarEntry(2f, Float.parseFloat(a.toString())));

        barEntriesArrayList.add(new BarEntry(3f, Float.parseFloat(b.toString())));

        barEntriesArrayList.add(new BarEntry(4f, Float.parseFloat(c.toString())));

        barEntriesArrayList.add(new BarEntry(5f, Float.parseFloat(d.toString())));

        barEntriesArrayList.add(new BarEntry(6f, Float.parseFloat(f.toString())));
    }
}