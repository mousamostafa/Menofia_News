package com.example.mousa.semitabs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Login extends AppCompatActivity {
    TextInputEditText user,pass;
    Button logg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        user=(TextInputEditText) findViewById(R.id.email);
        pass=(TextInputEditText) findViewById(R.id.password);
        logg=(Button)findViewById(R.id.log);

        logg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
                if(user.getText().toString().equals("ah.z.afifi@gmail.com") & pass.getText().toString().equals("P@$$w0rd")){
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(getApplicationContext(),Add_News.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(),"Not allowed",Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
    private void login(){
        if(TextUtils.isEmpty(user.getText().toString().trim())|| TextUtils.isEmpty(pass.getText().toString().trim())){
            user.setError("Fields can't be Empty");
            pass.setError("Fields can't be Empty");
        }
        else if(!emailValidator(user.getText().toString())){
            user.setError("Please Enter Vali Email Address");
        }
        else {

        }
    }
    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN="^[_A-ZA-z0-9-]+(\\.[_A-za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern=Pattern.compile(EMAIL_PATTERN);
        matcher=pattern.matcher(email);
        return matcher.matches();
    }


}
