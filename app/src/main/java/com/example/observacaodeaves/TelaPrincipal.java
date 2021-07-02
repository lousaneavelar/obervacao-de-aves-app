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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class TelaPrincipal extends AppCompatActivity {

    private EditText edit_pesquisa;
    private Button bt_identificar;
    private BottomNavigationItemView bt_pesquisa, bt_principal, bt_perfil;
    String[] mensagens = {"Preencha todos os campos!"};
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_principal);

        getSupportActionBar().hide();
        IniciarComponentes();

        bt_identificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pesquisa = edit_pesquisa.getText().toString();

                if(pesquisa.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    DocumentReference docRef = db.collection("aves").document(pesquisa);
                    if(!docRef.getId().isEmpty()){
                        Intent intent = new Intent(TelaPrincipal.this, MelhoresResultados.class);
                        // Passar aves encontradas para melhores resultados.
                        intent.putExtra("avesEncontradas", docRef.toString());
                        startActivity(intent);
                        finish();
                    }
                    Snackbar snackbar = Snackbar.make(v, "Nenhuma ave registrada com este nome!", Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                    Intent intent = new Intent(TelaPrincipal.this, CatalogarAves.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void IniciarComponentes(){
        edit_pesquisa = findViewById(R.id.edtNomePopularAve2);
        bt_identificar = findViewById(R.id.btnIniciarNovaIdentificacao);
        bt_perfil = findViewById(R.id.nav_perfil);
        bt_pesquisa = findViewById(R.id.nav_search);
        bt_principal = findViewById(R.id.nav_home);

        iniciarBottomMenu();
    }

    private void iniciarBottomMenu(){
        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, TelaPerfil.class);
                startActivity(intent);
                finish();
            }
        });

        bt_pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, TelaPrincipal.class);
                startActivity(intent);
                finish();
            }
        });

        bt_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TelaPrincipal.this, AvesCatalogadas.class);
                startActivity(intent);
                finish();
            }
        });
    }
}