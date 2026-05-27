package com.amos_tech_code.navigation3.ui.viewmodels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TodoListViewModel: ViewModel() {

    private val _todos = MutableStateFlow(
        (1..100).map { "Todo $it" }
    )
    val todos = _todos.asStateFlow()
}