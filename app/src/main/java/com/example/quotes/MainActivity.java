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
    private TextView titleTextView;
    private ImageView chuckNorrisIcon;
    private TextView quoteTextView;
    private Button quoteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTextView = findViewById(R.id.title_TV);
        chuckNorrisIcon = findViewById(R.id.chuckIcon);
        quoteTextView = findViewById(R.id.quote_TV);
        quoteButton = findViewById(R.id.quote_BT);

        quoteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                achieveQuote();
            }
        });

    }

    public void achieveQuote() {

        // Retrofit interface to parse the retreived json
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.chucknorris.io/").addConverterFactory(GsonConverterFactory.create()).build();

        // get service and all object or request
        getQuote service = retrofit.create(getQuote.class);
        Call<QuoteResponse> quotesCall = service.getDevQuote("dev");

        quotesCall.enqueue(new Callback<QuoteResponse>() {
            @Override
            public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {
                QuoteResponse quote = response.body();
                String devQuote = "";
                devQuote = quote.getQuote();

                quoteTextView.setText(devQuote);
            }

            @Override
            public void onFailure(Call<QuoteResponse> call, Throwable t) {
                System.out.println("Could not get quote from API!");
            }
        });


    }


}
