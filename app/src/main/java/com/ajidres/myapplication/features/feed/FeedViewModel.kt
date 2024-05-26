package com.ajidres.myapplication.features.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ajidres.myapplication.data.api.model.ResultEndpoints
import com.ajidres.myapplication.domain.model.ChildrenFeedDataEntity
import com.ajidres.myapplication.domain.use_case.FeedUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(private val useCase: FeedUseCase) : ViewModel() {

    private var _feedData = MutableLiveData<ResultEndpoints<List<ChildrenFeedDataEntity>>>()
    val feedData: LiveData<ResultEndpoints<List<ChildrenFeedDataEntity>>> get() = _feedData

    fun fetchFeed(page: Int) {
        viewModelScope.launch {
            useCase.invokeFeed(page).collect {
                _feedData.value = it
            }
        }
    }

}