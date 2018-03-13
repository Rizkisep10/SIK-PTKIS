package com.septian.sikptkis.util;

import com.septian.sikptkis.model.DataBeritaFakReq;
import com.septian.sikptkis.model.DataBeritaJurReq;
import com.septian.sikptkis.model.DataBeritaUnivReq;
import com.septian.sikptkis.model.Fakultas;
import com.septian.sikptkis.model.FakultasReq;
import com.septian.sikptkis.model.JurusanReq;
import com.septian.sikptkis.model.Universitas;
import com.septian.sikptkis.model.UniversitasReq;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by septian on 3/12/2018.
 */

public interface SIKPtkisApis {

    @GET("universitas")
    Call<UniversitasReq> getAllUniv();

    @GET("universitas/{id_univ}")
    Call<Universitas> getUnivById(@Path("id_univ")Integer id_univ);

    @GET("fakultas/{id_univ}")
    Call<Fakultas> getFak(@Path("id_univ")Integer id_univ);

    @GET("fakultas/{id_univ}")
    Call<FakultasReq> getAllFakById(@Path("id_univ")Integer id_univ);

    @GET("jurusans/{id_univ}/{id_fak}")
    Call<JurusanReq> getAllJur(@Path("id_univ")Integer id_univ,@Path("id_fak")Integer id_fak);

    @GET("data_berita_univs/{id_univ}")
    Call<DataBeritaUnivReq> getDataBeritaUniv(@Path("id_univ")Integer id_univ);

    @GET("data_berita_faks/{id_univ}/{id_fak}")
    Call<DataBeritaFakReq> getDataBeritaFak(@Path("id_univ")Integer id_univ,@Path("id_fak")Integer id_fak);

    @GET("data_berita_faks/{id_univ}/{id_fak}/{id_jur}")
    Call<DataBeritaJurReq> getDataBeritaJur(@Path("id_univ")Integer id_univ,@Path("id_fak")Integer id_fak,@Path("id_jur")Integer id_jur);
 }
