package afpa.ecf.physicalregatta.android.api;

import android.os.AsyncTask;

import com.google.gson.reflect.TypeToken;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import afpa.ecf.physicalregatta.android.Utils;
import afpa.ecf.physicalregatta.android.model.Regatta;

/**
 * Created by Afpa on 28/02/2017.
 */

public class RegattaProvider extends AsyncTask<String, Void, ArrayList<Regatta>> {

    @Override
    protected void onPostExecute(ArrayList<Regatta> r) {
        super.onPostExecute(r);
    }

    @Override
    protected ArrayList<Regatta> doInBackground(String... params) {

        ArrayList<Regatta> regattas = null;

        StringBuilder sb = null;
        HttpURLConnection urlConnection;
        String line;


        try {

            URL url = new URL("http://10.105.49.11:8080/api/regatta");
            System.out.println(url);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(10000);
            urlConnection.setRequestMethod("GET");
            urlConnection.setRequestProperty("User-Agent", "PhysicalRegatta-v0.1");
            urlConnection.setRequestProperty("Accept", "application/json");
            urlConnection.connect();

            sb = new StringBuilder();
            if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("Connection established, retrieving data");
                InputStream inst = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(inst));


                while ((line = br.readLine()) != null) {

                    sb.append(line);

                }
                br.close();

            } else {

                System.out.println("Error connecting server: " + urlConnection.getResponseCode());

            }
            urlConnection.disconnect();
            Type listType = new TypeToken<ArrayList<Regatta>>(){}.getType();
            regattas = Utils.GSON.fromJson(sb.toString(), listType);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return regattas;
    }
}