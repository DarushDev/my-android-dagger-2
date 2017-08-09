package com.example.myandroiddagger2.ui.food;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import com.example.myandroiddagger2.model.Food;


public interface FoodPresenter {
  void setView(FoodView view);

  void getFood(String foodId);

  @ColorRes
  int getFoodColor(Food food);

  @DrawableRes
  int getFoodImage(Food food);
}
