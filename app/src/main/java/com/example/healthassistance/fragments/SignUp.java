package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.healthassistance.R;
import com.example.healthassistance.viewmodels.RegisterViewModel;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {

    private TextInputEditText userNameTIET,userPasswordTIET,userEmailTIET,userConPasswordTIET;
    private Button signUpBTN;
    private TextView statusTV;
    private RegisterViewModel registerViewModel;


    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userNameTIET = view.findViewById(R.id.useNameeT);
        userEmailTIET = view.findViewById(R.id.UserEmaileT);
        statusTV = view.findViewById(R.id.errortv);
        userPasswordTIET = view.findViewById(R.id.userPasseT);
        userConPasswordTIET = view.findViewById(R.id.userConPasset);
        signUpBTN = view.findViewById(R.id.signUpbtn);

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Authentication
                String userName = userNameTIET.getText().toString();
                String email = userEmailTIET.getText().toString();
                String password = userPasswordTIET.getText().toString();
                registerViewModel.Register(email,password);
            }
        });

        registerViewModel.stateLiveData.observe(this.getActivity(), new Observer<RegisterViewModel.AuthenticationState>() {
            @Override
            public void onChanged(RegisterViewModel.AuthenticationState authenticationState) {
                switch (authenticationState){
                    case AUTHENTICATED:
                        Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.login);
                        break;
                    case UNAUTHENTICATED:

                        break;
                }
            }
        });
        registerViewModel.errormsg.observe(this.getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                statusTV.setText(s);
            }
        });
    }
}
