package com.septian.sikptkis;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.septian.sikptkis.model.Fakultas;

import java.util.List;



public class FakultasAdapter extends RecyclerView.Adapter<FakultasAdapter.ViewHolder> {

    private Context context;
    private List<Fakultas> fakultasList;


    public FakultasAdapter(Context context, List<Fakultas> fakultasList) {
        this.context = context;
        this.fakultasList = fakultasList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_item_fakultas, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_list_fakultas.setText(fakultasList.get(position).getNama());

    }

    @Override
    public int getItemCount() {
        return fakultasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_list_fakultas;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            tv_list_fakultas = (TextView) itemView.findViewById(R.id.tv_list_fakultas);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailFakultasActivity.class);
                    Log.d("id", String.valueOf(fakultasList.get(getAdapterPosition()).getNama()));
                    intent.putExtra("id",fakultasList.get(getAdapterPosition()).getId());
                    intent.putExtra("id_univ",fakultasList.get(getAdapterPosition()).getIdUniv());
                    context.startActivity(intent);
                }
            });
        }
    }
}
