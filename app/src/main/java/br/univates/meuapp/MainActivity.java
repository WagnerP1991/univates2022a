package br.univates.meuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView lblTabuada;
    Button btnTabuada;
    EditText txtTabuada;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblTabuada = findViewById(R.id.lblTabuada_main);
        txtTabuada = findViewById(R.id.txtTabuada_main);
        btnTabuada = findViewById(R.id.btnCalcular_main);

        btnTabuada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tabuada = Integer.parseInt(txtTabuada.getText().toString());
                String impressao = "";

                for (int i = 0; i <= 10; i++) {

                    int res = i * tabuada;
                    impressao += tabuada + "x" + i + "=" + res + "\n";
                }

                lblTabuada.setText(impressao);
            }
        });
    }
}