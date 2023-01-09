package com.example.ssv2;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Animation topAnim;
    Animation bottomAnim;
    ImageView imageView;
    TextView titletv, descriptiontv;

    private static int SPLASH_TIME_OUT=4000;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        imageView = findViewById(R.id.imageView);
        titletv = findViewById(R.id.titletv);
        descriptiontv = findViewById(R.id.descriptiontv);

        imageView.setAnimation(topAnim);
        titletv.setAnimation(bottomAnim);
        descriptiontv.setAnimation(bottomAnim);

        new Handler().postDelayed(()-> {
            Intent intent = new Intent(MainActivity.this, MainApp.class);

            Pair[] pairs = new Pair[2];
            pairs[0] = new Pair<View, String>(imageView,"logo_image");
            pairs[1] = new Pair<View, String>(titletv,"logo_text");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
            startActivity(intent, options.toBundle());
        }, SPLASH_TIME_OUT);
    }
}