package com.example.myandroiddagger2.model;

import java.util.List;

public class Food {

  private String ndbno;

  private String name;

  private String measure;

  private List<FoodNutrient> nutrients;

  public String getName() {
    return name;
  }

  public String getNdbno() {
    return ndbno;
  }

  public String getMeasure() {
    return measure;
  }

  public List<FoodNutrient> getNutrients() {
    return nutrients;
  }
}
