package com.example.mousa.semitabs.UI;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.mousa.semitabs.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Mousa on 2/21/2018.
 */

public class open_image extends AppCompatActivity {
    ImageView imageView;
    String img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.open_image);
        imageView = (ImageView) findViewById(R.id.image);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            img = extras.getString("img");
            Picasso.with(open_image.this).load("http://mu.menofia.edu.eg/PrtlFiles/uni/Portal/Images/" + img).into(imageView);

        }
    }
}
