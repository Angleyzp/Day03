package com.example.day03_01.Base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity<T> extends AppCompatActivity {
        public T Per;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        if (Per==null){
            Per = getPer();
        }
        initData();
        initView();
    }
    protected abstract void initView();
    protected abstract void initData();
    protected abstract int getLayoutID();
    public abstract T getPer();
}
