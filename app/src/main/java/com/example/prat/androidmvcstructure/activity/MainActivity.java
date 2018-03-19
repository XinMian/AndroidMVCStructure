package com.example.prat.androidmvcstructure.activity;

import android.app.Fragment;
import android.content.Context;
import android.os.Build;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.prat.androidmvcstructure.R;
import com.example.prat.androidmvcstructure.fragment.MainFragment;
import com.example.prat.androidmvcstructure.fragment.SecondFragment;
import com.example.prat.androidmvcstructure.util.ScreesUtils;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

import java.util.zip.Inflater;

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

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        if(savedInstanceState == null)
        {
            MainFragment mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentContainer);
            mainFragment.setHelloText("Woo Hoooooooo");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.toSecondFragment)
        {
            android.support.v4.app.Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.contentContainer);
            if(fragment instanceof  SecondFragment == false)
            {
                Toast.makeText(MainActivity.this, "Second Fragment", Toast.LENGTH_SHORT).show();
                //some thing after click this menu
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer, SecondFragment.newInstance())
                        .addToBackStack(null)
                        .commit();
            }


        }
        return true;
    }
}
