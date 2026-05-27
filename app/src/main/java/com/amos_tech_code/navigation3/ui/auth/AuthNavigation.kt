package com.amos_tech_code.navigation3.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.amos_tech_code.navigation3.ui.navigation.Route

@Composable
fun AuthNavigation(
    modifier: Modifier = Modifier,
    onLogin: () -> Unit,
) {

    val authBackStack = rememberNavBackStack(Route.Auth.Login)
    val sharedAuthViewModel = viewModel { SharedAuthViewModel() }

    NavDisplay(
        backStack = authBackStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Route.Auth.Login> {
                LoginScreen(
                    viewModel = viewModel { LoginViewModel() },
                    sharedAuthViewModel = sharedAuthViewModel,
                    onLogin = onLogin,
                    onRegisterClick = {
                        authBackStack.add(Route.Auth.Register)
                    }
                )
            }

            entry<Route.Auth.Register> {
                RegisterScreen(
                    viewModel = viewModel { RegisterViewModel() },
                    sharedAuthViewModel = sharedAuthViewModel,
                )
            }
        }
    )
}