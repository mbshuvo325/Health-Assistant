package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import android.text.InputType;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.healthassistance.R;
import com.example.healthassistance.viewmodels.LoginViewmodel;
import com.google.android.material.textfield.TextInputEditText;

import static android.view.View.GONE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    private TextInputEditText userEmailTIET,userPasswordTIET;
    private Button loginBTN;
    private TextView signUpTV,statusTV;
    private ImageView toggleBTN,toggleInvisibleBTN;
    private boolean isPasswordVisible;
    private LoginViewmodel loginViewmodel;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginViewmodel = ViewModelProviders.of(this).get(LoginViewmodel.class);
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        userEmailTIET = view.findViewById(R.id.userEmailET);
        userPasswordTIET = view.findViewById(R.id.passWordET);
        loginBTN = view.findViewById(R.id.loginbtn);
        signUpTV = view.findViewById(R.id.signUpbtn);
        statusTV = view.findViewById(R.id.errortv);
        toggleBTN = view.findViewById(R.id.togglebtn);
        toggleInvisibleBTN = view.findViewById(R.id.toggleinvisiblebtn);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String email = userEmailTIET.getText().toString();
                String pass =  userPasswordTIET.getText().toString();
                if (email.isEmpty()){
                    userEmailTIET.setError("Enter a userEmail!");
                }
                else if (pass.isEmpty()){
                    userPasswordTIET.setError("Enter Your Password!");
                }else {
                    loginViewmodel.Login(email,pass);
                }

            }
        });
        loginViewmodel.stateLiveData.observe(this.getActivity(), new Observer<LoginViewmodel.AuthenticationState>() {
            @Override
            public void onChanged(LoginViewmodel.AuthenticationState authenticationState) {
                switch (authenticationState){
                    case AUTHENTICATED:
                        Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.dashBoard);
                        break;
                    case UNAUTHENTICATED:

                        break;
                }
            }
        });
        loginViewmodel.errormsg.observe(this.getActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                statusTV.setText(s);
            }
        });
        signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.signUp);
            }
        });

        toggleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePassWordVisible();

            }
        });
        toggleInvisibleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                togglePassWordVisible();
            }
        });

    }

    private void togglePassWordVisible() {
        if (isPasswordVisible) {
            String pass = userPasswordTIET.getText().toString();
            userPasswordTIET.setTransformationMethod(PasswordTransformationMethod.getInstance());
            userPasswordTIET.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            userPasswordTIET.setText(pass);
            userPasswordTIET.setSelection(pass.length());
            toggleBTN.setVisibility(View.VISIBLE);
            toggleInvisibleBTN.setVisibility(GONE);
        } else {
            String pass = userPasswordTIET.getText().toString();
            userPasswordTIET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            userPasswordTIET.setInputType(InputType.TYPE_CLASS_TEXT);
            userPasswordTIET.setText(pass);
            userPasswordTIET.setSelection(pass.length());
            toggleBTN.setVisibility(GONE);
            toggleInvisibleBTN.setVisibility(View.VISIBLE);
        }
        isPasswordVisible= !isPasswordVisible;
    }
}
