package com.example.mikhail.project10012019;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MeteoAdapter extends
        RecyclerView.Adapter<MeteoAdapter.ViewHolder> {
    private List<Meteo> data;

    public MeteoAdapter(final List<Meteo> data) {
        this.data = data;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_meteo,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(data.get(position).date);
        holder.tod.setText(data.get(position).tod);
        holder.temp.setText(data.get(position).temp);
        holder.humidity.setText(data.get(position).humidity);
        holder.cloud.setText(data.get(position).cloud);
        holder.wind.setText(data.get(position).wind);
        holder.pressure.setText(data.get(position).pressure);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public void setData(List<Meteo> data) {
        this.data = data;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView date;
        private TextView tod;
        private TextView pressure;
        private TextView temp ;
        private TextView  humidity ;
        private TextView  wind ;
        private TextView  cloud;


        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            date = view.findViewById(R.id.date);
            tod = view.findViewById(R.id.tod);
            pressure = view.findViewById(R.id.pressure);
            humidity = view.findViewById(R.id.humidity);
            wind = view.findViewById(R.id.wind);
            cloud = view.findViewById(R.id.cloud);
            temp = view.findViewById(R.id.temp);

        }

    }


}
