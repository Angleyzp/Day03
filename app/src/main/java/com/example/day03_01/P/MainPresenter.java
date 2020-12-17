package com.example.day03_01.P;

import com.example.day03_01.Bean.NewsBean;
import com.example.day03_01.Contract.RecyContract;
import com.example.day03_01.ImCallback.MainCallBack;
import com.example.day03_01.M.Model;
import com.example.day03_01.MainActivity;
import com.example.day03_01.Net.NetContract;

public class MainPresenter implements RecyContract.PreContract {

    private RecyContract.ViewContract viewContract;
    private RecyContract.ModleContract modleContract;


    public MainPresenter(RecyContract.ViewContract viewContract) {

        this.viewContract = viewContract;
        modleContract=new Model(this);
    }

    @Override
    public void getData() {
        modleContract.getModle(NetContract.BASEURL, new MainCallBack<NewsBean>() {
            @Override
            public void OnSussec(NewsBean newsBean) {
                viewContract.onSussec(newsBean);
            }

            @Override
            public void OnFail(String error) {

            }
        });
    }
}
