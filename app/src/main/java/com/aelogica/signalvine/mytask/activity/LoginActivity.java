package com.aelogica.signalvine.mytask.activity;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import com.aelogica.signalvine.mytask.R;
import com.aelogica.signalvine.mytask.object.LoginAccount;
import com.aelogica.signalvine.mytask.fragment.AccountFragment;
import com.aelogica.signalvine.mytask.fragment.LoginFragment;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements AccountFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new LoginFragment())
                .commit();
    }

    @Override
    public void onListFragmentInteraction(LoginAccount.AccountItem item) {

    }
}

