package com.example.joaovictor.viajabessa.util.old;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.joaovictor.viajabessa.old.CustomListAdapterOLD;
import com.example.joaovictor.viajabessa.R;
import com.example.joaovictor.viajabessa.old.SinglePacoteOLD;
import com.example.joaovictor.viajabessa.util.ApiGetRealJson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by joaovictor on 11/05/2015.
 * Classe para fazer uma tarefa assincorna com ApiGetRealJson
 * AsyncTask<ApiGetRealJson,Progresso,Resultado>
 */
public class GetPacotesTaskOLD extends AsyncTask<ApiGetRealJson,Long,JSONArray> {

    ListView list;
    private final Activity context;
    private ProgressDialog progressDialog;
    public final static String ID_EXTRA = "com.example.joaovictor.viajabessa._ID";
/*
*Passo o Activity que esta sendo usado.
 */
    public GetPacotesTaskOLD(Activity context) {
        this.context = context;
    }

    /*
    *Crio um dialogo para o usuario ao pre execução
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //progressDialog = new ProgressDialog(context);
        //progressDialog.setMessage("Carregando Dados");
        //progressDialog.show();
    }


    @Override
    protected void onProgressUpdate(Long... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected JSONArray doInBackground(ApiGetRealJson... params) {
        return params[0].ApiGetRealJson();
}
    /*
    *Ao terminar passo os dados para o setTextTolistView
     */
    @Override
    protected void onPostExecute(JSONArray jsonArray) {
        super.onPostExecute(jsonArray);
        //progressDialog.dismiss();
        setTextToListView(jsonArray);
    }

    /*
    *Recebo os dados em JSONArray e construo 3 ArrayList tipo sting do que eu preciso
    * titulos,valores,urls_imagens.
    * Envio esses Arrays para o meu CustomListAdapterOLD para criar a lista
     */
    private void setTextToListView(JSONArray jsonArray) {

        final ArrayList<String> titulos = new ArrayList<String>();
        final ArrayList<String> valores = new ArrayList<String>();
        final ArrayList<String> urls_imagens = new ArrayList<String>();
        final ArrayList<String> descricao = new ArrayList<String>();
        final ArrayList<String> id_pacote = new ArrayList<String>();
try {

    for (int i = 0; i < jsonArray.length(); i++) {

        JSONObject json = null;
        try {
            json = jsonArray.getJSONObject(i);
            id_pacote.add(json.getString("id"));
            titulos.add(json.getString("nome"));
            descricao.add(json.getString("descricao"));
            valores.add(json.getString("valor"));
            urls_imagens.add(json.getString("foto"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    CustomListAdapterOLD adapter = new CustomListAdapterOLD(context, titulos, valores, urls_imagens);

    list = (ListView) context.findViewById(R.id.list);
    list.setAdapter(adapter);

        /*
        *Passos os dados para uma nova Activity (SinglePacoteOLD)->(activity_single_pacotes.xml)
         */

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view,
                                int position, long id) {
            Intent i = new Intent(context, SinglePacoteOLD.class);
            i.putExtra(ID_EXTRA, String.valueOf(id));
            i.putExtra("descricao-array", descricao);
            i.putExtra("id-array", id_pacote);
            i.putExtra("foto-array", urls_imagens);
            i.putExtra("valor-array", valores);
            context.startActivity(i);

        }
    });
} catch (Exception e){
    e.printStackTrace();
}

    }
}
