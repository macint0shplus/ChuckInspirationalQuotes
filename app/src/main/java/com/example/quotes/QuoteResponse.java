package com.example.quotes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

// QuoteResponse class
public class QuoteResponse {

    // Details and methods for icon_url
    @SerializedName("iceon_url")
    @Expose
    private String iconUrl;

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getIconUrl() {
        return iconUrl;
    }


    // Details and methods for id
    @SerializedName("id")
    @Expose
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    // Details and methods for url
    @SerializedName("url")
    @Expose
    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }


    // Details and methods for value
    @SerializedName("value")
    @Expose
    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}