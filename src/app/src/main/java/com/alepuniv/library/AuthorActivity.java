package com.alepuniv.library;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;

import com.alepuniv.library.api.LibraryAPI;
import com.alepuniv.library.api.RetrofitHelper;
import com.alepuniv.library.model.entity.Author;

import java.io.IOException;

public class AuthorActivity extends AppCompatActivity {

    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc19hZG1pbiI6ImZhbHNlIiwiaWQiOiIxIiwiaWF0IjoxNjQ2NTMzMDgxfQ.CBukzUtzpovRxG4pnRpj_3VWQ1EJhEz8_4eK1a94vyI";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);


        Call<Author> call = RetrofitHelper.getLibraryAPI(token).getAuthor(1);
        try {
            Author authorResult = call.execute().body();
            //Show authorResult on the activity
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}