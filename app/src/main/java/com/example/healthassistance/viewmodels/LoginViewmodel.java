package com.example.healthassistance.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthassistance.repos.LoginRepository;
import com.google.firebase.auth.FirebaseAuth;

public class LoginViewmodel extends ViewModel {
    public enum AuthenticationState{
        AUTHENTICATED,UNAUTHENTICATED
    }
    private LoginRepository loginRepository;
    public MutableLiveData<AuthenticationState> stateLiveData;
    public MutableLiveData<String > errormsg = new MutableLiveData<>();

    public LoginViewmodel() {
        stateLiveData = new MutableLiveData<>();
        loginRepository = new LoginRepository(stateLiveData);
        errormsg = loginRepository.getErrormsg();
        if (loginRepository.getFirebaseUser() != null){
            stateLiveData.postValue(AuthenticationState.AUTHENTICATED);
        }else {
            stateLiveData.postValue(AuthenticationState.UNAUTHENTICATED);
        }
    }

    public void Login(String email, String password){
        loginRepository.loginUser(email,password);
    }

    public void LogOutUser(){
        FirebaseAuth.getInstance().signOut();
        stateLiveData.postValue(AuthenticationState.UNAUTHENTICATED);
    }

}
