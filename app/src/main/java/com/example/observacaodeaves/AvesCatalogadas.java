package com.example.observacaodeaves;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormatSymbols;
import java.util.ArrayList;

public class AvesCatalogadas extends AppCompatActivity {

    private ListView ivAves;
    private String[] aves;
    private TextView especies;

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
    }
}