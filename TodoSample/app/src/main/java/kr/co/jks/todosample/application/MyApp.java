package kr.co.jks.todosample.application;

import android.app.Application;

import com.facebook.stetho.Stetho;

import kr.co.jks.todosample.logic.local.AppDatabaseProvider;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initRoom();
        initSteho();
    }

    private void initSteho() {
        Stetho.initializeWithDefaults(this);
    }

    private void initRoom() {
        // 1회 생성
        AppDatabaseProvider.getINSTANCE(getApplicationContext());
    }


}
