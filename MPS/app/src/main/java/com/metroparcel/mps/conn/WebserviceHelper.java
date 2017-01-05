package com.metroparcel.mps.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.ConnectionPool;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.internal.http2.Header;

public class WebserviceHelper {
    private static OkHttpClient client;

    public static void initialize() {
        client = new OkHttpClient();
        client.newBuilder().connectTimeout(100, TimeUnit.SECONDS).build();
    }

    public static String doPost(String url, RequestBody body, String token) throws IOException {
        Headers headers = new Headers.Builder()
                .add("Authorization", "Bearer "+token).build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .headers(headers)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String doGet(String url, String token) throws IOException {
        Headers headers = new Headers.Builder()
                .add("Authorization", "Bearer "+token).build();
        Request request = new Request.Builder()
                .url(url)
                .addHeader("Authorization", "Bearer "+token)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
