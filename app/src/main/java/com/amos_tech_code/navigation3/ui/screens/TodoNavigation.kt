package com.amos_tech_code.navigation3.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.amos_tech_code.navigation3.ui.navigation.Route

@Composable
fun TodoNavigation(
    modifier: Modifier = Modifier,
) {

    val todoBackStack = rememberNavBackStack(Route.Todo.TodoList)

    NavDisplay(
        backStack = todoBackStack,
        modifier = modifier,
        entryProvider = entryProvider {
            entry<Route.Todo.TodoList> {
                TodoListScreen(
                    onTodoClick = {
                        todoBackStack.add(Route.Todo.ToDoDetail(it))
                    }
                )
            }

            entry<Route.Todo.ToDoDetail> {
                TodoDetailScreen(
                    todo = it.todo
                )
            }
        }
    )
}