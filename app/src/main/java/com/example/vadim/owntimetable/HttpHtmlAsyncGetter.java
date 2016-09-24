package com.example.vadim.owntimetable;

import android.os.AsyncTask;
import android.util.Log;

import com.example.vadim.owntimetable.models.TimePeriod;

import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by root on 9/3/16.
 */
public class HttpHtmlAsyncGetter extends AsyncTask<Void, Void, String> {
    private String params = "faculty=0&teacher=&n=700&group=%CA%CD%B2%D2-31%B3%ED%F2&sdate=";
    private String url = "http://109.87.215.169/cgi-bin/timetable.cgi?n=700";

    public HttpHtmlAsyncGetter(TimePeriod timePeriod){
        params += timePeriod.getBeginning_of_period();
        params += "&edate="+ timePeriod.getEnd_of_period();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected void onPostExecute(String aVoid) {
        super.onPostExecute(aVoid);
    }


    @Override
    protected String doInBackground(Void... v) {

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
            IOUtils.copy(is, responseWriter, "windows-1251");
            responeBody = responseWriter.toString();

        } catch (Exception e) {

            System.out.println(e.getMessage());

            return null;

        }

        return responeBody;
    }
}
