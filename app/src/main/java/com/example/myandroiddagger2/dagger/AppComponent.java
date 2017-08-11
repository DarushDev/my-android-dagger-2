package com.example.myandroiddagger2.dagger;

import com.example.myandroiddagger2.ui.foodz.FoodzActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class})
public interface AppComponent {
    void inject(FoodzActivity target);

}
