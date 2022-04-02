package com.lufick.hiltinjava.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.lufick.hiltinjava.model.RecyclerData;
import com.lufick.hiltinjava.network.RetroRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainActivityViewModel extends ViewModel {
    MutableLiveData<List<RecyclerData>> liveData;
    RetroRepository retroRepository;

    @Inject
    public MainActivityViewModel(RetroRepository retroRepository) {
        liveData = new MutableLiveData();
        this.retroRepository = retroRepository;
    }

    public MutableLiveData<List<RecyclerData>> getLiveData() {
        return liveData;
    }

    public void makeApiCall() {
        retroRepository.makeAPICall("cat", liveData);
    }
}