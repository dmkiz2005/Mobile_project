package com.example.myapplication.requests;

import android.os.AsyncTask;

import com.example.myapplication.json.JsonReader;
import com.example.myapplication.new_types.Product_orders;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class OneC_Request {


    public interface OnDataLoadedListener {
        void onDataLoaded(List<Product_orders> arrayList);
    }

    public interface OnRequestListener{
        void onRequestComplete(String result);
    }

    public static void sendRequest(final OnRequestListener listener) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    URL url = new URL("http://185.59.100.221:32765/winterApp/hs/tradeagent/products");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Authorization", "Basic " + encodeCredentialsToBase64("testApp", "vd8D2K2i9M"));

                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    return result.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                if (listener != null) {
                    listener.onRequestComplete(result);
                }
            }
        }.execute();
    }

    public static void sendPostRequest(final List<Product_orders> products, final OnRequestListener listener) {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    //URL url = new URL("http://185.59.100.221:32765/winterApp/hs/tradeagent/products");
                    URL url = new URL("https://postman-echo.com/post");
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Content-Type", "application/json");
                    connection.setRequestProperty("Authorization", "Basic " + encodeCredentialsToBase64("testApp", "vd8D2K2i9M"));
                    connection.setDoOutput(true);

                    // Сериализация списка объектов в JSON
                    Gson gson = new Gson();
                    String jsonInputString = JsonReader.convertProductAndProductNameToJson(products);

                    // Отправка данных
                    try (OutputStream os = connection.getOutputStream()) {
                        byte[] input = jsonInputString.getBytes("utf-8");
                        os.write(input, 0, input.length);
                    }

                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    return result.toString();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(String result) {
                if (listener != null) {
                    listener.onRequestComplete(result);
                }
            }
        }.execute();
    }

    private static String encodeCredentialsToBase64(String username, String password) {
        return java.util.Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
    }
}
