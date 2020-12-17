package com.example.day03_01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day03_01.Base.BaseActivity;
import com.example.day03_01.Bean.NewsBean;
import com.example.day03_01.Contract.RecyContract;
import com.example.day03_01.P.MainPresenter;
import com.example.day03_01.adapter.Adapter;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPresenter> implements RecyContract.ViewContract {

    private RecyclerView recy;
    private ArrayList<NewsBean.NewsDTO> list;
    private Adapter adapter;

    @Override
    protected void initView() {
        recy = findViewById(R.id.recy);
        recy.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        adapter = new Adapter(this,list);
        recy.setAdapter(adapter);
    }

    @Override
    protected void initData() {
        Per.getData();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresenter getPer() {
        return new MainPresenter(this);
    }

    @Override
    public void onSussec(NewsBean newsBean) {
        list.addAll(newsBean.getNews());
        adapter.notifyDataSetChanged();
    }
}