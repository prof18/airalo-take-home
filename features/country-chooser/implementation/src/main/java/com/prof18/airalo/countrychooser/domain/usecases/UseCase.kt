package com.prof18.airalo.countrychooser.domain.usecases

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.coroutines.DispatcherProvider
import com.prof18.airalo.countrychooser.domain.model.Model
import com.prof18.airalo.countrychooser.domain.repository.Repository
import kotlinx.coroutines.withContext
import org.koin.core.annotation.Factory

@Factory
internal class UseCase(
    private val homeRepository: Repository,
    private val dispatcherProvider: DispatcherProvider,
) {
    suspend fun getData(): DataResult<List<Model>> =
        withContext(dispatcherProvider.io()) {
            return@withContext homeRepository.getData()
        }
}
