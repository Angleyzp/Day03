package com.example.day03_01.M;

import com.example.day03_01.Contract.RecyContract;
import com.example.day03_01.ImCallback.MainCallBack;
import com.example.day03_01.Net.RetrofitUtils;
import com.example.day03_01.P.MainPresenter;

public class Model implements RecyContract.ModleContract {

    private RecyContract.PreContract presenter;

    public Model(RecyContract.PreContract presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void getModle(String url, MainCallBack<T> callBack) {
        RetrofitUtils.getRetrofitUtils().getData(url,callBack);
    }
}
