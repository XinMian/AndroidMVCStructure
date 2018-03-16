package com.example.prat.androidmvcstructure.util;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class ScreesUtils {

    private static ScreesUtils instance;

    public static ScreesUtils getInstance() {
        if (instance == null)
            instance = new ScreesUtils();
        return instance;
    }

    private Context mContext;

    private ScreesUtils() {
        mContext = Contextor.getInstance().getContext();
    }

    public int getScreenWidth()
    {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.x;
    }

    public int getScreenHight()
    {
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        return size.y;
    }
}
