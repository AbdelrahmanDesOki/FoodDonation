package com.example.fooddonation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.fooddonation.Navigation.Navigation
import com.example.fooddonation.ui.Details
import com.example.fooddonation.ui.RecyclerView
import com.example.fooddonation.ui.theme.FoodDonationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //compose view
        setContent {
            FoodDonationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {


//                  Navigation()
//                    RecyclerView()
//                    Details()
//                    Greeting("Android")

//                    AIzaSyAgLmpXRShrlIr_YgmnqtX32CtDlwL3R5Y
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.Gray,
        fontSize = 30.sp,
        modifier = modifier
    )
}

//declarative preview
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodDonationTheme {
        Greeting("Desokii")
    }
}