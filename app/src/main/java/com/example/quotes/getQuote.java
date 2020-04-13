package com.example.quotes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface getQuote {
    // API call to retrieve the quote
    @GET("jokes/random")

    // Receive a quote object, which will have its attributes stored in QuoteResponse
    // @Query was used in order to query the category of quote
    // This solution was found in StackOverflow (https://stackoverflow.com/questions/35964147/illegalargumentexception-in-retrofit-must-not-have-replace-block)
    // You cant use @Path for queries, and you cant use @Query for situations using @GET. I don't know if this is just retrofit2...
    Call<QuoteResponse> getDevQuote(@Query("category") String category);
}
