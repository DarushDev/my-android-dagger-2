package com.example.myandroiddagger2.ui.foodz;


import com.example.myandroiddagger2.model.FoodzItem;

import java.util.List;

public interface FoodzView {
    void showLoading();

    void hideLoading();

    void showFoodz(List<FoodzItem> foodzItemList);

    void showErrorMessage();

    void launchFoodDetail(FoodzItem foodzItem);
}
