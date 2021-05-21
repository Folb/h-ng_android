package io.folb.h_ng.io.repos

import io.folb.h_ng.di.AppModule.EventRemoteDataSource
import io.folb.h_ng.di.AppModule.EventLocalDataSource
import io.folb.h_ng.io.repos.event.EventDataSource
import io.folb.h_ng.io.repos.event.EventRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class DefaultEventRepository @Inject constructor(
    @EventRemoteDataSource private val remoteDataSource: EventDataSource,
    @EventLocalDataSource private val localDataSource: EventDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : EventRepository {

}

