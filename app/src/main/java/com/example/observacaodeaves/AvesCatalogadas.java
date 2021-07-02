package com.example.observacaodeaves;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class AvesCatalogadas extends AppCompatActivity {

    private ListView ivAves;
    private String[] aves;
    private TextView especies;
    private BottomNavigationItemView bt_pesquisa, bt_principal, bt_perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aves_catalogadas);

        getSupportActionBar().hide();
        IniciarComponentes();

        ArrayAdapter adapter = new Adaptador(this, adicionarEspecies());
        ivAves.setAdapter(adapter);


        ivAves.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


            }
        });

    }

    private ArrayList<Especie> adicionarEspecies() {
        ArrayList<Especie> especies = new ArrayList<Especie>();
        Especie e = new Especie("Anu Branco", "Guira Guira", R.drawable.anubranco);
        especies.add(e);
        e = new Especie("Arara Canidé", "Ara ararauna", R.drawable.araracaninde);
        especies.add(e);
        e = new Especie("Rapazinho do Chaco", "Nystalus striatipectus", R.drawable.rapazinhodochaco);
        especies.add(e);
        e = new Especie("Tiriba fogo", "Pyrrhura devillei", R.drawable.tiribafoto);
        especies.add(e);
        e = new Especie("Tucanuçu", "Ramphastos toco", R.drawable.tucanucu);
        especies.add(e);
        e = new Especie("Príncipe", "Pyrocephalus", R.drawable.principe);
        especies.add(e);
        e = new Especie("Sanhaço", "Thraupis", R.drawable.sanhaco);
        especies.add(e);

        return especies;

    }

    private void IniciarComponentes(){
        ivAves = (ListView) findViewById(R.id.ivAves);
        bt_perfil = findViewById(R.id.nav_perfil);
        bt_pesquisa = findViewById(R.id.nav_search);
        bt_principal = findViewById(R.id.nav_home);

        iniciarBottomMenu();
    }

    private void iniciarBottomMenu(){
        bt_perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvesCatalogadas.this, TelaPerfil.class);
                startActivity(intent);
                finish();
            }
        });

        bt_pesquisa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvesCatalogadas.this, TelaPesquisa.class);
                startActivity(intent);
                finish();
            }
        });

        bt_principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AvesCatalogadas.this, AvesCatalogadas.class);
                startActivity(intent);
                finish();
            }
        });
    }
}