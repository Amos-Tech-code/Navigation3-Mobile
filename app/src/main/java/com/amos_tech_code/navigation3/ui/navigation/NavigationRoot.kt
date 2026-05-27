package com.amos_tech_code.navigation3.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.savedstate.serialization.SavedStateConfiguration
import com.amos_tech_code.navigation3.ui.auth.AuthNavigation
import com.amos_tech_code.navigation3.ui.screens.TodoDetailScreen
import com.amos_tech_code.navigation3.ui.screens.TodoListScreen
import com.amos_tech_code.navigation3.ui.screens.TodoNavigation
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic

@Composable
fun NavigationRoot(
    modifier: Modifier = Modifier
) {
    val rootBackStack = rememberNavBackStack(
        Route.Auth
    )

    NavDisplay(
        modifier = modifier,
        backStack = rootBackStack,
        entryDecorators = listOf(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider{

            entry<Route.Auth> {
                AuthNavigation(
                    onLogin = {
                        rootBackStack.remove(Route.Auth)
                        rootBackStack.add(Route.Todo)
                    }
                )
            }

            entry<Route.Todo> {
                TodoNavigation()
            }
        }
    )
}