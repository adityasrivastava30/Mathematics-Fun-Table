package com.android.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
public void generateTable(int TimeTableNumber)
{
    ListView timeView=findViewById(R.id.ListView);
    ArrayList<String>timetableContent=new ArrayList<String>();
    for(int i=1 ; i<=10 ; i++)
    {
        timetableContent.add(Integer.toString(i*TimeTableNumber));
    }
    ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line,timetableContent);
    timeView.setAdapter(arrayAdapter);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timeTables=findViewById(R.id.seekBar);
        ListView timeView=findViewById(R.id.ListView);
        int max=20;
        int starting=1;
        timeTables.setMax(max);
        timeTables.setProgress(starting);
        generateTable(starting);
        timeTables.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTableNumber = 0;
                if (progress<min)
                {
                    timeTables.setProgress(min);
                }
                else
                    timesTableNumber=progress;
                //Log.i("seekbar", Integer.toString(timesTableNumber));
                generateTable(timesTableNumber);
                
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }

        });
       // ArrayList<int>arrayList=new ArrayList<int>()
    }
}