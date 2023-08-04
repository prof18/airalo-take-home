package com.prof18.airalo.countrychooser.data.remote

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.error.mapToNetworkError
import com.prof18.airalo.countrychooser.data.remote.dto.DTO
import org.koin.core.annotation.Factory
import timber.log.Timber

@Factory
internal class RemoteDataSourceImpl(
    private val apiService: ApiService,
) : RemoteDataSource {

    // Suppress because a generic mapping is done
    @Suppress("TooGenericExceptionCaught")
    override suspend fun getSomething(): DataResult<List<DTO>> {
        return try {
            DataResult.Success(apiService.getSomething())
        } catch (throwable: Throwable) {
            Timber.e(throwable, "Error during getting vehicles")
            DataResult.Error(throwable.mapToNetworkError())
        }
    }
}
