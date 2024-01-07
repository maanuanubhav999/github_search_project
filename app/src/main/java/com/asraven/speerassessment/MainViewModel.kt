package com.asraven.speerassessment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asraven.speerAssessment.data.remote.model.GithubSearchResult
import com.asraven.speerAssessment.domain.repository.SearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class MainUIState(
    val loading: Boolean = false,
    val data: GithubSearchResult? = null
)

@HiltViewModel
class MainViewModel @Inject constructor(
    val searchRepository: SearchRepository
): ViewModel() {

    //create ui state
    private val _mainUi = MutableStateFlow(
        MainUIState(
            loading = true
        )
    )


    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
        onError(exception)
    }

    private fun onError(throwable: Throwable) {
        Log.e("Error", throwable.toString())
    }


    val mainUi = _mainUi.asStateFlow()



    fun searchUser(userName: String){
        viewModelScope.launch(coroutineExceptionHandler) {
            val data = searchRepository.getSearchResults(userName)
            _mainUi.update {
                it.copy(
                    data = data
                )
            }

        }
    }
}