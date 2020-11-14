package uz.loving.infinbank.network.interfaces;


import retrofit.http.Query;
import uz.loving.infinbank.models.Repository;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface GitHubApiInterface {
    @GET("/users/{user}/repos")
    Call<ArrayList<Repository>> getRepository(@Path("user") String userName);

}