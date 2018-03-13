package com.septian.sikptkis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.septian.sikptkis.model.Fakultas;
import com.septian.sikptkis.model.FakultasReq;
import com.septian.sikptkis.util.ApiClient;
import com.septian.sikptkis.util.SIKPtkisApis;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class FakultasActivity extends AppCompatActivity {
    private RecyclerView recyclerViewFakultas;
    private RecyclerView.Adapter adapterFakultas;
    private List<Fakultas> fakultasList;
    int id_univ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fakultas);

        recyclerViewFakultas = (RecyclerView)findViewById(R.id.recyclerViewFakultas);
        recyclerViewFakultas.setHasFixedSize(true);
        recyclerViewFakultas.setLayoutManager(new LinearLayoutManager(this));

        fakultasList= new ArrayList<>();
        id_univ = getIntent().getIntExtra("id_univ",0);
        test7(id_univ);
    }

    private void test7(int id) {
        Retrofit mRetrofit = ApiClient.newInstance();
        SIKPtkisApis allFakultasService = mRetrofit.create(SIKPtkisApis.class);

        allFakultasService.getAllFakById(id).enqueue(new Callback<FakultasReq>() {
            @Override
            public void onResponse(Call<FakultasReq> call, Response<FakultasReq> response) {
                if(response.code() == 200){
                    for(Fakultas u : response.body().getData()){
                        Fakultas fakultas = new Fakultas();
                        fakultas.setId(u.getId());
                        fakultas.setIdUniv(u.getIdUniv());
                        fakultas.setNama(u.getNama());

                        fakultasList.add(fakultas);

                    }
                    adapterFakultas = new FakultasAdapter(FakultasActivity.this,fakultasList);
                    recyclerViewFakultas.setAdapter(adapterFakultas);
                }
            }

            @Override
            public void onFailure(Call<FakultasReq> call, Throwable t) {

            }
        });

    }


}
