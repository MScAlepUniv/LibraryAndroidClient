package com.alepuniv.library.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {

    public static LibraryAPI getLibraryAPI(String authToken){

        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request newRequest  = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + authToken)
                        .build();
                return chain.proceed(newRequest);
            }
        }).build();


        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl("https://library-aleppo-university.herokuapp.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(client)
                        .build();

        LibraryAPI libraryAPI = retrofit.create(LibraryAPI.class);

        return libraryAPI;
    }
}
