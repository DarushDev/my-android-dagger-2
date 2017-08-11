package com.example.myandroiddagger2.ui.foodz;

import android.content.Context;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.example.myandroiddagger2.app.DeezFoodzApplication;
import com.example.myandroiddagger2.model.FoodzItem;
import com.example.myandroiddagger2.model.FoodzListResponse;
import com.example.myandroiddagger2.network.UsdaApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodzPresenterImpl implements FoodzPresenter {

    private FoodzView view;

    @Inject
    UsdaApi usdaApi;


    public FoodzPresenterImpl(Context context) {
        ((DeezFoodzApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(FoodzView view) {
        this.view = view;
    }

    @Override
    public void getFoodz() {
        view.showLoading();

        usdaApi.getFoodzList().enqueue(new Callback<FoodzListResponse>() {
            @Override
            public void onResponse(Call<FoodzListResponse> call, Response<FoodzListResponse> response) {

                if (response.code() != 200) {

                    view.showErrorMessage();

                } else {

                    List<FoodzItem> foodzItemList = Stream.of(response.body().getList().getItem())
                            .filter(foodzItem -> !foodzItem.getName().contains("ERROR"))
                            .collect(Collectors.toList());

                    view.showFoodz(foodzItemList);
                }

                view.hideLoading();
            }

            @Override
            public void onFailure(Call<FoodzListResponse> call, Throwable t) {
                view.showErrorMessage();
                view.hideLoading();
            }
        });
    }

}
