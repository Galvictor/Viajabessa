package com.example.joaovictor.viajabessa;


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
    *Executo o GetPacotesTask e faço a solicitação do ApiGetRealJson
     */
    new GetPacotesTask(this).execute(new ApiGetRealJson());

    }


}
