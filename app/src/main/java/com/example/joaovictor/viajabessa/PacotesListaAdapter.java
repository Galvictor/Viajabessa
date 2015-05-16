package com.example.joaovictor.viajabessa;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.joaovictor.viajabessa.util.Pacotes;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by joaovictor on 16/05/2015.
 */
public class PacotesListaAdapter extends ArrayAdapter<Pacotes> {
    private Activity activity;
    private ArrayList<Pacotes> pacotesList;
    public PacotesListaAdapter(Activity activity,ArrayList<Pacotes> pacotesList){

        super(activity,R.layout.mylist,pacotesList);
        this.activity = activity;
        this.pacotesList = pacotesList;

    }

    public static class Holder
    {
        public TextView nome;
        public TextView valor;
        public ImageView image;
        public static ProgressBar progress;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pacotes PacotePosicao = pacotesList.get(position);
        final Holder holder = new Holder();
        Locale meuLocal = new Locale( "pt", "BR" );
        NumberFormat nfVal = NumberFormat.getCurrencyInstance(meuLocal);

        double valorReal = Double.parseDouble(PacotePosicao.getValores());

        LayoutInflater inflater = activity.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);


        holder.nome = (TextView) rowView.findViewById(R.id.item);
        holder.image = (ImageView) rowView.findViewById(R.id.icon);
        holder.valor = (TextView) rowView.findViewById(R.id.valor);

        holder.nome.setText(PacotePosicao.getTitulos());
        holder.valor.setText(nfVal.format(valorReal));
        /*
        *Uso a biblioteca picasso para fazer o download das imagens e preencher em suas determinadas posições
        * Referencia: http://square.github.io/picasso/
         */
        Picasso.with(activity).load(PacotePosicao.getUrl_imagens()).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).resize(100, 100).centerCrop().into(holder.image);


        return rowView;
    }
}
