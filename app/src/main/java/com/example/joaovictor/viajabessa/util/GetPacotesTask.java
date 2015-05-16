package com.example.joaovictor.viajabessa.util;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.joaovictor.viajabessa.PacotesListaAdapter;
import com.example.joaovictor.viajabessa.R;
import com.example.joaovictor.viajabessa.SinglePacote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by joaovictor on 11/05/2015.
 * Classe para fazer uma tarefa assincorna com ApiGetRealJson
 * AsyncTask<ApiGetRealJson,Progresso,Resultado>
 */
public class GetPacotesTask extends AsyncTask<ApiGetRealJson,Long,JSONArray> {

    ListView list;
    private final Activity activity;
    private ProgressDialog progressDialog;
    public final static String ID_EXTRA = "com.example.joaovictor.viajabessa._ID";
    /*
    *Passo o Activity que esta sendo usado.
     */
    public GetPacotesTask(Activity activity) {
        this.activity = activity;
    }

    /*
    *Crio um dialogo para o usuario ao pre execução
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //progressDialog = new ProgressDialog(activity);
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

        final ArrayList<Pacotes> Listapacotes = new ArrayList<Pacotes>();
        try {

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject json = null;
                try {
                    json = jsonArray.getJSONObject(i);
                    Pacotes pacote = new Pacotes(json.getString("nome"),json.getString("valor"),json.getString("foto"),json.getString("descricao"),json.getString("id"));
                    Listapacotes.add(pacote);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            PacotesListaAdapter adapter = new PacotesListaAdapter(activity,Listapacotes);

            list = (ListView) activity.findViewById(R.id.list);
            list.setAdapter(adapter);
            System.out.println(Listapacotes);

        /*
        *Passos os dados para uma nova Activity (SinglePacoteOLD)->(activity_single_pacotes.xml)
*/

            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    try {
                        Intent i = new Intent(activity, SinglePacote.class);
                        i.putExtra(ID_EXTRA, String.valueOf(id));
                        i.putExtra("pacotes", Listapacotes);
                        activity.startActivity(i);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    }
                }

                );

            }catch (Exception e){
            e.printStackTrace();
        }

    }
}
