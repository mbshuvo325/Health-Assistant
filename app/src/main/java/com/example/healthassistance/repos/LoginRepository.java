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
    private MutableLiveData<LoginViewmodel.AuthenticationState> stateLivaData;
    public MutableLiveData<String > errorMsg = new MutableLiveData<>();

    public LoginRepository(MutableLiveData<LoginViewmodel.AuthenticationState> stateLivaData) {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        this.stateLivaData = stateLivaData;
    }

    public MutableLiveData<LoginViewmodel.AuthenticationState> loginFireBaseUser(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            firebaseUser = firebaseAuth.getCurrentUser();
                            stateLivaData.postValue(LoginViewmodel.AuthenticationState.AUTHENTICATED);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                stateLivaData.postValue(LoginViewmodel.AuthenticationState.UNAUTHENTICATED);
                errorMsg.postValue(e.getLocalizedMessage());
            }
        });

        return stateLivaData;
     }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public MutableLiveData<String> getErrorMsg() {
        return errorMsg;
    }
}

