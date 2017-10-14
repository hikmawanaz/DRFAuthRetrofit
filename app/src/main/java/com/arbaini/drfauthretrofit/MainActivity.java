package com.arbaini.drfauthretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.arbaini.drfauthretrofit.util.PrefManager;

public class MainActivity extends AppCompatActivity {


    private TextView mIdPK,mIdUsername,mIdEmail,mIdToken;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mIdPK = (TextView) findViewById(R.id.tv_id_pk);
        mIdUsername = (TextView) findViewById(R.id.tv_id_username);
        mIdEmail = (TextView) findViewById(R.id.tv_id_email);
        mIdToken = (TextView) findViewById(R.id.tv_id_token);


        prefManager = new PrefManager(this);

        mIdPK.setText(prefManager.getIdPk());
        mIdUsername.setText(prefManager.getIdUsername());
        mIdEmail.setText(prefManager.getIdEmail());
        mIdToken.setText(prefManager.getIdToken());



    }
}
