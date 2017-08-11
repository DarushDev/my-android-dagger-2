package com.example.myandroiddagger2.dagger;

import com.example.myandroiddagger2.ui.food.FoodActivity;
import com.example.myandroiddagger2.ui.food.FoodPresenterImpl;
import com.example.myandroiddagger2.ui.foodz.FoodzActivity;
import com.example.myandroiddagger2.ui.foodz.FoodzPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, PresenterModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(FoodzActivity target);

    void inject(FoodActivity target);

    void inject(FoodzPresenterImpl target);

    void inject(FoodPresenterImpl target);
}
