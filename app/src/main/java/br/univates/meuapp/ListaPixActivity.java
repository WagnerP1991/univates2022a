package br.univates.meuapp;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.provider.Settings;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toolbar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.ArrayList;
import java.util.List;

import br.univates.meuapp.databinding.ActivityListaPixBinding;

public class ListaPixActivity extends AppCompatActivity {

    FloatingActionButton fabAdd;
    ListView listaContasView;
    Context context;
    ArrayList<String> objlista;

    @Override
    protected void onCreate(Bundle savedInstance5tate) {
        super.onCreate(savedInstance5tate);
        setContentView(R.layout.activity_lista_pix);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = listaPixActivity.this;
        fabAdd = findViewById(R.id.fabAdicionar_pix);
        listaContas = findViewById(R.id.listViewContasPix_pix);
        objlista = new ArrayList<>();

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    objlista.add("Novo Item");
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, objlista);

                    listaContasView.setAdapter(adapter);
                }catch (Exception ex){
                    Globais.exibirMensagem(context, ex.getMessage());
                }

            }
        });
    }
}