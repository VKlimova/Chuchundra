package com.amargodigits.vklimova.chuchundra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelectDogDress extends AppCompatActivity {
    String CurDog="";
    String CurDress="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_dog_dress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentManager manager = getFragmentManager();
                //getSupportFragmentManager();
                MainActivity.MyDialogFragment myDialogFragment = new MainActivity.MyDialogFragment();
                myDialogFragment.show(manager, "dialog");
            }
        });
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onTryClick(View view) {
        if (CurDog!="" && CurDress!=""){
            Intent DogChooseIntent = new Intent(SelectDogDress.this, InDressActivity.class);
            //      String CurDog = "Dog1";
            DogChooseIntent.putExtra("Dog", CurDog);
            DogChooseIntent.putExtra("Dress", CurDress);
            startActivity(DogChooseIntent);
        } else {

            Toast toast = Toast.makeText(getApplicationContext(),
                    R.string.selectdogdress, Toast.LENGTH_SHORT);
            toast.show();
        }

    }



    public void onDogClick(View v) {
        ImageButton Btn1=(ImageButton) findViewById(R.id.iBtnDog1);
        ImageButton Btn2=(ImageButton) findViewById(R.id.iBtnDog2);
        ImageButton Btn3=(ImageButton) findViewById(R.id.iBtnDog3);
        Btn1.setAlpha((float) 0.3);
        Btn2.setAlpha((float) 0.3);
        Btn3.setAlpha((float) 0.3);



        switch (v.getId()) {
            case R.id.iBtnDog1:Btn1.setAlpha((float)1); CurDog = "1"; break;
            case R.id.iBtnDog2:Btn2.setAlpha((float)1); CurDog = "2"; break;
            case R.id.iBtnDog3:Btn3.setAlpha((float)1); CurDog = "3"; break;
        }

    }

    public void onDressClick(View v) {
        ImageButton Btn1=(ImageButton) findViewById(R.id.iBtnDress1);
        ImageButton Btn2=(ImageButton) findViewById(R.id.iBtnDress2);
        ImageButton Btn3=(ImageButton) findViewById(R.id.iBtnDress3);
        Btn1.setAlpha((float) 0.3);
        Btn2.setAlpha((float) 0.3);
        Btn3.setAlpha((float) 0.3);

        switch (v.getId()) {
            case R.id.iBtnDress1:Btn1.setAlpha((float)1); CurDress = "1"; break;
            case R.id.iBtnDress2:Btn2.setAlpha((float)1); CurDress = "2"; break;
            case R.id.iBtnDress3:Btn3.setAlpha((float)1); CurDress = "3"; break;
        }
    }

}
