package com.ajidres.myapplication.features.start

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.AccessEntity
import com.ajidres.myapplication.domain.use_case.AccessUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StartViewModel @Inject constructor(private val useCase: AccessUseCase) : ViewModel() {

    private var _accessData = MutableLiveData<ResultEndpoints<AccessEntity>>()
    val accessData: LiveData<ResultEndpoints<AccessEntity>> get() = _accessData

    fun grantAccess(code: String) {
        viewModelScope.launch {
            useCase.invokeAccess(code).collect {
                _accessData.value = it
            }
        }
    }

}