package com.example.observacaodeaves;

import java.net.URI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.net.UriCompat;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

public class AvesCatalogadasExpandida extends AppCompatActivity {
    private TextView nomeAveCatalogadaExpandida;
    private TextView nomeCientificoAveExpandida;
    private TextView descricaoAveExpandida;
    private ImageView imagemAveCatalogadaExpandida;
    private BottomNavigationItemView bt_pesquisa, bt_principal, bt_perfil;
    String aveID;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aves_catalogadas_expandida);

        getSupportActionBar().hide();
        iniciarComponentes();

        super.onStart();

        DocumentReference docRef = db.collection("aves").document(aveID);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {
                if (documentSnapshot != null){
                    nomeAveCatalogadaExpandida.setText(documentSnapshot.getString("nomeAve"));
                    nomeCientificoAveExpandida.setText(documentSnapshot.getString("nomeCientifico"));
                    descricaoAveExpandida.setText(documentSnapshot.getString("descricaoAve"));
                    String uri = documentSnapshot.getString("imagemAve");
                    imagemAveCatalogadaExpandida.setImageURI(Uri.parse(uri));
                }
            }
        });
    }
    private void iniciarComponentes(){
        nomeAveCatalogadaExpandida = findViewById(R.id.nomeAveCatalogadaExpandida);
        nomeCientificoAveExpandida = findViewById(R.id.nomeCientificoAveExpandida);
        imagemAveCatalogadaExpandida = findViewById(R.id.imagemAveCatalogadaExpandida);
        descricaoAveExpandida = findViewById(R.id.descricaoAveCatalogada);
        bt_perfil = findViewById(R.id.nav_perfil);
        bt_pesquisa = findViewById(R.id.nav_search);
        bt_principal = findViewById(R.id.nav_home);

        iniciarBottomMenu();
    }

    private void iniciarBottomMenu(){
        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvesCatalogadasExpandida.this, TelaPerfil.class);
                startActivity(intent);
                finish();
            }
        });

        bt_pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvesCatalogadasExpandida.this, TelaPesquisa.class);
                startActivity(intent);
                finish();
            }
        });

        bt_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvesCatalogadasExpandida.this, AvesCatalogadas.class);
                startActivity(intent);
                finish();
            }
        });
    }
}