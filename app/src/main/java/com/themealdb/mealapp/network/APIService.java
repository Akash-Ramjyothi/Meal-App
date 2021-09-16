package com.themealdb.mealapp.network;

import com.themealdb.mealapp.model.ResultModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("json/v1/1/filter.php?c=Seafood")
    Call<ResultModel> getImageList();
}
