package com.example.raldoron.jsoncards;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Raldoron on 26.10.17.
 */

public class JsonPlaceholder {
    private static Retrofit retrofit;

    public static JsonFakeAPI getAPI() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Config.JSONPlaceholder_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(JsonFakeAPI.class);
    }
}
