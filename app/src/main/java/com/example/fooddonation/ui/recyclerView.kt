package com.example.fooddonation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddonation.ui.ui.theme.FoodDonationTheme

class recyclerView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodDonationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}


@Composable
fun ListItem(name: String){
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){
        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()) {

            Row {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                        Text(text = "First Item")
                        Text(
                            text = name,
                            style = MaterialTheme.typography.bodyMedium
                                .copy(fontWeight = FontWeight.ExtraBold)
                        )
                }
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text(text = "Show More", color = Color.Magenta)
                }
            }
        }
    }

}

@Composable
fun RecyclerView(names: List<String> = List(1000){"$it"}){

}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    FoodDonationTheme {
//        Greeting2("Android")
ListItem(name = "1" )
    }
}