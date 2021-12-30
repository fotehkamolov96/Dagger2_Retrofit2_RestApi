package com.kamolovproducts.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.kamolovproducts.dagger2.modleunivers.UniverModel;
import com.kamolovproducts.dagger2.view.UniverListAdapter;
import com.kamolovproducts.dagger2.viewmodel.ListViewModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.rv_univer)
    RecyclerView countriesList;
    @BindView(R.id.list_error)
    TextView listError;
    @BindView(R.id.progress_bar_un)
    ProgressBar loadingView;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout refreshLayout;

    @BindView(R.id.updates)
    ImageView imgView;

    private ListViewModel viewModel;
    private UniverListAdapter adapter = new UniverListAdapter(new ArrayList<>());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        viewModel = ViewModelProviders.of(this).get(ListViewModel.class);
        viewModel.refresh();
        countriesList.setLayoutManager(new LinearLayoutManager(this));
        countriesList.setAdapter(adapter);

        refreshLayout.setOnRefreshListener(() -> {
            viewModel.refresh();
            refreshLayout.setRefreshing(false);
        });


        adapter.setOnItemClickListener(univerModel -> {

            Intent intent = new Intent(MainActivity.this, NewDetails.class);
            intent.putExtra("name", univerModel.getCountryName());
            intent.putExtra("description", univerModel.getCapital());
            intent.putExtra("image", univerModel.getImage());
            startActivity(intent);

        });
        observerViewModel();
    }

    private void observerViewModel() {
        viewModel.countries.observe(this, countryModels -> {
            if (countryModels != null) {
                countriesList.setVisibility(View.VISIBLE);
                adapter.updateCountries(countryModels);
            }
        });

        viewModel.countryLoadError.observe(this, isError -> {
            if (isError != null) {
                imgView.setVisibility(isError ? View.VISIBLE : View.GONE);
                listError.setVisibility(isError ? View.VISIBLE : View.GONE);
            }
        });

        viewModel.loading.observe(this, isLoading -> {
            if (isLoading != null) {
                loadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    listError.setVisibility(View.GONE);
                    imgView.setVisibility(View.GONE);
                    countriesList.setVisibility(View.GONE);
                }
            }
        });
    }


}