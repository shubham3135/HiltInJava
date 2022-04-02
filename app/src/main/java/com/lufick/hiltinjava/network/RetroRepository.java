package com.lufick.hiltinjava.network;

import androidx.lifecycle.MutableLiveData;

import com.lufick.hiltinjava.model.RecyclerData;
import com.lufick.hiltinjava.model.RecyclerList;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroRepository {
    private RetroService retroService;

    @Inject
    public RetroRepository(RetroService retroService) {
        this.retroService = retroService;
    }

    public void makeAPICall(String query, MutableLiveData<List<RecyclerData>> liveData) {
        Call<RecyclerList> call  = retroService.getDataFromGitHubApi(query);
        call.enqueue(new Callback<RecyclerList>() {
            @Override
            public void onResponse(Call<RecyclerList> call, Response<RecyclerList> response) {
                if(response.isSuccessful()) {
                    liveData.postValue(response.body().getItems());
                } else {
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<RecyclerList> call, Throwable t) {
                liveData.postValue(null);
            }
        });


    }
}
