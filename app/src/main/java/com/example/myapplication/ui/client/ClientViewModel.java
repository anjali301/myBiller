package com.example.myapplication.ui.client;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClientViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;

    public ClientViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is client details fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}