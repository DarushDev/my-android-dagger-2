package com.example.myandroiddagger2.ui.food;

import com.example.myandroiddagger2.model.Food;

public interface FoodView {
  void showLoading();

  void hideLoading();

  void showFood(Food food);

  void showErrorMessage();
}
