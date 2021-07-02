package com.example.observacaodeaves;

import java.net.URI;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.net.UriCompat;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
    }
}