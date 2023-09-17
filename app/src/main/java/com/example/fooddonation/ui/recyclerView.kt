package com.example.fooddonation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
               RecyclerView()
            }
        }
    }
}


@Composable
fun ListItem(name: String){

    val expanded = remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (expanded.value) 15.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )



    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)){
        Column(modifier = Modifier
            .padding(15.dp)
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
                OutlinedButton(onClick = { expanded.value = !expanded.value }, colors = ButtonDefaults.buttonColors( Color.Magenta)) {
                    Text( if(expanded.value) "Show Less" else "Show More")
                }
            }

            if(expanded.value){

                Column(modifier = Modifier.padding(
                    bottom = extraPadding.coerceAtLeast(0.dp)
                )) {
                     Text(text = "My food item is listed as it will expire in 3 days, contact me if you are interested")
                }
            }
        }
    }

}

@Composable
fun RecyclerView(names: List<String> = List(1000){"$it"}){
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){

        items(items=names){
            name->
            ListItem(name = name)
        }
    }
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
//ListItem(name = "1" )
        RecyclerView()
    }
}