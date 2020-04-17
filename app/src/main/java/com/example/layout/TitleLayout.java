package com.example.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;


import androidx.annotation.Nullable;

import com.example.bilibili.R;

public class TitleLayout extends LinearLayout {
    public TitleLayout(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title, this);

    }
}
