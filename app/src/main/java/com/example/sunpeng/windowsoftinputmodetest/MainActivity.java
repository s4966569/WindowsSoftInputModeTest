package com.example.sunpeng.windowsoftinputmodetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean mIsShowing = false;

    private TextView mBottom;

    private EditText mEdit;

    private View mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottom = (TextView) findViewById(R.id.tv_bottom);
        mEdit = (EditText) findViewById(R.id.et);
        mContent = findViewById(R.id.frame_content);
//        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,ContentFragment.getInstance()).commit();
        mEdit.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(!mIsShowing){
                    mBottom.setVisibility(View.GONE);
                }
                return false;
            }
        });

        mContent.addOnLayoutChangeListener(mOnLayoutChangeListener);
    }

    View.OnLayoutChangeListener mOnLayoutChangeListener = new  View.OnLayoutChangeListener(){

        @Override
        public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            if(bottom < oldBottom){
                mIsShowing = true;
                Log.i("state",String.valueOf(mIsShowing));
            }else {
                mIsShowing = false;
                mContent.removeOnLayoutChangeListener(this);
                mBottom.setVisibility(View.VISIBLE);
                Log.i("state",String.valueOf(mIsShowing));
                mContent.addOnLayoutChangeListener(this);
            }
        }
    };
}
