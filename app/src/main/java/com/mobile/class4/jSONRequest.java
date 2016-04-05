package com.mobile.class4;

import android.app.Activity;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by MiguelAngel on 09/02/2016.
 */

//Asyntask<params, progress, result>
//Asyncrhonous task = a task that runs concurrently without stopping the main thread
//normally used for streams -> retrieve from web, read a big file, etc

public class jSONRequest extends AsyncTask<String, Void, JSONArray> {

    private Activity activity;

    public jSONRequest(Activity activity){
        this.activity = activity;
    }




    @Override
    protected JSONArray doInBackground(String... params) {

        HttpGet get = new HttpGet(params[0]);
        StringBuilder sb = new StringBuilder();
        HttpClient client = new DefaultHttpClient();
        JSONArray theArray = null;

        try {

            HttpResponse response = client.execute(get);
            StatusLine sl = response.getStatusLine();
            int code = sl.getStatusCode();

            if (code == 200){
                //object that contains data from response
                HttpEntity entity = response.getEntity();

                InputStream is = entity.getContent();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String currentLine;

                while ((currentLine = br.readLine()) != null){
                    sb.append(currentLine);
                    Log.i("JSON, reading...");

                }

            }

            theArray = new JSONArray(sb.toString());


        } catch (Exception e){
            e.printStackTrace();
        }

        return theArray;


    }


    @Override
    protected void onPostExecute(JSONArray jsonArray) {

        if (jsonArray != null){
            Toast.makeText(activity, "JSON READ sucessfully", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(activity, "Faiulure!!", Toast.LENGTH_SHORT).show();

    }


    public interface JSONListener {
        void doSomething(JSONArray array);
    }



}
