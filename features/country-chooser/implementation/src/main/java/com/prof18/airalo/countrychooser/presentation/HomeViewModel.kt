package com.prof18.airalo.countrychooser.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prof18.airalo.core.architecture.DataResult
import com.prof18.airalo.core.error.ErrorLocalizedMessage
import com.prof18.airalo.core.error.NetworkError
import com.prof18.airalo.core.utils.ResourceProvider
import com.prof18.airalo.countrychooser.domain.usecases.UseCase
import com.prof18.airalo.countrychooser.presentation.state.HomeState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
internal class HomeViewModel(
    private val useCase: UseCase,
    private val resourceProvider: ResourceProvider,
) : ViewModel() {

    private val homeMutableState = MutableStateFlow<HomeState>(HomeState.Loading)
    val homeState: StateFlow<HomeState> = homeMutableState.asStateFlow()

    fun getData() {
        viewModelScope.launch {
            when (val result = useCase.getData()) {
                is DataResult.Success -> {
                    homeMutableState.update {
                        HomeState.Content(result.data.toString())
                    }
                }

                is DataResult.Error -> {
                    val localizedMessage = result.throwable.getErrorLocalizedMessage()
                    homeMutableState.update {
                        HomeState.Error(
                            content = resourceProvider.getString(
                                localizedMessage.messageStringResID,
                            ),
                            buttonText = resourceProvider.getString(
                                localizedMessage.buttonTextResId,
                            ),
                            onRetryClick = {
                                // TODO
                            },
                        )
                    }
                }
            }
        }
    }

    private fun Throwable.getErrorLocalizedMessage(): ErrorLocalizedMessage =
        when (this) {
            is NetworkError.ApiError -> {
                // Do here some custom mapping based on the error
                ErrorLocalizedMessage(
                    messageStringResID = com.prof18.airalo.core.R.string.unknown_network_error,
                    buttonTextResId = com.prof18.airalo.core.R.string.retry_button,
                )
            }

            is NetworkError -> {
                getErrorLocalizedMessage()
            }

            else -> {
                ErrorLocalizedMessage(
                    messageStringResID = com.prof18.airalo.core.R.string.unknown_network_error,
                    buttonTextResId = com.prof18.airalo.core.R.string.retry_button,
                )
            }
        }
}
