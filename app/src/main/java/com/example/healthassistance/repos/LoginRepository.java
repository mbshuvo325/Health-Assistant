package com.example.healthassistance.repos;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.healthassistance.viewmodels.LoginViewmodel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginRepository {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    public MutableLiveData<LoginViewmodel.AuthenticationState> stateLiveData;
    public MutableLiveData<String > errormsg = new MutableLiveData<>();

    public LoginRepository(MutableLiveData<LoginViewmodel.AuthenticationState> stateLiveData) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        this.stateLiveData = stateLiveData;
    }
    public MutableLiveData<LoginViewmodel.AuthenticationState> loginUser(String email, String password){
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            firebaseUser = firebaseAuth.getCurrentUser();
                            stateLiveData.postValue(LoginViewmodel.AuthenticationState.AUTHENTICATED);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                stateLiveData.postValue(LoginViewmodel.AuthenticationState.UNAUTHENTICATED);
                errormsg.postValue(e.getLocalizedMessage());
            }
        });
        return stateLiveData;
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public MutableLiveData<String> getErrormsg() {
        return errormsg;
    }
}

