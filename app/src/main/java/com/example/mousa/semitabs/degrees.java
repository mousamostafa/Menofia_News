package com.example.mousa.semitabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class degrees extends AppCompatActivity {
    TextView showdegree;
    TextView showresult;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.degreemain);
        showdegree=(TextView)findViewById(R.id.show);
        showresult=(TextView)findViewById(R.id.showres);
        showresult.setText("Result : 408 ");
        showdegree.setText("Virtual Reailty : 78"+"\n"+"Speach Recognition : 90"+"\n"+"Digital Network : 70"+
                "\n"+"Information Network : 80"+"\n"+"Graduation Project : 90");


    }
}
