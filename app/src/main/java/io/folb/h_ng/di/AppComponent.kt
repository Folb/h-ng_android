package io.folb.h_ng.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import io.folb.h_ng.ui.events.di.CreateEventComponent
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AppModuleBinds::class,
        ViewModelBuilderModule::class,
        SubcomponentsModule::class
    ]
)
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    fun createEventComponent(): CreateEventComponent.Factory

}

@Module(subcomponents = [CreateEventComponent::class])
object SubcomponentsModule
