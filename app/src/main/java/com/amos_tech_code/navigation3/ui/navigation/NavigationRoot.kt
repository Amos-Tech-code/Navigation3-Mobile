package com.amos_tech_code.navigation3.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.amos_tech_code.navigation3.ui.screens.TodoDetailScreen
import com.amos_tech_code.navigation3.ui.screens.TodoListScreen

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val navigateState = rememberNavigationState(
        startRoute = Route.TodoList,
        topLevelRoutes = TOP_LEVEL_DESTINATIONS.keys
    )
    val navigator = remember {
        Navigator(navigateState)
    }
    Scaffold(
        bottomBar = {
            TodoNavigationBar(
                selectedKey = Route.TodoList,
                onSelectKey = {
                    navigator.navigate(it)
                }
            )
        }
    ) { innerPadding ->

        NavDisplay(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding),
            onBack = {
                navigator.goBack()
            },
            entries = navigateState.toEntries (
                entryProvider {

                    entry<Route.TodoList> {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.TodoDetail(it))
                            }
                        )
                    }

                    entry<Route.TodoDetail> {
                        TodoDetailScreen(
                            todo = it.todo
                        )
                    }

                    entry<Route.TodoFavorites> {
                        TodoListScreen(
                            onTodoClick = {
                                navigator.navigate(Route.TodoDetail(it))
                            }
                        )
                    }

                    entry<Route.Settings> {
                        Box(
                            modifier = Modifier
                                .fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Settings")
                        }
                    }

                }
            )
        )
    }
}