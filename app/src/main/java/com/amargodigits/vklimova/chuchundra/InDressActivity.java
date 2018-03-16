package com.amargodigits.vklimova.chuchundra;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class InDressActivity extends AppCompatActivity {
    private int oldDrawable, newDrawable;
    private final Handler Myhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            String DogTxt = getIntent().getExtras().getString("Dog");
            String DressTxt = getIntent().getExtras().getString("Dress");
            String curModel = DogTxt + DressTxt;
            ImageView DoginDressImageView = (ImageView) findViewById(R.id.imgDogInDress);

            final ImageView DognoDressImageView = (ImageView) findViewById(R.id.imgDogNoDress);

            switch (DogTxt) {
                case "1": oldDrawable = R.drawable.bokser_; break;
                case "2": oldDrawable = R.drawable.cannan_; break;
                case "3": oldDrawable = R.drawable.amstaf_; break;
            }

            switch (curModel) {
                case "11": newDrawable=R.drawable.bokser_azurro;    break;
                case "12": newDrawable=R.drawable.bokser_snow;      break;
                case "13": newDrawable=R.drawable.bokser_pink;      break;
                case "21": newDrawable=R.drawable.cannan_azzuro;    break;
                case "22": newDrawable=R.drawable.cannan_snow;      break;
                case "23": newDrawable=R.drawable.cannan_pink;      break;
                case "31": newDrawable=R.drawable.amstaf_azzurro;   break;
                case "32": newDrawable=R.drawable.amstaf_snow;      break;
                case "33": newDrawable=R.drawable.amstaf_pink;      break;
            }


            DoginDressImageView.setImageResource(newDrawable);
            DognoDressImageView.setImageResource(oldDrawable);

            DoginDressImageView.setVisibility(View.GONE);
            // Retrieve and cache the system's default "short" animation time.
            int mLongAnimationDuration = 5000;
            int mMediumAnimationDuration = 2500;
            int mShortAnimationDuration = 1000;
            // Set the content view to 0% opacity but visible, so that it is visible
            // (but fully transparent) during the animation.
            DoginDressImageView.setAlpha(0f);
            DoginDressImageView.setVisibility(View.VISIBLE);
            DognoDressImageView.setAlpha(1f);
            DognoDressImageView.setVisibility(View.VISIBLE);

            // Animate the content view to 100% opacity, and clear any animation
            // listener set on the view.

            DoginDressImageView.animate()
                    .alpha(1f)
                    .setDuration(mMediumAnimationDuration)
                    .setListener(null);

/*
            DoginDressImageView.setAlpha(0.5f);
            DoginDressImageView.setVisibility(View.VISIBLE);
            DognoDressImageView.setAlpha(1f);
            DognoDressImageView.setVisibility(View.VISIBLE);

            // Animate the content view to 100% opacity, and clear any animation
            // listener set on the view.
            DoginDressImageView.animate()
                    .alpha(1f)
                    .setDuration(mLongAnimationDuration)
                    .setListener(null);
*/
            Button BuyBtn = (Button) findViewById(R.id.BuyBtn);
            BuyBtn.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_dress);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button BuyBtn = (Button) findViewById(R.id.BuyBtn);

        setSupportActionBar(toolbar);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                android.app.FragmentManager manager = getFragmentManager();
                MainActivity.MyDialogFragment myDialogFragment = new MainActivity.MyDialogFragment();
                myDialogFragment.show(manager, "dialog");
            }
        });
        fab.setVisibility(View.INVISIBLE);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BuyBtn.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          String iurl = getString(R.string.action_shop_link);
                                          Intent i2 = new Intent(Intent.ACTION_VIEW, Uri.parse(iurl));
                                          i2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                          i2.setPackage("com.android.chrome");
                                          try {
                                              startActivity(i2);
                                          } catch (android.content.ActivityNotFoundException e) {
                                              // Chrome is probably not installed
                                              // Try with the default browser
                                              i2.setPackage(null);
                                              startActivity(i2);
                                      }
                                  }});

        Runnable Myrunnable = new Runnable() {
            public void run() {
                long endTime = System.currentTimeMillis();
                while (System.currentTimeMillis() < endTime) {
                    synchronized (this) {
                        try {
                            wait(endTime -
                                    System.currentTimeMillis());
                        } catch (Exception ignored) {
                        }
                    }
                }
                Myhandler.sendEmptyMessage(0);

            }
        };

        Thread thread = new Thread(Myrunnable);
        thread.start();



    }

    }
