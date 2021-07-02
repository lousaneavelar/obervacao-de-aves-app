package com.example.observacaodeaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.snackbar.Snackbar;

public class RegistrarAves extends AppCompatActivity {
    private EditText edt_local, edt_data, edt_tamanho;
    private Button bt_identificarAve;
    private BottomNavigationItemView bt_pesquisa, bt_principal, bt_perfil;
    String[] mensagens = {"Preencha todos os campos!"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_aves);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_identificarAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String local = edt_local.getText().toString();
                String data = edt_data.getText().toString();
                String tamanho = edt_tamanho.getText().toString();

                if(local.isEmpty() || data.isEmpty() || tamanho.isEmpty()) {
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }
            }
        });
    }

    private void IniciarComponentes(){
        edt_local = findViewById(R.id.edtLocalObservacao);
        edt_data = findViewById(R.id.edtDataObservacao);
        edt_tamanho = findViewById(R.id.edtTamanhoAve);
        bt_identificarAve = findViewById(R.id.btnIdentificarAve);
        bt_perfil = findViewById(R.id.nav_perfil);
        bt_pesquisa = findViewById(R.id.nav_search);
        bt_principal = findViewById(R.id.nav_home);

        iniciarBottomMenu();
    }

    private void iniciarBottomMenu(){
        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarAves.this, TelaPerfil.class);
                startActivity(intent);
                finish();
            }
        });

        bt_pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarAves.this, TelaPesquisa.class);
                startActivity(intent);
                finish();
            }
        });

        bt_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarAves.this, AvesCatalogadas.class);
                startActivity(intent);
                finish();
            }
        });
    }
}