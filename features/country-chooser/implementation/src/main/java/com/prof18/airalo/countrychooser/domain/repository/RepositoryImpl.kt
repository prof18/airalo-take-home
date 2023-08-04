package com.prof18.airalo.countrychooser.domain.repository

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.architecture.mapIfSuccess
import com.prof18.airalo.countrychooser.data.remote.RemoteDataSource
import com.prof18.airalo.countrychooser.domain.mapper.toModel
import com.prof18.airalo.countrychooser.domain.model.Model
import org.koin.core.annotation.Factory

@Factory
internal class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
) : Repository {
    override suspend fun getData(): DataResult<List<Model>> =
        remoteDataSource.getSomething()
            .mapIfSuccess {
                it.map { dto ->
                    dto.toModel()
                }
            }
}
