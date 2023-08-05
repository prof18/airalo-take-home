package com.prof18.airalo.countrypackages.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.error.LocalizedErrorMessage
import com.prof18.airalo.core.error.NetworkError
import com.prof18.airalo.core.error.getErrorLocalizedMessage
import com.prof18.airalo.core.utils.ResourceProvider
import com.prof18.airalo.countrypackages.R
import com.prof18.airalo.countrypackages.domain.model.CountryId
import com.prof18.airalo.countrypackages.domain.model.CountryPackages
import com.prof18.airalo.countrypackages.domain.usecases.CountryPackagesUseCase
import com.prof18.airalo.countrypackages.presentation.state.PackagesState
import com.prof18.airalo.countrypackages.presentation.state.PackagesState.Content.PackageItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel
import timber.log.Timber
import com.prof18.airalo.core.R as CoreR

@KoinViewModel
internal class CountryPackagesViewModel(
    private val countryPackagesUseCase: CountryPackagesUseCase,
    private val resourceProvider: ResourceProvider,
) : ViewModel() {

    private val countryPackagesMutableState = MutableStateFlow<PackagesState>(PackagesState.Loading)
    val countryPackagesState: StateFlow<PackagesState> = countryPackagesMutableState.asStateFlow()

    fun fetchPackages(countryId: CountryId) {
        countryPackagesMutableState.update {
            PackagesState.Loading
        }
        viewModelScope.launch {
            when (val result = countryPackagesUseCase.getCountryPackages(countryId)) {
                is DataResult.Success -> {
                    val countryPackages = result.data
                    if (countryPackages.packages.isEmpty()) {
                        Timber.w("The country packages list is empty")
                        emitEmptyPackages(countryPackages, countryId)
                        return@launch
                    }
                    emitData(countryPackages)
                }

                is DataResult.Error -> {
                    Timber.e(result.throwable, "Error while getting the countries list")
                    val localizedMessage = result.throwable.generateErrorLocalizedMessage()
                    emitError(
                        localizedMessage = localizedMessage,
                        retryAction = {
                            fetchPackages(countryId)
                        },
                    )
                }
            }
        }
    }

    private fun emitEmptyPackages(countryPackages: CountryPackages, countryId: CountryId) {
        countryPackagesMutableState.update {
            PackagesState.Empty(
                headerTitle = countryPackages.countryName,
                errorMessage = resourceProvider.getString(CoreR.string.no_packages),
                retryButtonText = resourceProvider.getString(CoreR.string.retry_button),
                onRetryClick = {
                    fetchPackages(countryId)
                },
            )
        }
    }

    private fun emitData(packages: CountryPackages) {
        val content = PackagesState.Content(
            headerTitle = packages.countryName,
            packageItems = packages.packages.map { countryPackage ->
                PackageItem(
                    title = countryPackage.networkOperator.name,
                    subtitle = packages.countryName,
                    imageUrl = countryPackage.networkOperator.imageUrl,
                    cardGradient = countryPackage.colorGradient,
                    features = listOf(
                        PackageItem.PackageFeature(
                            iconRes = R.drawable.ic_data,
                            title = resourceProvider.getString(CoreR.string.package_data_title),
                            amountLabel = countryPackage.networkDataAmountLabel,
                        ),
                        PackageItem.PackageFeature(
                            iconRes = R.drawable.ic_validity,
                            title = resourceProvider.getString(CoreR.string.package_validity_title),
                            amountLabel = countryPackage.validityLabel,
                        ),
                    ),
                    // TODO: mention the price formatter
                    buttonText = resourceProvider.getString(
                        CoreR.string.package_buy_button_label,
                        countryPackage.price,
                    ),
                    onButtonClick = {
                        // Navigate to package checkout
                    },
                )
            },
        )

        countryPackagesMutableState.update {
            content
        }
    }

    private fun emitError(
        localizedMessage: LocalizedErrorMessage,
        retryAction: () -> Unit,
    ) {
        countryPackagesMutableState.update {
            PackagesState.Error(
                content = resourceProvider.getString(
                    localizedMessage.messageStringResID,
                ),
                retryButtonText = resourceProvider.getString(
                    localizedMessage.buttonTextResId,
                ),
                onRetryClick = {
                    retryAction()
                },
            )
        }
    }

    private fun Throwable.generateErrorLocalizedMessage(): LocalizedErrorMessage =
        when (this) {
            is NetworkError.ApiError -> {
                // Do here some custom mapping based on the error
                LocalizedErrorMessage(
                    messageStringResID = CoreR.string.unknown_network_error_message,
                    buttonTextResId = CoreR.string.retry_button,
                )
            }

            is NetworkError -> {
                this.getErrorLocalizedMessage()
            }

            else -> {
                LocalizedErrorMessage(
                    messageStringResID = CoreR.string.unknown_network_error_message,
                    buttonTextResId = CoreR.string.retry_button,
                )
            }
        }
}
