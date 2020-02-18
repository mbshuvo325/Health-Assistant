package com.example.healthassistance.repos;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

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
    public MutableLiveData<String > errormsg = new MutableLiveData<>();
    public RegisterRepository() {
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
    }
    public void RegisterUser(String email,String password){
        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        stateLiveData.postValue(RegisterViewModel.AuthenticationState.AUTHENTICATED);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                stateLiveData.postValue(RegisterViewModel.AuthenticationState.UNAUTHENTICATED);
                errormsg.postValue(e.getLocalizedMessage());
            }
        });
    }

    public FirebaseUser getFirebaseUser() {
        return firebaseUser;
    }

    public MutableLiveData<String> getErrormsg() {
        return errormsg;
    }
}
