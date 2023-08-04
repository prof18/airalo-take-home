package com.prof18.airalo.countrychooser.domain.repository

import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.countrychooser.domain.model.Model

internal interface Repository {
    suspend fun getData(): DataResult<List<Model>>
}
