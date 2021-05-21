package io.folb.h_ng.ui.events.di

import dagger.Subcomponent
import io.folb.h_ng.ui.events.CreateEventFragment

@Subcomponent(modules = [CreateEventModule::class])
interface CreateEventComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CreateEventComponent
    }

    fun inject(fragment: CreateEventFragment)
}