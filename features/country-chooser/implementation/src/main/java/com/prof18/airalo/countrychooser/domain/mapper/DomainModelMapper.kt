package com.prof18.airalo.countrychooser.domain.mapper

import com.prof18.airalo.countrychooser.data.remote.dto.DTO
import com.prof18.airalo.countrychooser.domain.model.Model

internal fun DTO.toModel(): Model {
    return Model(
        foo = this.foo,
    )
}
