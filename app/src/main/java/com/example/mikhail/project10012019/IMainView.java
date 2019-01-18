package com.example.mikhail.project10012019;

import com.arellomobile.mvp.MvpView;

import java.util.List;

import retrofit2.Retrofit;

public interface IMainView extends MvpView {
    public void load();
    public void ok (List<Meteo> main);

    public void error (String msg);
}
