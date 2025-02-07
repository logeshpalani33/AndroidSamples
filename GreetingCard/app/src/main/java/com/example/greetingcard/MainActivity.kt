package com.example.greetingcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.greetingcard.ui.theme.GreetingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        from = "Logesh",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, from: String) {
    Surface(color = Color.Cyan) {
        val image = painterResource(R.drawable.background)
        Box (
//            verticalArrangement = Arrangement.Center,
            modifier = modifier,
            content = {
                Image(
                    modifier = modifier.fillMaxSize(),
                    painter = image,
                    contentDescription = "Location Pin",
                    contentScale = ContentScale.Crop,
                    alpha = 0.5f
                )
                GreetingText(name, modifier, from)
            }
        )
    }
}

@Composable
fun GreetingText(name: String, modifier: Modifier, from: String){
Column (modifier = modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center) {
    Text(
    text = name,
    fontSize = 100.sp,
    lineHeight = 116.sp,
    modifier = modifier
        .padding(top = 100.dp)
        .background(Color.Green),
    textAlign = TextAlign.Center)
    Text(
        text = from,
        fontSize = 30.sp,
        lineHeight = 116.sp,
        modifier = modifier.align(alignment = Alignment.CenterHorizontally),
        textAlign = TextAlign.Right) }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    GreetingCardTheme {
        Greeting(stringResource(R.string.happy_birthday_text), from = stringResource(R.string.signature_text))
    }
}