package br.univates.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity2 extends AppCompatActivity {

Button btnLogin;
EditText txtUsuario, txtSenha;
    Context context;
    String USER = "jonas";
    String PASS = "abc123";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        context = LoginActivity2.this;
        txtUsuario = findViewById(R.id. txtUsuario_login);
        txtSenha = findViewById(R.id. txtSenha_login);
        btnLogin = findViewById(R.id.btnLogin_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtUsuario.getText().toString().equals(USER) &&
                txtSenha.getText().toString().equals(PASS)){

                    Intent intent = new Intent(context, MainActivity.class);
                    startActivity(intent);
                }



            }
        });
    }
}