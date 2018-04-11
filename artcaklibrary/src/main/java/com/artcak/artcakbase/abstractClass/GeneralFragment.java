package com.artcak.artcakbase.abstractClass;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.artcak.artcakbase.apis.GeneralApi;
import com.artcak.artcakbase.tools.Tools;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeneralFragment extends Fragment {
    protected Retrofit retrofit;
    protected Gson gson;
    protected Tools tools;
    protected GeneralApi generalApi;
    private String BASE_API = "";

    public void setBASE_API(String BASE_API) {
        this.BASE_API = BASE_API;
        createRetrofit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gson = new GsonBuilder().create();
        createRetrofit();
        generalApi = retrofit.create(GeneralApi.class);
        tools = new Tools(getActivity());
    }

    protected void createRetrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_API)
                .client(httpClient.build())
                .build();
    }
}
