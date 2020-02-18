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
    public MutableLiveData<String > errormsg = new MutableLiveData<>();

    public RegisterViewModel() {
        stateLiveData = new MutableLiveData<>();
       registerRepository = new RegisterRepository();
       errormsg = registerRepository.getErrormsg();
        if (registerRepository.getFirebaseUser() != null){
            stateLiveData.postValue(AuthenticationState.AUTHENTICATED);
        }else {
            stateLiveData.postValue(AuthenticationState.UNAUTHENTICATED);
        }
    }
    public void Register(String email, String password){
        registerRepository.RegisterUser(email,password);
    }
}
