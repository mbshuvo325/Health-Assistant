package com.example.healthassistance.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.healthassistance.R;
import com.google.android.material.textfield.TextInputEditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUp extends Fragment {

    private TextInputEditText userNameTIET,userPasswordTIET,userEmailTIET,userConPasswordTIET;
    private Button signUpBTN;


    public SignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userNameTIET = view.findViewById(R.id.useNameeT);
        userEmailTIET = view.findViewById(R.id.UserEmaileT);
        userPasswordTIET = view.findViewById(R.id.userPasseT);
        userConPasswordTIET = view.findViewById(R.id.userConPasset);
        signUpBTN = view.findViewById(R.id.signUpbtn);

        signUpBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Authentication
                Navigation.findNavController(getActivity(),R.id.nav_host_fragment).navigate(R.id.dashBoard);
            }
        });
    }
}
