package com.example.fooddonation.ui

import android.icu.lang.UCharacter.VerticalOrientation
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class HomeView {
@Composable
    fun HomeViewApp() {
        var isScreen by remember { mutableStateOf(true) }

        if (isScreen) {
            homeview(onListView = { isScreen = false })
        } else {
            homeview(onListView = { isScreen = true })
        }
    }
    @Preview
    @Composable
    fun homeview(onListView: () -> Unit){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(state = rememberScrollState()),
              Arrangement.SpaceBetween
        ) {
            Button(onClick = onListView ) {
                Text(text = "Donate")
            }
//            Spacer(modifier = Modifier.width(6.dp))
//            Button(onClick = onUpdateClicked) {
//                Text(text = "Messages")
            }
            Spacer(modifier = Modifier.width(6.dp))
            Button(onClick = onListView) {
                Text(text = "Requests")
            }
        }
    }
