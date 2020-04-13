package com.example.quotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.gson.Gson;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    // Initialising UI elements.
    private TextView titleTextView;
    private ImageView chuckNorrisIcon;
    private TextView quoteTextView;
    private Button quoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Giving values to UI elements.
        titleTextView = findViewById(R.id.title_TV);
        chuckNorrisIcon = findViewById(R.id.chuckIcon);
        quoteTextView = findViewById(R.id.quote_TV);
        quoteButton = findViewById(R.id.quote_BT);

        // If the user clicks the button - calls achieveQuote().
        quoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                achieveQuote();
            }
        });
    }

    // Getting the quote.
    public void achieveQuote() {

        // Retrofit Interface to parse the retrieved JSON Object.
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.chucknorris.io/").addConverterFactory(GsonConverterFactory.create()).build();

        // Connecting the QuoteResponse object with the API Endpoint interface.
        // Asking explicitly for the 'dev' quotes.
        getQuote service = retrofit.create(getQuote.class);
        Call<QuoteResponse> quotesCall = service.getDevQuote("dev");

        // Executing the API Call.
        quotesCall.enqueue(new Callback<QuoteResponse>() {
            @Override
            // If the call is successful.
            public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {
                // Retrieving the quote object.
                QuoteResponse quote = response.body();

                // Filtering the quote object to the value - just the quote (though a function in the QuoteResponse class.
                String devQuote = "";
                devQuote = quote.getValue();

                // Updating the textview with the quote.
                quoteTextView.setText(devQuote);
            }

            @Override
            // If the call is unsuccessful.
            public void onFailure(Call<QuoteResponse> call, Throwable t) {
                System.out.println("Could not get quote from API!");
            }
        });
    }
}
