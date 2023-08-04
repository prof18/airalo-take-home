package com.prof18.airalo.countrychooser.fakes

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.data.remote.RemoteDataSource
import com.prof18.airalo.countrychooser.data.remote.dto.DTO

internal class FakeRemoteDataSource : RemoteDataSource {
    override suspend fun getSomething(): DataResult<List<DTO>> {
        TODO("Not yet implemented")
    }
}
