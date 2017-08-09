package com.example.myandroiddagger2.ui.foodz;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myandroiddagger2.R;

public class FoodzViewHolder extends RecyclerView.ViewHolder {

    private ViewGroup container;
    private TextView foodName;

    FoodzViewHolder(View view) {
        super(view);
        container = (ViewGroup) view.findViewById(R.id.list_item_food_container);
        foodName = (TextView) view.findViewById(R.id.list_item_food_name);
    }

    public ViewGroup getContainer() {
        return container;
    }

    public TextView getFoodName() {
        return foodName;
    }
}
