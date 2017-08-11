package com.example.myandroiddagger2.app;

import android.app.Application;

import com.example.myandroiddagger2.dagger.AppComponent;
import com.example.myandroiddagger2.dagger.AppModule;
import com.example.myandroiddagger2.dagger.DaggerAppComponent;

public class DeezFoodzApplication extends Application {

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = initDagger(this);
    }

    protected AppComponent initDagger(DeezFoodzApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}