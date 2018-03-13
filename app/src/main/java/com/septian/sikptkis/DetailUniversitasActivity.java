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

import com.septian.sikptkis.model.Universitas;
import com.septian.sikptkis.model.UniversitasReq;
import com.septian.sikptkis.util.ApiClient;
import com.septian.sikptkis.util.SIKPtkisApis;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailUniversitasActivity extends AppCompatActivity {
    EditText etNama;

    Button btListFakultas;

    List<Universitas> listUniversitas;
    int id_univ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_universitas);

        btListFakultas = (Button) findViewById(R.id.btn_fakultas);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        btListFakultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailUniversitasActivity.this, FakultasActivity.class);
                intent.putExtra("id_univ",id_univ );
                startActivity(intent);
            }
        });

        etNama = (EditText) findViewById(R.id.et_nama_univ);

        id_univ = getIntent().getIntExtra("id", 0);

        getUniversitas(id_univ);

    }

    private void getUniversitas(Integer id) {
        Retrofit mRetrofit = ApiClient.newInstance();
        SIKPtkisApis allUnivService = mRetrofit.create(SIKPtkisApis.class);

        allUnivService.getUnivById(id).enqueue(new Callback<Universitas>() {
            @Override
            public void onResponse(Call<Universitas> call, Response<Universitas> response) {
                if (response.code() == 200) {
                    etNama.setText(response.body().getNama());
                }
            }

            @Override
            public void onFailure(Call<Universitas> call, Throwable t) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_universitas,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_fakultas:
                Intent intent = new Intent(DetailUniversitasActivity.this, FakultasActivity.class);
                intent.putExtra("id_univ",id_univ) ;
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}