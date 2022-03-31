package br.univates.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {

    Context context;
    LinearLayout linearMain;
    Button btn1, btn2, btn3, btnListaPix;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        setTitle("Título");
        context = MenuActivity.this;

        String chave_preference = getString(R.string.shared_preferences);

        sharedPreferences = getSharedPreferences(chave_preference, MODE_PRIVATE);

        linearMain = findViewById(R.id.linear_main);
        btn1 = findViewById(R.id.btn1_main);
        btn2 = findViewById(R.id.btn2_main);
        btn3 = findViewById(R.id.btn3_main);
        btnListaPix = findViewById(R.id.btnListaPix_menu);

        btnListaPix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent tela = new intent(context, ListaPixActivity.class);
                startActivity(tela);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(linearMain, "Texto de exemplo", BaseTransientBottomBar.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    //SharedPrefences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("usuario", "jonas");
                    boolean ret = editor.commit();
                    if (ret) {
                        Snackbar.make(linearMain,"Preferencia gravada com sucesso", BaseTransientBottomBar.LENGTH_LONG).show();
                    }
                } catch (Exception ex) {
                    Log.e("CATCH", ex.getMessage());
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String preferencia = sharedPreferences.getString("senha", "");
                Snackbar.make(linearMain,"Preferência = " + preferencia, BaseTransientBottomBar.LENGTH_LONG).show();
            }
        });


    }
}
