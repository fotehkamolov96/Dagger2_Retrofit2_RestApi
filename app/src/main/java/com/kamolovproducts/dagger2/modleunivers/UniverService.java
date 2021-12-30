package com.kamolovproducts.dagger2.modleunivers;


import com.kamolovproducts.dagger2.di.DaggerApiComponent;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class UniverService {

    private static UniverService instance;

    @Inject
    public UniverApi api;
    
    private UniverService(){
        DaggerApiComponent.create().inject(this);
    }

    public static UniverService getInstance(){
        if(instance==null){
            instance = new UniverService();
        }
        return instance;
    }

    public Single<List<UniverModel>> getCountries(){
        return  api.getCountries();
    }
}
