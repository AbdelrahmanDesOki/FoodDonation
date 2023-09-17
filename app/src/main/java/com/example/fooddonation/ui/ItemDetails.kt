package com.example.fooddonation.ui

import android.os.Bundle
import android.telecom.Call.Details
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddonation.ui.ui.theme.FoodDonationTheme

class ItemDetails : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDonationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting3("Android")
                }
            }
        }
    }
}
@Composable
fun Details(name: String){
    var Title by remember { mutableStateOf("") }
    var details by remember { mutableStateOf("") }
    val focusManager_up = LocalFocusManager.current

    Surface (
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
             Row {
                 Column(modifier = Modifier.weight(4f)) {
                     Button(onClick = { /*TODO*/ },
                         modifier = Modifier
                             .padding(10.dp)
                             .fillMaxWidth()
                             .background(Color.Magenta)

                     ) {

                          Text(text = "Add photo")
                     }

                     Spacer(modifier = Modifier.height(16.dp))

                     OutlinedTextField(
                         value = Title,
                         onValueChange = {
                             Title = it
                         },
                         label = { androidx.compose.material.Text("Title", color = Color.White) },
                         keyboardOptions = KeyboardOptions(
                             imeAction = ImeAction.Next
                         ),
                         keyboardActions = KeyboardActions(
                             onNext = {
                                 focusManager_up.clearFocus()
                             }
                         ),
                         modifier = Modifier.fillMaxWidth()
                     )
                 }
             }
        }


    }
}



@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    FoodDonationTheme {
//        Greeting3("Android")
        Details("1")
    }
}