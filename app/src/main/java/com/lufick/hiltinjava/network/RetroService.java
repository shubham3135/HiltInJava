package com.lufick.hiltinjava.network;

import com.lufick.hiltinjava.model.RecyclerList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroService {
    @GET("repositories")
    Call<RecyclerList> getDataFromGitHubApi(@Query("q") String query);
}
