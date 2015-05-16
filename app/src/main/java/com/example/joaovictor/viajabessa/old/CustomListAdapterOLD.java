package com.example.joaovictor.viajabessa.old;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.joaovictor.viajabessa.R;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by joaovictor on 11/05/2015.
 * Classe para criar as listas com sua determinadas posições.
 */
public class CustomListAdapterOLD extends ArrayAdapter<String> {
    private final Activity context;
    private final ArrayList<String> titulos;
    private final ArrayList<String> imagens;
    private final ArrayList<String> valores;

    public CustomListAdapterOLD(Activity context, ArrayList<String> titulos, ArrayList<String> valores, ArrayList<String> imagens){
        super(context, R.layout.mylist,titulos);

        this.context = context;
        this.valores = valores;
        this.imagens = imagens;
        this.titulos = titulos;
    }
/*
*Faço uma classe static para guardar.
 */
    public static class Holder
    {
        public TextView nome;
        public TextView valor;
        public ImageView image;
        public static ProgressBar progress;

    }
/*
*Chamo a classe static Holder para guardar...
* Faço uma view e seto em seus determinadas posições na lista.
* Converto a formatação para o preço em Real do Brasil
 */
    public View getView(int position,View view,ViewGroup parent) {

        final Holder holder = new Holder();
        Locale meuLocal = new Locale( "pt", "BR" );
        NumberFormat nfVal = NumberFormat.getCurrencyInstance(meuLocal);

        double valorReal = Double.parseDouble(valores.get(position));
//LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.mylist, null, true);


        holder.nome = (TextView) rowView.findViewById(R.id.item);
        holder.image = (ImageView) rowView.findViewById(R.id.icon);
        holder.valor = (TextView) rowView.findViewById(R.id.valor);

        holder.nome.setText(titulos.get(position));
        holder.valor.setText(nfVal.format(valorReal));
        /*
        *Uso a biblioteca picasso para fazer o download das imagens e preencher em suas determinadas posições
        * Referencia: http://square.github.io/picasso/
         */
        Picasso.with(context).load(imagens.get(position)).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).resize(100, 100).centerCrop().into(holder.image);


        return rowView;

    };
}
