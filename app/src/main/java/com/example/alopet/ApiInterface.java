package com.example.alopet;
import com.example.alopet.Model.Headlines;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
@GET("top-headlines")
Call<Headlines> getHeadlines(
@Query("country") String country,
        @Query("apiKey") String apiKey,
@Query("category") String category
    );

}
