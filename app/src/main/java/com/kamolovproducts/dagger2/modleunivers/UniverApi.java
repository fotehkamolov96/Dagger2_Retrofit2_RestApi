package com.kamolovproducts.dagger2.modleunivers;

import com.kamolovproducts.dagger2.modleunivers.UniverModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UniverApi {
    @GET("jsunivers.json")
    Single<List<UniverModel>> getCountries();
    //single emits one value and finishes. In this case it emits the list of countries.
}
