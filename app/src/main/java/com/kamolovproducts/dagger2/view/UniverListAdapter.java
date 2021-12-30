package com.kamolovproducts.dagger2.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamolovproducts.dagger2.NewDetails;
import com.kamolovproducts.dagger2.R;
import com.kamolovproducts.dagger2.modleunivers.UniverModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UniverListAdapter extends RecyclerView.Adapter<UniverViewHolder> {
    private final List<UniverModel> univerModels;

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

        //NEW ACTIVITY
        holder.itemView.setOnClickListener(v -> {
            Toast toast = Toast.makeText(v.getContext(), "Пора покормить кота!", Toast.LENGTH_SHORT);
            toast.show();
        /*

        Intent i = new Intent(context, NewDetails.class);
        v.getContext().startActivity(i );

        */

        });

    }

    @Override
    public int getItemCount() {
        return univerModels.size();
    }

}
