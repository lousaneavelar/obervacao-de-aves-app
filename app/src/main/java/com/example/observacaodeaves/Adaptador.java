package com.example.observacaodeaves;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adaptador extends ArrayAdapter<Especie> {
    private final Context context;
    private final ArrayList<Especie> elementos;


    public Adaptador(Context context, ArrayList<Especie> elementos) {
        super(context, R.layout.especie, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.especie, parent, false);
        TextView nomeEscola = (TextView) rowView.findViewById(R.id.txtNomeEspeciesCientifico);
        TextView endereco = (TextView) rowView.findViewById(R.id.txtNomeEspeciesPopular);
        ImageView imagem = (ImageView) rowView.findViewById(R.id.imgAves);
        nomeEscola.setText(elementos.get(position).getNomeCienntifico());
        endereco.setText(elementos.get(position).getNomePopular());
        imagem.setImageResource(elementos.get(position).getImagem());
        return rowView;
    }
}
