package com.example.myandroiddagger2.ui.food;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myandroiddagger2.R;
import com.example.myandroiddagger2.app.StringUtils;
import com.example.myandroiddagger2.model.Food;
import com.example.myandroiddagger2.model.FoodzItem;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodActivity extends AppCompatActivity implements FoodView {

  FoodPresenter presenter;

  public static final String EXTRA_FOOD_ID = "EXTRA_FOOD_ID";

  public static void launch(Context context, FoodzItem foodzItem) {
    Intent intent = new Intent(context, FoodActivity.class);
    intent.putExtra(EXTRA_FOOD_ID, foodzItem.getId());
    context.startActivity(intent);
  }

  @BindView(R.id.activity_food_name)
  TextView foodName;

  @BindView(R.id.activity_food_measure)
  TextView foodMeasure;

  @BindView(R.id.activity_food_nutrient)
  TextView foodNutrient;

  @BindView(R.id.activity_food_imageView)
  ImageView imageView;

  @BindView(R.id.activity_food_progressBar)
  ProgressBar progressBar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_food);

    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);

    ButterKnife.bind(this);

    String foodId = getIntent().getStringExtra(EXTRA_FOOD_ID);

    presenter = new FoodPresenterImpl();
    presenter.setView(this);
    presenter.getFood(foodId);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  /*
   * FoodView
   */

  @Override
  public void showLoading() {
    progressBar.setVisibility(View.VISIBLE);
  }

  @Override
  public void hideLoading() {
    progressBar.setVisibility(View.GONE);
  }

  @Override
  public void showFood(Food food) {
    String foodNameString = StringUtils.stripPrefix(food.getName());
    setTitle(foodNameString);
    foodName.setText(foodNameString);
    foodMeasure.setText(String.format(getString(R.string.FoodItemMeasure), food.getMeasure()));
    foodNutrient.setText(food.getNutrients().get(0).toString());
    foodNutrient.setTextColor(ContextCompat.getColor(this, presenter.getFoodColor(food)));
    imageView.setImageDrawable(ContextCompat.getDrawable(this, presenter.getFoodImage(food)));
  }

  @Override
  public void showErrorMessage() {
    Toast.makeText(this, R.string.FoodItemError, Toast.LENGTH_SHORT).show();
  }
}
