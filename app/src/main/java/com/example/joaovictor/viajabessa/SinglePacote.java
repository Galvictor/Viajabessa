package com.example.joaovictor.viajabessa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joaovictor.viajabessa.util.GetPacotesTask;
import com.example.joaovictor.viajabessa.util.Pacotes;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class SinglePacote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_pacote2);

        Locale meuLocal = new Locale( "pt", "BR" );
        NumberFormat nfVal = NumberFormat.getCurrencyInstance(meuLocal);


        String passedVar = getIntent().getStringExtra(GetPacotesTask.ID_EXTRA);

        ArrayList<Pacotes> pacotes = (ArrayList<Pacotes>) getIntent().getSerializableExtra("pacotes");
        int position = Integer.parseInt(passedVar);

        TextView passedView = (TextView) findViewById(R.id.textView);
        TextView passedViewValor = (TextView) findViewById(R.id.textViewValor);
        ImageView passedImage = (ImageView)findViewById(R.id.imageViewSingle);


        double valorReal = Double.parseDouble(pacotes.get(position).getValores());

        Picasso.with(this).load(pacotes.get(position).getUrl_imagens()).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).fit().centerCrop().into(passedImage);
        passedView.setText(pacotes.get(position).getDescricao());
        passedViewValor.setText(nfVal.format(valorReal));

    }

}
