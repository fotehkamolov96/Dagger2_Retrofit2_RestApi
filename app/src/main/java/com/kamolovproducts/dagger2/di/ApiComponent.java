package com.kamolovproducts.dagger2.di;


import com.kamolovproducts.dagger2.modleunivers.UniverService;
import com.kamolovproducts.dagger2.viewmodel.ListViewModel;

import dagger.Component;

@Component(modules = {ApiModule.class})
public interface ApiComponent {
    void inject(UniverService service);
    void inject(ListViewModel viewModel);
}
