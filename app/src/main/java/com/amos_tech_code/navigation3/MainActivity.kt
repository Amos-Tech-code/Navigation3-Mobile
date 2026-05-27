package com.amos_tech_code.navigation3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.amos_tech_code.navigation3.ui.navigation.NavigationRoot
import com.amos_tech_code.navigation3.ui.theme.Navigation3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Navigation3Theme {
                NavigationRoot()
            }
        }
    }
}