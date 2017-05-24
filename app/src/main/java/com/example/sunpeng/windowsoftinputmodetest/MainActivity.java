package com.example.sunpeng.windowsoftinputmodetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
            getWindow().getDecorView().addOnLayoutChangeListener(mOnLayoutChangeListener);
        }
    }
}
