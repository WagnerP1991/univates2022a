package br.univates.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnapresentarlogin;
    EditText txtUsuario, txtSenha;
    Context context;
    String USER = "fulano";
    String PASS = "fulano";
    SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apresentarlogin);

        context = LoginActivity.this;
        txtUsuario = findViewById(R.id.txtUsuario_login);
        txtSenha = findViewById(R.id.txtSenha_login);
        btnapresentarlogin = findViewById(R.id.btnLogin_login);


        String chave_preference = getString(R.string.shared_preferences);

        sharedPreferences = getSharedPreferences(chave_preference, MODE_PRIVATE);

        String usuario = sharedPreferences.getString("usuario", "");
        if (!usuario.equals("")){
            Intent intent = new Intent(context, MenuActivity.class);
            startActivity(intent);
            finish();
        }

        txtUsuario.requestFocus();

        btnapresentarlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtUsuario.getText().toString().equals(USER) && txtSenha.getText().toString().equals(PASS)) {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("usuario", USER);
                    boolean ret = editor.commit();

                    Intent intent = new Intent(context, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(context, "Dados Inválidos", Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}