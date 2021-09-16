package com.themealdb.mealapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.themealdb.mealapp.model.ResultModel;
import com.themealdb.mealapp.repo.ImagesRepository;


public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<ResultModel> listOfImages = new MutableLiveData<>();
    private ImagesRepository imagesRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        imagesRepository = new ImagesRepository();
    }

    public MutableLiveData<ResultModel> getResult(){
        listOfImages = imagesRepository.getResultLiveData();
        return listOfImages;
    }

    public void sendAPICall(){
        if(listOfImages.getValue() == null){
            imagesRepository.sendAPICall();
        }
        else{
            listOfImages.postValue(listOfImages.getValue());
        }
    }
}
