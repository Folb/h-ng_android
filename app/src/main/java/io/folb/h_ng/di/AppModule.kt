package io.folb.h_ng.di

import dagger.Module
import dagger.Provides
import io.folb.h_ng.io.repos.event.EventDataSource
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton
import io.folb.h_ng.io.repos.event.EventRemoteDataSource
import io.folb.h_ng.io.repos.event.EventLocalDataSource

@Module
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EventRemoteDataSource

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class EventLocalDataSource

    @Singleton
    @EventRemoteDataSource
    @Provides
    fun provideEventRemoteDataSource(): EventDataSource {
        return EventRemoteDataSource
    }

    @Singleton
    @EventLocalDataSource
    @Provides
    fun provideEventLocalDataSource(): EventDataSource {
        return EventLocalDataSource
    }

    @Singleton
    @Provides
    fun provideIoDispatchers() = Dispatchers.IO
}