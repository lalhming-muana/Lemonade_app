package com.example.lemonade_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade_app.ui.theme.Lemonade_appTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lemonade_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf(1) }
    val imageResource = when(result){
        1-> R.drawable.lemon_tree
        2-> R.drawable.lemon_squeeze
        3-> R.drawable.lemon_drink
        else-> R.drawable.lemon_restart
    }

    val textResource = when(result){
        1-> R.string.text1
        2-> R.string.text2
        3-> R.string.text3
        else-> R.string.text4
    }


    Column(Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id =imageResource),
            contentDescription = null,
            modifier = Modifier.clickable{if (result < 4) {

                // declare a variable and generate a random number
                // if the number <5 let is stay in 2 otherwise decrement
                if (result ==2){
                    val randomValue = Random.nextInt(1, 9) // Random value between 1 and 8
                    if (randomValue < 5) {
                        result = 2
                    }
                    else result=2-1
                    }
                // Here we increment the result
                result += 1

                // this part will bring the image back to the beginning
            } else {
                result = 1
            }}
        )
        Text(
            text = stringResource(id = textResource),
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lemonade_appTheme {
        Greeting()
    }
}