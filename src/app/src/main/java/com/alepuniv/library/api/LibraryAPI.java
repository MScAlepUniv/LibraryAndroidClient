package com.alepuniv.library.api;

import com.alepuniv.library.model.entity.*;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LibraryAPI {

    @GET("/mysql/common/getAuthor/{id}")
    Call<Author> getAuthor(@Path("id") int id);


}
