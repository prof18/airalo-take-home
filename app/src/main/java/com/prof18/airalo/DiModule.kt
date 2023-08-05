package com.prof18.airalo

import com.prof18.airalo.countrypackages.CountryPackagesModule
import com.prof18.airalo.core.di.CoreModule
import com.prof18.airalo.countrychooser.CountriesModule
import org.koin.dsl.module
import org.koin.ksp.generated.module

val airaloAppModule = module {
    includes(
        CoreModule().module,
        CountriesModule().module,
        CountryPackagesModule().module,
    )
}
