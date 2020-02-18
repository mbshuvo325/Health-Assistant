package com.example.healthassistance.repos;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.healthassistance.viewmodels.LoginViewmodel;
import com.example.healthassistance.viewmodels.RegisterViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterRepository {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    public MutableLiveData<RegisterViewModel.AuthenticationState> stateLiveData;
    public MutableLiveData<String >errorMsg = new MutableLiveData<>();

    public RegisterRepository(MutableLiveData<RegisterViewModel.AuthenticationState> stateLiveData){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        this.stateLiveData = stateLiveData;
    }

    public MutableLiveData<RegisterViewModel.AuthenticationState> RegisterFirebaseUser(String email, String passwprd){
        firebaseAuth.createUserWithEmailAndPassword(email,passwprd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){
                            firebaseUser = firebaseAuth.getCurrentUser();
                            stateLiveData.postValue(RegisterViewModel.AuthenticationState.AUTHENTICATED);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                stateLiveData.postValue(RegisterViewModel.AuthenticationState.UNAUTHENTICATED);
                errorMsg.postValue(e.getLocalizedMessage());
            }
        });
        return stateLiveData;
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public MutableLiveData<String> getErrorMsg() {
        return errorMsg;
    }
}
