package com.example.myandroiddagger2.app;

import android.app.Application;

import com.example.myandroiddagger2.dagger.AppComponent;
import com.example.myandroiddagger2.dagger.AppModule;
import com.example.myandroiddagger2.dagger.DaggerAppComponent;

public class DeezFoodzApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);
    }

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(DeezFoodzApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }

}
