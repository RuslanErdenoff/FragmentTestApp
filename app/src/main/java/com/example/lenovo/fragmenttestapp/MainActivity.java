package com.example.lenovo.fragmenttestapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showAuth();
    }
    private void showAuth() {
        AuthFragment authFragment = new AuthFragment();
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.fragments_container, authFragment)
                .addToBackStack(null)
                .commit();
    }
    private void showMain() {
        // TODO(“show main fragment”)
        UserFragment userFragment = new UserFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.fragments_container,userFragment);
        fragmentTransaction.commit();
    }

    public static class AuthFragment extends Fragment {

        private Button button;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_auth_fragmanet, container, false);
            Button button = view.findViewById(R.id.button_auth);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showMain();
                }
            });
            return view;
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            getActivity().getSupportFragmentManager().popBackStack();
        }

        private void showMain(){
            MainActivity mainActivity = (MainActivity)getActivity();
            mainActivity.showMain();
        }

    }
    public static class UserFragment extends Fragment {


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_user, container, false);
        }

    }
}
