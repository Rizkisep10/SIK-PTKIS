package com.septian.sikptkis;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.septian.sikptkis.model.Universitas;

import java.util.List;

public class UniversitasAdapter extends RecyclerView.Adapter<UniversitasAdapter.ViewHolder> {

    private Context context;
    private List<Universitas> universitasList;



    public UniversitasAdapter(Context context, List<Universitas> universitasList) {
        this.context = context;
        this.universitasList = universitasList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_item_universitas, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewHead.setText(universitasList.get(position).getNama());

    }

    @Override
    public int getItemCount() {
        return universitasList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setClickable(true);
            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(context, DetailUniversitasActivity.class);
                    intent.putExtra("id",universitasList.get(getAdapterPosition()).getId());
                    context.startActivity(intent);
                }
            });
        }
    }
}