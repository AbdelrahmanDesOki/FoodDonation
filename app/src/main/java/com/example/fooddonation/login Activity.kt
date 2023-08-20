package com.example.fooddonation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun App() {
    var isLoginScreen by remember { mutableStateOf(true) }

    if (isLoginScreen) {
        LoginPage(onSignUpClick = { isLoginScreen = false })
    } else {
        SignUpPage(onLoginClick = { isLoginScreen = true })
    }
}

@Composable
fun LoginPage(onSignUpClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.h4, color = Color.White)

        // ... (rest of your login components)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle login here */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = true // Enable it based on your logic
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = onSignUpClick, // Switch to sign-up screen
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Sign Up", color = Color.White)
        }
    }
}

@Composable
fun SignUpPage(onLoginClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign Up", style = MaterialTheme.typography.h4, color = Color.White)

        // ... (rest of your sign-up components)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Handle sign-up here */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = true // Enable it based on your logic
        ) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = onLoginClick, // Switch to login screen
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Login", color = Color.White)
        }
    }
}

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(primary = Color.Green),
        content = content
    )
}

