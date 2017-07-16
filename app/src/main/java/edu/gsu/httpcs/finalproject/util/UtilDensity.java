package edu.gsu.httpcs.finalproject.util;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by YoungH on 2/8/17.
 */

public class UtilDensity {  //this is downloaded from the teacher

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }




}
