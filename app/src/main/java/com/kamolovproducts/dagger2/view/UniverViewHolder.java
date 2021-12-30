package com.kamolovproducts.dagger2.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kamolovproducts.dagger2.R;
import com.kamolovproducts.dagger2.modleunivers.UniverModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UniverViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageView)
        ImageView countryImage;
        @BindView(R.id.name)
        TextView countryName;
        @BindView(R.id.capital)
        TextView countryCapital;


        //view that needs to be displayed
        public UniverViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //information that needs to be displayed. Need to make a connection between the two.
        void bind(UniverModel country) {
            countryName.setText(country.getCountryName());
            countryCapital.setText(country.getCapital());
            Util.loadImage(countryImage, country.getImage(), Util.getProgressDrawable(countryImage.getContext()));
        }

}
