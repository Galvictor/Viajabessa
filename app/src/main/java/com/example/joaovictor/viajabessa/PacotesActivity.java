package com.example.joaovictor.viajabessa;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.joaovictor.viajabessa.util.ApiGetRealJson;
import com.example.joaovictor.viajabessa.util.GetPacotesTask;


public class PacotesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pacotes);

    /*
    Checo se ha conexão com a internet
    *Executo o GetPacotesTask e faço a solicitação do ApiGetRealJson
     */
        ConnectivityManager cm = (ConnectivityManager) getSystemService(this.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();

        if(ni == null){
            new AlertDialog.Builder(this)
                    .setTitle("Sem Conexão")
                    .setMessage("Sem conexão com a internet").show();
        } else {
            new GetPacotesTask(this).execute(new ApiGetRealJson());
        }

    }


}
