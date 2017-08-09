package com.example.myandroiddagger2.model;

public class FoodNutrient {

  private String nutrient;

  private String unit;

  private String value;

  @Override
  public String toString() {
    return nutrient + ": " + value + " " + unit;
  }

  public String getValue() {
    return value;
  }
}
