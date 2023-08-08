package com.geektech.testdsl.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geektech.testdsl.data.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> Flow<Resource<T>>.subscribe(
        error: (message: String?) -> Unit,
        loading: () -> Unit,
        success: (data: T?) -> Unit
    ) {
        viewModelScope.launch {
            this@subscribe.collect {
                when (it) {
                    is Resource.Loading -> {
                        loading()
                    }

                    is Resource.Success -> {
                        success(it.data)
                    }

                    is Resource.Error -> {
                        error(it.message)
                    }
                }
            }
        }
    }

}