package com.example.observacaodeaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

public class TelaPesquisa extends AppCompatActivity {
    private EditText edit_pesquisa;
    private Button bt_identificar;
    private BottomNavigationItemView bt_pesquisa, bt_principal, bt_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_pesquisa);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_identificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPesquisa.this, RegistrarAves.class);
                startActivity(intent);
                finish();
            }
        });

        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPesquisa.this, TelaPerfil.class);
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
    }

    private void IniciarComponentes(){
        edit_pesquisa = findViewById(R.id.edtNomePopularAve2);
        bt_identificar = findViewById(R.id.btnIniciarNovaIdentificacao);
        bt_perfil = findViewById(R.id.nav_perfil);
//        bt_pesquisa = findViewById(R.id.nav_search);
        bt_principal = findViewById(R.id.nav_home);
    }
}