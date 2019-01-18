package com.example.mikhail.project10012019;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {


    public String HOST = "http://icomms.ru/";

   @GET("inf/meteo.php")
   Call<List<Meteo>> getMeteo(@Query("tid") int tid);




}
