package com.kamolovproducts.dagger2.di;

import com.kamolovproducts.dagger2.modleunivers.UniverApi;
import com.kamolovproducts.dagger2.modleunivers.UniverService;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    public final String BASE_URL = "https://raw.githubusercontent.com/fotehkamolov96/test/main/json/";

    @Provides
    public UniverApi provideCountriesApi(){
        return  new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(UniverApi.class);
    }

    @Provides
    public UniverService provideCountriesService(){
        return UniverService.getInstance();
    }
}
