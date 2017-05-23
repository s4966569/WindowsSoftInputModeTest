package com.example.sunpeng.windowsoftinputmodetest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sunpeng on 2017/5/23.
 */

public class ContentFragment extends Fragment {

    public static ContentFragment getInstance(){
        return new ContentFragment();
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frg_content,container,false);
    }
}
