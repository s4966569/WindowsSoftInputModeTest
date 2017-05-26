package com.example.sunpeng.windowsoftinputmodetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean mKeyBoardVisible = false;

    private TextView mBottom;

    private EditText mEdit;

    private View mContent;

    private int mContentBottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottom = (TextView) findViewById(R.id.tv_bottom);
        mEdit = (EditText) findViewById(R.id.et);
        mContent = findViewById(R.id.frame_content);
    }

    View.OnLayoutChangeListener mOnLayoutChangeListener = new  View.OnLayoutChangeListener(){

        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            if(mContent.getBottom() < mContentBottom && !mKeyBoardVisible){
                mKeyBoardVisible = true;
                mBottom.setVisibility(View.GONE);
                //此种方式中，requestLayout的时候，会报警告：在不合适的时机layout,而且在部分机型requestLayout没有效果;
                // 而在下面的OnGlobalLayoutListener中就不会出现 ，是可以正常layout的
                mContent.requestLayout();
                Log.i("state",String.valueOf(mKeyBoardVisible));
            }else if (mContent.getBottom() >= mContentBottom && mKeyBoardVisible){
                mKeyBoardVisible = false;
                mBottom.setVisibility(View.VISIBLE);
                Log.i("state",String.valueOf(mKeyBoardVisible));
            }
        }
    };

    ViewTreeObserver.OnGlobalLayoutListener onGlobalFocusChangeListener = new ViewTreeObserver.OnGlobalLayoutListener() {

        @Override
        public void onGlobalLayout() {
            if(mContent.getBottom() < mContentBottom && !mKeyBoardVisible){
                mKeyBoardVisible = true;
                mBottom.setVisibility(View.GONE);
                mContent.requestLayout();
                Log.i("state",String.valueOf(mKeyBoardVisible));
            }else if (mContent.getBottom() >= mContentBottom && mKeyBoardVisible){
                mKeyBoardVisible = false;
                mBottom.setVisibility(View.VISIBLE);
                Log.i("state",String.valueOf(mKeyBoardVisible));
            }
        }
    };

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            mContentBottom = mContent.getBottom();
//            getWindow().getDecorView().addOnLayoutChangeListener(mOnLayoutChangeListener);
            mContent.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalFocusChangeListener);
        }
    }
}
