package com.example.day03_01.Net;

import com.example.day03_01.Api.ApiService;
import com.example.day03_01.ImCallback.ImInteface;
import com.example.day03_01.ImCallback.MainCallBack;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetrofitUtils implements ImInteface {
    private static RetrofitUtils retrofitUtils;
    private final ApiService apiService;

    public RetrofitUtils() {
        Retrofit build = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(NetContract.NEWURL)
                .build();
        apiService = build.create(ApiService.class);
    }

    public static RetrofitUtils getRetrofitUtils() {
        if (retrofitUtils==null){
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null){
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    @Override
    public <T> void getData(String url, MainCallBack<T> callBack) {
            apiService.getData(url)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(@NonNull Disposable d) {

                        }

                        @Override
                        public void onNext(@NonNull ResponseBody responseBody) {
                            try {
                                String string = responseBody.string();
                                Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                                Type[] types = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                                Type t = types[0];
                                T result = new Gson().fromJson(string, t);

                                callBack.OnSussec(result);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(@NonNull Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
    }
}
