package com.example.healthassistance.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthassistance.repos.LoginRepository;

public class LoginViewmodel extends ViewModel {

    public enum AuthenticationState{
        AUTHENTICATED,UNAUTHENTICATED
    }
    private LoginRepository loginRepository;
    public MutableLiveData<AuthenticationState> stateLivaData;
    public MutableLiveData<String > errorMsg = new MutableLiveData<>();

    public LoginViewmodel(){
        stateLivaData = new MutableLiveData<>();
        loginRepository = new LoginRepository(stateLivaData);
        errorMsg = loginRepository.getErrorMsg();
        if (loginRepository.getFirebaseUser() != null){
            stateLivaData.postValue(AuthenticationState.AUTHENTICATED);
        }else{
            stateLivaData.postValue(AuthenticationState.UNAUTHENTICATED);
        }

    }
    public void Login(String email, String password){
       stateLivaData = loginRepository.loginFireBaseUser(email, password);
    }
}
