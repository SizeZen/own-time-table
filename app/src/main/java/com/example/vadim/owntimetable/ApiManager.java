package com.example.vadim.owntimetable;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by root on 9/3/16.
 */
public class ApiManager extends AsyncTask<Void, Void, String> {
    private String params = "faculty=0&teacher=&n=700&group=%CA%CD%B2%D2-31%B3%ED%F2&sdate=&edate=11.09.2016";
    private String url = "http://109.87.215.169/cgi-bin/timetable.cgi?n=700";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }

    @Override
    protected String doInBackground(Void... voids) {
        InputStream in = null;
        String responeBody;
        try {

            URL url = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8") );

            writer.write(this.params);
            writer.flush();
            writer.close();
            os.close();

            conn.connect();

            InputStream is = conn.getInputStream();
            StringWriter responseWriter = new StringWriter();
            IOUtils.copy(is, responseWriter, "UTF-8");
            responeBody = responseWriter.toString();

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return null;

        }

        return responeBody;
    }
}
