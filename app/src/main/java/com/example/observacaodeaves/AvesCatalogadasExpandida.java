package com.example.observacaodeaves;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

public class AvesCatalogadasExpandida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aves_catalogadas_expandida);

        getSupportActionBar().hide();
    }
}