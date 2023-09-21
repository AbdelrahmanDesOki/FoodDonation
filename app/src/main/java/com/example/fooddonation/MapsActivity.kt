package com.example.fooddonation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fooddonation.ui.CheckForPermission
import com.example.fooddonation.ui.LocationPermissionScreen
import com.example.fooddonation.ui.MapScreen
import com.example.fooddonation.ui.theme.FoodDonationTheme
import com.example.fooddonation.ui.theme.GoogleMapsTheme

class MapsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDonationTheme {
                // A surface container using the 'background' color from the theme
                GoogleMapsTheme {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        var hasLocationPermission by remember {
                            mutableStateOf(CheckForPermission(this))
                        }

                        if (hasLocationPermission) {
                            MapScreen(this)
                        } else {
                            LocationPermissionScreen {
                                hasLocationPermission = true
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting5(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview5() {
    FoodDonationTheme {
        Greeting5("Android")
    }
}