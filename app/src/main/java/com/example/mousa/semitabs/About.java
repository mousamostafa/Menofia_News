package com.example.mousa.semitabs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mousa.semitabs.Adapters.Adapter_Leader;
import com.example.mousa.semitabs.Adapters.Adpt;
import com.example.mousa.semitabs.UI.Start;

import static com.example.mousa.semitabs.UI.Start.flag;

public class About extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.LayoutManager layoutManagerr;
    RecyclerView ree;
    TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        recyclerView=(RecyclerView)findViewById(R.id.recyleabout);
        textView=(TextView) findViewById(R.id.leadership);
        ree=(RecyclerView)findViewById(R.id.recyleleader);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        layoutManagerr = new LinearLayoutManager(getApplicationContext(), LinearLayout.HORIZONTAL,false);
        ree.setLayoutManager(layoutManagerr);
        ree.setHasFixedSize(true);
        String [] carab={"نشأةالجامعة ","رؤية الجامعة ","رسالة الجامعة","دليل الجامعة","اتصل بنا"};
        String [] cen={"History","University vision","University Message","University Directory","Contact Us"};
        String [] info={"http://www.menofia.edu.eg/View/576/ar","http://www.menofia.edu.eg/View/577/ar","http://www.menofia.edu.eg/View/578/ar",
                "http://www.menofia.edu.eg/View/584/ar","http://www.menofia.edu.eg/View/643/ar"};
        String[] leadname={"أ.د/ معوض محمدالخولى"+"\n"+"رئيس الجامعة","أ.د/ عادل السيد صادق مبارك"+"\n"+"نائب رئيس الجامعة لشئون التعليم والطلاب"
        ,"أ.د/ أحمد فرج القاصــد"+"\n"+"نائب رئيس الجامعة للدراسات العليا والبحوث","أ.د/ عبدالرحمن السيد قرمان"+"\n"+"نائب رئيس الجامعة لشئون خدمة المجتمع وتنمية البيئة"};

        String[] leadnameen={"Prof.Dr /Moawad Mohamed El-Kholy"+"\n"+"University President","Prof.Dr /Adel El-Sayed Sadek Moubark"+"\n"+"Vice-President For Education&Students Affairs",
                "Prof.Dr /Ahmed Farag El-Kased"+"\n"+"Vice-President For Post Graduate Studies&Research",
                "Prof.Dr /Abd-El Rahman El-Sayed Korman"+"\n"+"Vice-President For Community Service&Environmental Affairs"};

        int[] imgleader={R.drawable.mawad,R.drawable.mobark,R.drawable.farag,R.drawable.arman};
        int[] img={R.drawable.buildin,R.drawable.if_simpline_9_2305588,R.drawable.if_contact_372892,R.drawable.if_30_940973
        ,R.drawable.contactus};
        if(flag==1){
            textView.setText("قيادات الجامعة");
            Adapter_Leader adapter_leader=new Adapter_Leader(leadname,imgleader,getApplicationContext());
            Adpt adpt=new Adpt(carab,info,img,getApplicationContext());
            recyclerView.setAdapter(adpt);
            ree.setAdapter(adapter_leader);

        }
        else if(flag==2){
            textView.setText("University leaders");
            Adapter_Leader adapter_leader=new Adapter_Leader(leadnameen,imgleader,getApplicationContext());
            Adpt adpt=new Adpt(cen,info,img,getApplicationContext());
            recyclerView.setAdapter(adpt);
            ree.setAdapter(adapter_leader);
        }

    }

}
