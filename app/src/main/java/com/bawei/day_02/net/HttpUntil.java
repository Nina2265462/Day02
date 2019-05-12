package com.bawei.day_02.net;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.google.common.io.CharStreams;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/*
 *@Auther:cln
 *@Date: 时间
 *@Description:功能
 * */
public class HttpUntil {
    private static final HttpUntil ourInstance = new HttpUntil();

    public static HttpUntil getInstance() {
        return ourInstance;
    }

    private HttpUntil() {
    }

    @SuppressLint("StaticFieldLeak")
    public void doHttpGet(final String surl, final CallBackPost post) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    if (connection.getResponseCode() == 200) {
                        return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                post.onSuccess(s);
            }
        }.execute(surl);
    }

    @SuppressLint("StaticFieldLeak")
    public void doHttpPost(String surl, final String phone, final String pwd, final CallBackPost backPost) {
        new AsyncTask<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                try {
                    URL url = new URL(strings[0]);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setConnectTimeout(5000);
                    connection.setReadTimeout(5000);
                    //插入参数
                    String body = "phone="+ URLEncoder.encode(phone)+"&pwd="+URLEncoder.encode(pwd);
                    connection.setDoOutput(true);
                    connection.getOutputStream().write(body.getBytes());
                    if (connection.getResponseCode() == 200) {
                        return CharStreams.toString(new InputStreamReader(connection.getInputStream()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String s) {
                backPost.onSuccess(s);
            }
        }.execute(surl);
    }
}
