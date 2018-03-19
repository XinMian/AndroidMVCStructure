package com.example.prat.androidmvcstructure.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.prat.androidmvcstructure.R;
import com.example.prat.androidmvcstructure.activity.MainActivity;

/**
 * Created by Prat on 3/16/2018.
 */

public class MainFragment extends Fragment {

    TextView textviewHello;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        initInstances(rootView);


        return rootView;
    }

    private void initInstances(View view)
    {
        textviewHello = view.findViewById(R.id.textviewHello);
    }

    public void setHelloText(String text)
    {
        textviewHello.setText(text);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null)
        {

        }
    }
}
