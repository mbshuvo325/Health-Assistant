package com.example.healthassistance.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthassistance.repos.RegisterRepository;

public class RegisterViewModel extends ViewModel {

    public enum AuthenticationState{
        AUTHENTICATED,UNAUTHENTICATED
    }
    private RegisterRepository registerRepository;
    public MutableLiveData<AuthenticationState> stateLiveData;
    public MutableLiveData<String >errorMsg = new MutableLiveData<>();

    public RegisterViewModel(){
        stateLiveData = new MutableLiveData<>();
        registerRepository = new RegisterRepository(stateLiveData);
        errorMsg = registerRepository.getErrorMsg();
        if (registerRepository.getFirebaseUser() != null){
            stateLiveData.postValue(AuthenticationState.AUTHENTICATED);
        }else{
            stateLiveData.postValue(AuthenticationState.UNAUTHENTICATED);
        }
    }

    public void register(String email, String password){
       stateLiveData = registerRepository.RegisterFirebaseUser(email, password);
    }
}
