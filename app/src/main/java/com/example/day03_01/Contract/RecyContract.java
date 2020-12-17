package com.example.day03_01.Contract;

import com.example.day03_01.Bean.NewsBean;
import com.example.day03_01.ImCallback.MainCallBack;

public class RecyContract {

    public interface ModleContract{
        <T> void getModle(String url, MainCallBack<T> callBack);
    }

    public interface PreContract{

        void getData();
    }
    public interface ViewContract{

        void onSussec(NewsBean newsBean);

    }
}
