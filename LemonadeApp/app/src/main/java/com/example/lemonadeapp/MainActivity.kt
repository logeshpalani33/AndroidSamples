package com.example.lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonadeapp.ui.theme.LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadePreview()
        }
    }
}


@Composable
fun Lemonade(modifier: Modifier = Modifier) {
    Text(
        text = stringResource(R.string.lemonade),
        modifier = Modifier
            .background(Color.Yellow)
            .fillMaxWidth()
            .padding(15.dp),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        style = TextStyle(fontSize = 24.sp)
    )
    var stepValue by remember { mutableIntStateOf(1) }
    val image: Int
    val textValue: Int
    when (stepValue) {
        1 -> {
            image = R.drawable.lemon_tree
            textValue = R.string.tap_the_lemon_tree_to_select_a_lemon
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = stringResource(textValue))
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(image),
                    contentDescription = "text",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            stepValue = 2
                        }
                )
            }
        }

        2 -> {
            image = R.drawable.lemon_squeeze
            textValue = R.string.keep_tapping_the_lemon_to_squeeze_it
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = stringResource(textValue))
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(image),
                    contentDescription = "text",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            stepValue = 3
                        }
                )
            }
        }

        3 -> {
            image = R.drawable.lemon_drink
            textValue = R.string.tap_the_lemonade_to_drink_it
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = stringResource(textValue))
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(image),
                    contentDescription = "text",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            stepValue = 4
                        }
                )
            }
        }

        else -> {
            image = R.drawable.lemon_restart
            textValue = R.string.tap_the_empty_glass_to_start_again
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = stringResource(textValue))
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(image),
                    contentDescription = "text",
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            stepValue = 1
                        }
                )
            }
        }
    }
//    Column(modifier = Modifier.fillMaxSize()) {
//        Text(
//            text = stringResource(R.string.lemonade),
//            modifier = modifier
//                .background(Color.Yellow)
//                .fillMaxWidth()
//                .padding(15.dp),
//            textAlign = TextAlign.Center,
//            fontWeight = FontWeight.Bold,
//            style = TextStyle(fontSize = 24.sp)
//        )
//        Column(
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center,
//            modifier = Modifier.fillMaxSize()
//        ) {
//            Image(
//                painter = painterResource(image),
//                contentDescription = null,
//                modifier = Modifier.clickable {
//                    if (stepValue == 4) {
//                        stepValue = 1
//                    } else {
//                        stepValue += 1
//                    }
//                }
//            )
//            Text(
//                text = stringResource(text),
//                modifier = modifier.padding(16.dp)
//            )
//        }
//    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeAppTheme {
        Lemonade()
    }
}