//package com.example.fooddonation
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.material3.Button
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.Text
//import androidx.compose.material3.TextButton
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.text.input.PasswordVisualTransformation
//import androidx.compose.ui.unit.dp
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun LoginPage(onSignUpClick: () -> Unit) {
//    var email by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    var isLoginEnabled by remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Green) // Set background color to green
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Login", style = MaterialTheme.typography.bodyMedium, color = Color.White) // Set text color to white
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Email", color = Color.White) }, // Set label color to white
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        OutlinedTextField(
//            value = password,
//            onValueChange = { password = it },
//            label = { Text("Password", color = Color.White) }, // Set label color to white
//            visualTransformation = PasswordVisualTransformation(),
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = { /* Handle login here */ },
//            modifier = Modifier.fillMaxWidth(),
//            enabled = isLoginEnabled
//        ) {
//            Text("Login")
//        }
//
//        Spacer(modifier = Modifier.height(8.dp))
//
//        TextButton(
//            onClick = a // Navigate to sign-up page
//            modifier = Modifier.align(Alignment.End)
//        ) {
//            Text("Sign Up", color = Color.White) // Set text color to white
//        }
//    }
//
//    // Enable the login button only if both email and password are non-empty
//    isLoginEnabled = email.isNotBlank() && password.isNotBlank()
//}
//
//@Composable
//fun SignUpPage() {
//    // Implement your sign-up page UI here
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Green)
//            .padding(16.dp),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Sign Up", style = MaterialTheme.typography.bodyMedium, color = Color.White)
//        // Add sign-up form components
//    }
//}
