package com.example.mikhail.project10012019;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@InjectViewState
public class MainPresenter extends MvpPresenter <IMainView> {
    Retrofit retrofit;

    public void login(RecyclerView list) {
        getViewState().load();
        retrofit = new Retrofit.Builder().baseUrl(APIService.HOST).
                addConverterFactory(GsonConverterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);
        Call <List<Meteo>> call = apiService.getMeteo(57);
        call.enqueue(new Callback<List<Meteo>>() {
            @Override
            public void onResponse(Call<List<Meteo>> call, Response<List<Meteo>> response) {
               getViewState().ok(response.body());
            }

            @Override
            public void onFailure(Call<List<Meteo>> call, Throwable t) {
               getViewState().error("error");
            }

        });
    }
}
