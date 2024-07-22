package com.example.feature.bootrecordslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.CreateBootRecordUseCase
import com.example.core.domain.GetBootRecordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

@HiltViewModel
class BootRecordsViewModel @Inject constructor(
    private val getBootRecordsUseCase: GetBootRecordsUseCase,
    private val createBootRecordsUseCase: CreateBootRecordUseCase,
): ViewModel() {

    private val _items = MutableLiveData<List<Adapter.Item>>()
    val items: LiveData<List<Adapter.Item>> get() = _items


    init {
        viewModelScope.launch {
            getBootRecordsUseCase().map {
                val map = it.groupBy { it.timestamp.toLocalDate() }
                map.map { (date, records) ->
                    Adapter.Item(
                        id = date.toString(),
                        date = date,
                        count = records.size.toLong()
                    )
                }
            }.collectLatest {
                _items.postValue(it)
            }
        }
    }

    fun add() {
        viewModelScope.launch {
            createBootRecordsUseCase(LocalDateTime.now())
        }
    }

}