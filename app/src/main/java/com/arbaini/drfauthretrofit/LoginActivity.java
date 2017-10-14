package com.arbaini.drfauthretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;

import com.arbaini.drfauthretrofit.pojo.DetailUser;
import com.arbaini.drfauthretrofit.pojo.LoginUser;
import com.arbaini.drfauthretrofit.pojo.User;
import com.arbaini.drfauthretrofit.util.PrefManager;

import retrofit2.Call;

public class LoginActivity extends AppCompatActivity {

    private EditText mEtUsername, mEtPassword;
    private Button buttonLogin, buttonRegister;
    APIInterface apiInterface;

    private PrefManager prefManager;

    private boolean loginStat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEtUsername = (EditText) findViewById(R.id.et_login_username);
        mEtPassword = (EditText) findViewById(R.id.et_login_password);
        buttonLogin = (Button) findViewById(R.id.btn_login);
        buttonRegister = (Button) findViewById(R.id.btn_login_register);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        prefManager = new PrefManager(this);

        loginStat = prefManager.getLoginStat();


        if(loginStat){

            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();

        }else{
            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String username = mEtUsername.getText().toString();
                    String password = mEtPassword.getText().toString();
                    LoginUser user = new LoginUser(username, password);

                    // Retrofit Process
                    Call call1 = apiInterface.loginUser(user);
                    call1.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            String ok = "OK";
                            Log.v("RESPON:",response.message().toString());
                            if(ok.equals(response.message().toString())){
                                DetailUser user1 = (DetailUser) response.body();
                                User user2 = user1.user;

                                String idpk = String.valueOf(user2.pk);

                                prefManager.setIdPk(idpk);
                                prefManager.setIdEmail(user2.email);
                                prefManager.setIdToken(user1.token);
                                prefManager.setIdUsername(user2.username);
                                prefManager.setLoginStat(true);

                                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                                finish();

                            }else{
                                Toast.makeText(getApplicationContext(),"Login gagal",Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            call.cancel();
                        }
                    });


                }
            });

        }


        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                finish();
            }
        });

    }
}
