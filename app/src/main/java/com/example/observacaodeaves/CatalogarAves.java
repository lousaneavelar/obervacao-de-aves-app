package com.example.observacaodeaves;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.HashMap;
import java.util.Map;

public class CatalogarAves extends AppCompatActivity {
    private TextView txtCatalogarAves;
    private TextView txtPrincipaisCores;
    private EditText edtNomePopularAve;
    private EditText edtNomeCientificoAve;
    private EditText edtCaracteristicasAdicionais;
    private EditText edtLocalIdentificacao;
    private EditText edtDataIdentificacao;
    private EditText edtTamanhoAves;
    private EditText edtPrincipaisCores;
    private Button btnCadastrarAves;
    private BottomNavigationItemView bt_pesquisa, bt_principal, bt_perfil;
    String[] mensagens = {"Preencha todos os campos!"};
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalogar_aves);

        getSupportActionBar().hide();
        iniciarComponentes();

        btnCadastrarAves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomePopular = edtNomePopularAve.getText().toString();
                String nomeCientifico = edtNomeCientificoAve.getText().toString();
                String caracteristicasAdicionais = edtCaracteristicasAdicionais.getText().toString();
                String localIdentificacao = edtLocalIdentificacao.getText().toString();
                String dataIdentificacao = edtDataIdentificacao.getText().toString();
                String tamanho = edtTamanhoAves.getText().toString();
                String coresPrincipais = edtPrincipaisCores.getText().toString();

                if(nomePopular.isEmpty() || nomeCientifico.isEmpty() || caracteristicasAdicionais.isEmpty() || localIdentificacao.isEmpty() || dataIdentificacao.isEmpty() || tamanho.isEmpty() || coresPrincipais.isEmpty()){
                    Snackbar snackbar = Snackbar.make(v, mensagens[0], Snackbar.LENGTH_SHORT);
                    snackbar.setBackgroundTint(Color.WHITE);
                    snackbar.setTextColor(Color.BLACK);
                    snackbar.show();
                }else{
                    Map<String, Object> ave = new HashMap<>();
                    ave.put("nome", edtNomePopularAve);
                    ave.put("nomeCientifico", edtNomeCientificoAve);
                    ave.put("local", edtLocalIdentificacao);
                    ave.put("data", edtDataIdentificacao);
                    ave.put("tamanho", edtTamanhoAves);
                    ave.put("coresPrincipais", edtPrincipaisCores);

                    db.collection("aves").document(nomePopular)
                            .set(ave)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Snackbar snackbar = Snackbar.make(v, "Cadastro realizado com sucesso!", Snackbar.LENGTH_SHORT);
                                    snackbar.setBackgroundTint(Color.WHITE);
                                    snackbar.setTextColor(Color.BLACK);
                                    snackbar.show();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Snackbar snackbar = Snackbar.make(v, "Erro ao cadastrar ave!", Snackbar.LENGTH_SHORT);
                                    snackbar.setBackgroundTint(Color.WHITE);
                                    snackbar.setTextColor(Color.BLACK);
                                    snackbar.show();
                                }
                            });

                    Intent intent = new Intent(String.valueOf(AvesCatalogadas.class));
                    startActivity(intent);
                }
            }
        });
    }

    private void iniciarComponentes(){
        txtCatalogarAves = findViewById(R.id.txtCatalogarAves);
        txtPrincipaisCores = findViewById(R.id.txtPrincipaisCores);
        edtNomePopularAve = findViewById(R.id.edtNomePopularAve);
        edtNomeCientificoAve = findViewById(R.id.edtNomeCientificoAve);
        edtCaracteristicasAdicionais = findViewById(R.id.edtCaracteristicasAdicionais);
        edtLocalIdentificacao = findViewById(R.id.edtLocalIdentificacao);
        edtDataIdentificacao = findViewById(R.id.edtDataIdentificacao);
        edtTamanhoAves = findViewById(R.id.edtTamanhoAves);
        edtPrincipaisCores = findViewById(R.id.edtPrincipaisCores);
        btnCadastrarAves = findViewById(R.id.btnCadastrarAves);
        bt_perfil = findViewById(R.id.nav_perfil);
        bt_pesquisa = findViewById(R.id.nav_search);
        bt_principal = findViewById(R.id.nav_home);

        iniciarBottomMenu();
    }

    private void iniciarBottomMenu(){
        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogarAves.this, TelaPerfil.class);
                startActivity(intent);
                finish();
            }
        });

        bt_pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogarAves.this, TelaPesquisa.class);
                startActivity(intent);
                finish();
            }
        });

        bt_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogarAves.this, AvesCatalogadas.class);
                startActivity(intent);
                finish();
            }
        });
    }
}