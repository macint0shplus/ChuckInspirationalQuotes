package com.example.quotes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuoteResponse {

    @SerializedName("icon_url")
    @Expose
    private String iconUrl;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("url")
    @Expose
    private String url;

    @SerializedName("value")
    @Expose
    private String value;

    public String getQuote(){
        return value;
    }

}
