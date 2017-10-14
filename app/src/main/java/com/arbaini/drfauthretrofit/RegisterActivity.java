package com.arbaini.drfauthretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arbaini.drfauthretrofit.pojo.CreateUser;
import com.arbaini.drfauthretrofit.pojo.DetailUser;
import com.arbaini.drfauthretrofit.pojo.LoginUser;
import com.arbaini.drfauthretrofit.pojo.User;
import com.arbaini.drfauthretrofit.util.PrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUsername,mPassword,mEmail,mPassword2;
    private Button mButtonRegis;
    APIInterface apiInterface;

    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        mEmail = (EditText) findViewById(R.id.et_register_email);
        mUsername = (EditText) findViewById(R.id.et_register_username);
        mPassword = (EditText) findViewById(R.id.et_register_password);
        mPassword2 = (EditText) findViewById(R.id.et_register_password2);
        mButtonRegis = (Button) findViewById(R.id.btn_register);
        apiInterface = APIClient.getClient().create(APIInterface.class);
        prefManager = new PrefManager(this);

        mButtonRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = mEmail.getText().toString();
                String username = mUsername.getText().toString();
                String password = mPassword.getText().toString();
                String password2 = mPassword2.getText().toString();


                if(password.equals(password2)){
                    CreateUser user = new CreateUser(username,email,password,password2,"Null","Null");

                    // Retrofit Process
                    Call call1 = apiInterface.createUser(user);
                    call1.enqueue(new Callback() {
                        @Override
                        public void onResponse(Call call, Response response) {
                            String ok = "Created";
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

                                startActivity(new Intent(RegisterActivity.this,MainActivity.class));
                                finish();

                            }else{
                                Toast.makeText(getApplicationContext(),"Register gagal",Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call call, Throwable t) {
                            call.cancel();
                        }
                    });

                }else{

                    Toast.makeText(getApplicationContext(),"Password tidak cocok,silahkan masukan ulang",Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}
