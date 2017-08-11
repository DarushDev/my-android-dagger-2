package com.example.myandroiddagger2.dagger;

import com.example.myandroiddagger2.ui.foodz.FoodzPresenter;
import com.example.myandroiddagger2.ui.foodz.FoodzPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {
    @Provides
    @Singleton
    FoodzPresenter provideFoodzPresenter() {
        return new FoodzPresenterImpl();
    }
}