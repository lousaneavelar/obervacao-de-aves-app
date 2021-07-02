package com.example.observacaodeaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class RegistrarAves extends AppCompatActivity {
    private EditText edt_local, edt_data, edt_tamanho;
    private Button bt_identificarAve;
    private BottomNavigationItemView bt_pesquisa, bt_principal, bt_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_aves);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_identificarAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarAves.this, MelhoresResultados.class);
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
                //
            }
        });

        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrarAves.this, TelaPerfil.class);
                startActivity(intent);
                finish();
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
    }
}