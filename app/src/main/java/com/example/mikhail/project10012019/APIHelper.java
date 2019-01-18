package com.example.mikhail.project10012019;

import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIHelper {

    interface OnCallback {
        void callback();
        void error();

    }


    public static void login (final OnCallback callback){
        AsyncTask<Void, Void, Void> execute = new AsyncTask<Void, Void, Void>() {





            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(APIService.HOST)
                    .addConverterFactory(GsonConverterFactory
                            .create())
                    .build();






            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return null;
            }


            @Override
            protected void onPostExecute(Void aVoid) {
                callback.callback();
            }
        }.execute();
    }
}
