package com.prof18.airalo.countrychooser.data.remote

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.data.remote.dto.DTO

internal interface RemoteDataSource {
    suspend fun getSomething(): DataResult<List<DTO>>
}
