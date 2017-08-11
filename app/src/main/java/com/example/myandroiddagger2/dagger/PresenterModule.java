package com.example.myandroiddagger2.dagger;

import android.content.Context;

import com.example.myandroiddagger2.ui.food.FoodPresenter;
import com.example.myandroiddagger2.ui.food.FoodPresenterImpl;
import com.example.myandroiddagger2.ui.foodz.FoodzPresenter;
import com.example.myandroiddagger2.ui.foodz.FoodzPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PresenterModule {

    @Provides
    @Singleton
    FoodzPresenter provideFoodzPresenter(Context context) {
        return new FoodzPresenterImpl(context);
    }

    @Provides
    @Singleton
    FoodPresenter provideFoodPresenter(Context context) {
        return new FoodPresenterImpl(context);
    }
}

