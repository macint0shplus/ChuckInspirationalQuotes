package com.example.quotes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface getQuote {
    @GET("jokes/random")
    Call<QuoteResponse> getDevQuote(@Query("category") String category);
}
