package com.test.myfirst.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class detailsactivity extends AppCompatActivity {
    ImageView pimg;
    //TextView pname,pdesc,pheight,ptype,pability,pweight,description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desc);



        pimg = findViewById(R.id.desc_imag);


        Intent i = getIntent();
        pokemon p= i.getParcelableExtra("Pokemon");


        //Glide.with(this).load(p.getImage().

        System.out.println(p.getImage());

    }
}
