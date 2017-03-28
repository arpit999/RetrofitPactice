package com.production.hometech.retrofitpactice.helper;

import com.production.hometech.retrofitpactice.helper.ApiInterface;
import com.production.hometech.retrofitpactice.model.Contact;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static com.production.hometech.retrofitpactice.R.id.info;


public interface ApiInterface {
    @GET("contacts/")
    Call<Contact> getContactList();

    @GET("movie/{id}")
    Call<Contact> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);
}
