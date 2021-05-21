package io.folb.h_ng.ui.events.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.folb.h_ng.di.ViewModelKey
import io.folb.h_ng.ui.events.viewmodels.CreateEventViewModel

@Module
abstract class CreateEventModule {

    @Binds
    @IntoMap
    @ViewModelKey(CreateEventViewModel::class)
    abstract fun bindViewModel(viewModel: CreateEventViewModel): ViewModel

}