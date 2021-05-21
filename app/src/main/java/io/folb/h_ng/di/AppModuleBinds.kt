package io.folb.h_ng.di

import dagger.Binds
import dagger.Module
import io.folb.h_ng.io.repos.DefaultEventRepository
import io.folb.h_ng.io.repos.event.EventRepository
import javax.inject.Singleton

@Module
abstract class AppModuleBinds {

    @Singleton
    @Binds
    abstract fun bindRepository(repo: DefaultEventRepository): EventRepository
}