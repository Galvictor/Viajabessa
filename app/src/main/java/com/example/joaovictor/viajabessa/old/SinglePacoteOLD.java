package com.example.joaovictor.viajabessa.old;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joaovictor.viajabessa.R;
import com.example.joaovictor.viajabessa.util.old.GetPacotesTaskOLD;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;


public class SinglePacoteOLD extends AppCompatActivity {

    /*
    *Recebo os dados da outra activity e preencho em suas determinadas tags e ids do xml activity_single_pacote.xml.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_pacote);

        Locale meuLocal = new Locale( "pt", "BR" );
        NumberFormat nfVal = NumberFormat.getCurrencyInstance(meuLocal);


        String passedVar = getIntent().getStringExtra(GetPacotesTaskOLD.ID_EXTRA);

        ArrayList<String> stringArrayListDescricao = getIntent().getStringArrayListExtra("descricao-array");
        ArrayList<String> stringArrayListIdsPacote = getIntent().getStringArrayListExtra("id-array");
        ArrayList<String> stringArrayListFotos = getIntent().getStringArrayListExtra("foto-array");
        ArrayList<String> stringArrayListValores = getIntent().getStringArrayListExtra("valor-array");

        TextView passedView = (TextView) findViewById(R.id.textView);
        TextView passedViewValor = (TextView) findViewById(R.id.textViewValor);
        ImageView passedImage = (ImageView)findViewById(R.id.imageViewSingle);

        int foo = Integer.parseInt(passedVar);
        double valorReal = Double.parseDouble(stringArrayListValores.get(foo));

        Picasso.with(this).load(stringArrayListFotos.get(foo)).placeholder(R.drawable.ic_launcher).error(R.drawable.ic_launcher).fit().centerCrop().into(passedImage);
        passedView.setText(stringArrayListDescricao.get(foo));
        passedViewValor.setText(nfVal.format(valorReal));

    }

}
