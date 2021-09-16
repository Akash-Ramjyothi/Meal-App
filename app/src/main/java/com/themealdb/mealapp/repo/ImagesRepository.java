package com.themealdb.mealapp.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.themealdb.mealapp.model.ResultModel;
import com.themealdb.mealapp.network.APIService;
import com.themealdb.mealapp.network.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImagesRepository {

    private APIService service;
    private MutableLiveData<ResultModel> listOfImages = new MutableLiveData<>();

    public ImagesRepository(){
        service = RetrofitService.getInstance();
    }

    public MutableLiveData<ResultModel> getResultLiveData(){
        return listOfImages;
    }

    public void sendAPICall(){
        Log.i("ViewModel","Send API call");
        service.getImageList().enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                Log.i("ViewModel","Success"+response.isSuccessful());
                if(response.isSuccessful()){
                    listOfImages.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                Log.i("ViewModel","Failed");
            }
        });
    }
}
