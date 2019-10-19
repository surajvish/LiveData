package com.example.livedata;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataObject extends ViewModel {
    private MutableLiveData<UserDetails> userDetailsMutableLiveData;

    public MutableLiveData<UserDetails> getUserDetailsMutableLiveData() {
        if (userDetailsMutableLiveData == null) {

            userDetailsMutableLiveData = new MutableLiveData<UserDetails>();
        }
        return userDetailsMutableLiveData;
    }

}
