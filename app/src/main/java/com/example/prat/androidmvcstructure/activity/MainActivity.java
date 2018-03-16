package com.example.prat.androidmvcstructure.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.prat.androidmvcstructure.R;
import com.example.prat.androidmvcstructure.fragment.MainFragment;
import com.example.prat.androidmvcstructure.util.ScreesUtils;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Contextor.getInstance().init(getApplicationContext());

        int screenWidth = ScreesUtils.getInstance().getScreenWidth();
        int screenHight = ScreesUtils.getInstance().getScreenHight();

        Toast.makeText(MainActivity.this, "Width : " + screenWidth + " Hight : " + screenHight, Toast.LENGTH_SHORT).show();

        if (Build.VERSION.SDK_INT > 21) {
            //Do some thing Run on android 21+
        } else {
            //Do some thing Run on android 1-20
        }

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentContainer, new MainFragment())
                    .commit();
        } else {

        }
    }
}
