package com.example.fooddonation.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fooddonation.ui.HomeView
import android.content.Context
import android.content.SharedPreferences

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.loginScreen.route ){
        composable(route= Screen.loginScreen.route){
            loginScreen(navController = navController)
        }
        
        composable(route=Screen.singupScreen.route){
            SignupScreen(navController = navController)
        }
    }
}

@Composable
fun SignupScreen(navController: NavController) {
    var name_sign_up by remember { mutableStateOf("") }
    var email_sign_up by remember { mutableStateOf("") }
    var password_sign_up by remember { mutableStateOf("") }
    var password_confirm by remember { mutableStateOf(" ") }
    val focusManager_up = LocalFocusManager.current





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

        OutlinedTextField(
            value = password_confirm,
            onValueChange = {
                password_confirm = it
                email_sign_up.isNotEmpty() && name_sign_up.isNotEmpty() && password_sign_up.isNotEmpty()
            },
            label = { Text("Confirm Password", color = Color.White) },
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


        Button(
            onClick = { /* Handle sign-up here */ },
            modifier = Modifier.fillMaxWidth(),
            enabled = true // Enable it based on your logic
        ) {
            Text("Sign Up")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = {
                      navController.navigate(Screen.loginScreen.route)
                      }, // Switch to login screen
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Login", color = Color.White)
        }
    }
}  
@Composable
fun loginScreen(navController: NavController){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    val focusManager = LocalFocusManager.current
    val x= HomeView()
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
                imeAction = ImeAction.Next
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
                imeAction = ImeAction.Done
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
            onClick = { /* Handle login here */

            },
            modifier = Modifier.fillMaxWidth(),
            enabled = true // Enable it based on your logic
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(
            onClick = { navController.navigate(Screen.singupScreen.route) }, // Switch to sign-up screen
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Sign Up", color = Color.White)
        }
    }
}