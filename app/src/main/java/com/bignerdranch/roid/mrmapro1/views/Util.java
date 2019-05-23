package com.bignerdranch.roid.mrmapro1.views;

import android.content.Context;

public class Util {

    public static float PxToDp(Context context, float px) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float DpToPx(Context context, float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}
