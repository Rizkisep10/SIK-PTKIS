package com.septian.sikptkis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.septian.sikptkis.model.Fakultas;
import com.septian.sikptkis.model.FakultasReq;
import com.septian.sikptkis.model.Jurusan;
import com.septian.sikptkis.util.ApiClient;
import com.septian.sikptkis.util.SIKPtkisApis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailFakultasActivity extends AppCompatActivity {


    Button btListJurusan;
    EditText namaFakultas;

    int id_fak,id_univ;

    List<Fakultas> listFakultas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_fakultas);

        namaFakultas = (EditText) findViewById(R.id.et_nama_fak);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btListJurusan = (Button) findViewById(R.id.btn_jurusan);
        btListJurusan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailFakultasActivity.this, JurusanActivity.class);
                intent.putExtra("id_fak",id_fak);
                intent.putExtra("id_univ",id_univ);
                startActivity(intent);
            }
        });

        id_fak = getIntent().getIntExtra("id", 0);
        id_univ = getIntent().getIntExtra("id_univ", 0);
        getFakultas(id_fak);
    }
    private void getFakultas(Integer id) {
        Retrofit mRetrofit = ApiClient.newInstance();
        SIKPtkisApis allFakultasService = mRetrofit.create(SIKPtkisApis.class);

        allFakultasService.getFak(id).enqueue(new Callback<Fakultas>() {
            @Override
            public void onResponse(Call<Fakultas> call, Response<Fakultas> response) {
                if(response.code() == 200){
                    namaFakultas.setText(response.body().getNama());

                }
            }

            @Override
            public void onFailure(Call<Fakultas> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_fakultas,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_jurusan:
                Intent intent = new Intent(DetailFakultasActivity.this, JurusanActivity.class);
                intent.putExtra("id_fak",id_fak);
                intent.putExtra("id_univ",id_univ);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}