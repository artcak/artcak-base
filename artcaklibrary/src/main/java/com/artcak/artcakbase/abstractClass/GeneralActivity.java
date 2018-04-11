package com.artcak.artcakbase.abstractClass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.artcak.artcakbase.apis.GeneralApi;
import com.artcak.artcakbase.tools.Tools;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeneralActivity extends AppCompatActivity {
    private String BASE_API = "http://159.89.192.242";
    protected Retrofit retrofit;
    protected Gson gson;
    protected Tools tools;
    protected GeneralApi generalApi;

    public void setBASE_API(String BASE_API) {
        this.BASE_API = BASE_API;
        createRetrofit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new GsonBuilder().create();
        createRetrofit();
        generalApi = retrofit.create(GeneralApi.class);
        tools = new Tools(this);
    }

    protected void createRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }
}
