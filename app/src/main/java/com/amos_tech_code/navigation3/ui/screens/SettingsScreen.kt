package com.amos_tech_code.navigation3.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.amos_tech_code.navigation3.ui.navigation.ResultStore

@Composable
fun SettingsScreen(
    resultStore: ResultStore,
    onChangeSettingClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val setting = resultStore.getResult<String>("main_setting")
    Box(
        modifier = modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onChangeSettingClick
        ) {
            Text("Current setting: ${setting ?: "Default"}")
        }
    }
}