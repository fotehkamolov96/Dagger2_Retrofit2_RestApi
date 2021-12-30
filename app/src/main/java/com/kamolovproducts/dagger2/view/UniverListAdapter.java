package com.kamolovproducts.dagger2.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kamolovproducts.dagger2.NewDetails;
import com.kamolovproducts.dagger2.R;
import com.kamolovproducts.dagger2.modleunivers.UniverModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UniverListAdapter extends RecyclerView.Adapter<UniverListAdapter.UniverViewHolder> {
    private final List<UniverModel> univerModels;

    //TODO 3- New variable from the interface
    private OnItemClickListener listener;

    public UniverListAdapter(List<UniverModel> countries) {
        this.univerModels = countries;
    }

    public void updateCountries(List<UniverModel> univerModels) {
        this.univerModels.clear();
        this.univerModels.addAll(univerModels);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UniverViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
        return new UniverViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UniverViewHolder holder, @SuppressLint("RecyclerView") int i) {

        holder.bind(univerModels.get(i));
        String modifiedTitle = univerModels.get(i).getCountryName().split("-")[0].trim();
        holder.countryName.setText(modifiedTitle);
        holder.countryCapital.setText(univerModels.get(i).getCapital());

        //NEW ACTIVITY
  /*      holder.itemView.setOnClickListener(v -> {
            Toast toast = Toast.makeText(v.getContext(),
                    "Пора покормить кота!", Toast.LENGTH_SHORT);
            toast.show();

        *//* Intent i = new Intent(context, NewDetails.class);
            context.startActivity(i );*//*


        });*/
    }

    @Override
    public int getItemCount() {
        return univerModels.size();
    }

    class UniverViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView countryImage;

        @BindView(R.id.name)
        TextView countryName;

        @BindView(R.id.capital)
        TextView countryCapital;


        public UniverViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(view -> {

                //get the current position
                int position = getAdapterPosition();
                //check if the listener not null
                //check if the clicked position is not a -1 or null
                if (listener != null && position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(univerModels.get(position));
                }
            });
        }

        //information that needs to be displayed. Need to make a connection between the two.
        void bind(UniverModel country) {
            countryName.setText(country.getCountryName());
            countryCapital.setText(country.getCapital());
            Util.loadImage(countryImage, country.getImage(), Util.getProgressDrawable(countryImage.getContext()));
        }
    }


    public interface OnItemClickListener {
        void onItemClick(UniverModel univerModel);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

}
