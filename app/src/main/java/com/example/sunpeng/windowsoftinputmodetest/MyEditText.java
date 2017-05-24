package com.example.sunpeng.windowsoftinputmodetest;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by sunpeng on 2017/5/24.
 */

public class MyEditText extends EditText {
    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
    }


}
