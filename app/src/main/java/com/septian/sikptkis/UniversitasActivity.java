package com.septian.sikptkis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.septian.sikptkis.model.Universitas;
import com.septian.sikptkis.model.UniversitasReq;
import com.septian.sikptkis.util.ApiClient;
import com.septian.sikptkis.util.SIKPtkisApis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class UniversitasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<Universitas> universitasList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_universitas);


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        universitasList = new ArrayList<>();
        test();
    }
    private void test() {
        Retrofit mRetrofit = ApiClient.newInstance();
        SIKPtkisApis allUnivService = mRetrofit.create(SIKPtkisApis.class);

        allUnivService.getAllUniv().enqueue(new Callback<UniversitasReq>() {
            @Override
            public void onResponse(Call<UniversitasReq> call, Response<UniversitasReq> response) {
                if(response.code() == 200){
                    for(Universitas u : response.body().getData()){
                        Universitas universitas = new Universitas();
                        universitas.setId(u.getId());
                        universitas.setNama(u.getNama());
                        universitasList.add(universitas);

                    }
                    adapter = new UniversitasAdapter(UniversitasActivity.this,universitasList);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<UniversitasReq> call, Throwable t) {

            }
        });

    }
}