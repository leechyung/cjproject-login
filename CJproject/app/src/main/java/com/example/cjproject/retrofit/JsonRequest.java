package com.example.cjproject.retrofit;

import com.google.gson.annotations.SerializedName;

public class JsonRequest {
    @SerializedName("userSeq")
    private int userSeq;

    public JsonRequest(int userSeq) {
        this.userSeq=userSeq;
    }

}
