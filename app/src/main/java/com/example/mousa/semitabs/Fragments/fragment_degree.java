package com.example.mousa.semitabs.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mousa.semitabs.R;
import com.example.mousa.semitabs.degrees;

import static com.example.mousa.semitabs.UI.Start.flag;

/**
 * Created by Mousa on 2/11/2018.
 */

public class fragment_degree extends Fragment {

    Spinner faculty;
    Spinner term;
    EditText code;
    Button toegree;
    ArrayAdapter<String> spinerfaculty;
    ArrayAdapter<String> spinerterm;

    public fragment_degree() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.mainresult,container,false);
       faculty=(Spinner)view.findViewById(R.id.spinner_fac);;
        term=(Spinner)view.findViewById(R.id.spinner_year);;
       code=(EditText) view.findViewById(R.id.cod);
       toegree=(Button)view.findViewById(R.id.res_btn);
       String[] facarab={"كلية","الحاسبات والمعلومات","علوم","تجارة","اداب","حقوق"};
       String[] facen={"Faculty","Computer and information","Science","Commerce","Literature","Law"};

       String[] year={"الفرقة","الاولى","الثانية ","الثالثة","الرابعة"};
       String[]yearen={"year","First","Second","third","fourth"};
       if(flag==1){
           spinerfaculty=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,facarab);
           spinerterm=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,year);
           faculty.setAdapter(spinerfaculty);
           term.setAdapter(spinerterm);
       }
       else if(flag==2){
           spinerfaculty=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,facen);
           spinerterm=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,yearen);
           faculty.setAdapter(spinerfaculty);
           term.setAdapter(spinerterm);

       }
       toegree.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(code.getText().toString().equals("13452")) {
                   Intent intent = new Intent(getActivity(), degrees.class);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(getActivity(),"Sorry Not Available",Toast.LENGTH_SHORT).show();
               }
           }
       });


return view;
    }
}

