package com.example.mikhail.project10012019;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends MvpAppCompatActivity implements IMainView {
  @InjectPresenter
    public MainPresenter presenter;
    public  RecyclerView list;
    public ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);
        progress = findViewById(R.id.progress);
        presenter.login(list);


    }

    private void setProgress(boolean flag) {
        if (flag) {
            list.setVisibility(View.GONE);
            progress.setVisibility(View.VISIBLE);
        } else {
            list.setVisibility(View.VISIBLE);
            progress.setVisibility(View.GONE);
        }
    }


    @Override
    public void load() {
        setProgress(true);
    }

    @Override
    public void ok(List<Meteo> main) {
        MeteoAdapter adapter = new MeteoAdapter(main);
        list.setAdapter(adapter);
        list.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        setProgress(false);

    }

    @Override
    public void error(String msg) {
        setProgress(false);
        Toast.makeText(getApplicationContext(),
                msg,
                Toast.LENGTH_LONG)
                .show();
    }
}












/*public class MainActivity extends AppCompatActivity {

    private RecyclerView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(APIService.HOST)
                .addConverterFactory(GsonConverterFactory
                        .create())
                .build();
        APIService apiService = retrofit.create(APIService.class);

        Call <List<Meteo>> call = apiService.getMeteo(57);
        call.enqueue(new Callback<List<Meteo>>() {
            @Override
            public void onResponse(Call<List<Meteo>> call, Response<List<Meteo>> response) {
                MeteoAdapter adapter = new MeteoAdapter(response.body());
                list.setAdapter(adapter);
                list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<List<Meteo>> call, Throwable t) {

            }
        });


    }
}*/










