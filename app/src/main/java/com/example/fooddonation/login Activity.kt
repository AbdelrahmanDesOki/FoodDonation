package com.example.fooddonation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
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

@Preview
@Composable
fun LoginPage(onSignUpClick: () -> Unit) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Login", style = MaterialTheme.typography.h4, color = Color.White)

        // ... (rest of your login components)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                email = it
                isButtonEnabled = it.isNotEmpty() && password.isNotEmpty()
            },
            label = { Text("Email", color = Color.White) },
            keyboardOptions = KeyboardOptions(
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
                isButtonEnabled = it.isNotEmpty() && email.isNotEmpty()
            },
            label = { Text("Password", color = Color.White) },
            keyboardOptions = KeyboardOptions(
                imeAction = androidx.compose.ui.text.input.ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    focusManager.clearFocus()
                }
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

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
    var name_sign_up by remember { mutableStateOf("") }
    var email_sign_up by remember { mutableStateOf("") }
    var password_sign_up by remember { mutableStateOf("") }
    val focusManager_up = LocalFocusManager.current


    fun insertUSer (){


    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Sign Up", style = MaterialTheme.typography.h4, color = Color.White)

        // ... (rest of your sign-up components)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name_sign_up,
            onValueChange = {
                name_sign_up = it
                email_sign_up.isNotEmpty() && password_sign_up.isNotEmpty()
            },
            label = { Text("Name", color = Color.White) },
            keyboardOptions = KeyboardOptions(
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager_up.clearFocus()
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = email_sign_up,
            onValueChange = {
                email_sign_up = it
                name_sign_up.isNotEmpty() && password_sign_up.isNotEmpty()
            },
            label = { Text("Email", color = Color.White) },
            keyboardOptions = KeyboardOptions(
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager_up.clearFocus()
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password_sign_up,
            onValueChange = {
                password_sign_up = it
                email_sign_up.isNotEmpty() && name_sign_up.isNotEmpty()
            },
            label = { Text("Password", color = Color.White) },
            keyboardOptions = KeyboardOptions(
                imeAction = androidx.compose.ui.text.input.ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager_up.clearFocus()
                }
            ),
            modifier = Modifier.fillMaxWidth()
        )

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

