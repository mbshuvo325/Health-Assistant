package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    private TextInputEditText userEmailTIET,userPasswordTIET;
    private Button loginBTN;
    private TextView signUpTV;
    private ImageView toggleBTN;
    private boolean isPasswordVisible;


    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        userEmailTIET = view.findViewById(R.id.userEmailET);
        userPasswordTIET = view.findViewById(R.id.passWordET);
        loginBTN = view.findViewById(R.id.loginbtn);
        signUpTV = view.findViewById(R.id.signUpbtn);
        toggleBTN = view.findViewById(R.id.togglebtn);

        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String email = userEmailTIET.getText().toString();
                if (email.isEmpty()){
                    userEmailTIET.setError("Enter a userEmail!");
                }
              String pass =  userPasswordTIET.getText().toString();
                if (pass.isEmpty()){
                    userPasswordTIET.setError("Enter Your Password!");
                }
                //Authentication

                Navigation.findNavController(getActivity(),R.id.nav_graph).navigate(R.id.dashBoard);
            }
        });

        signUpTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(getActivity(),R.id.nav_graph).navigate(R.id.signUp);
            }
        });

        toggleBTN.setOnClickListener(new View.OnClickListener() {
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
        } else {
            String pass = userPasswordTIET.getText().toString();
            userPasswordTIET.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            userPasswordTIET.setInputType(InputType.TYPE_CLASS_TEXT);
            userPasswordTIET.setText(pass);
            userPasswordTIET.setSelection(pass.length());
        }
        isPasswordVisible= !isPasswordVisible;
    }
}
