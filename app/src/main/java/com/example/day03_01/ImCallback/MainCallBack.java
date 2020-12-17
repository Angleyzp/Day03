package com.example.day03_01.ImCallback;

public interface MainCallBack<T> {
    void OnSussec(T t);
    void OnFail(String error);
}
