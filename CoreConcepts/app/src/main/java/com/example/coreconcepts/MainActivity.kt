package com.example.coreconcepts

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coreconcepts.ui.theme.CoreConceptsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CoreConceptsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        var person = Person("Logesh Palani", 26)
        // person.name = "Test"
        val animal = Animal("Tiger", 13)
        animal.age = 23
//        animal = Animal("Test", 9)
        nonInlineFunction { println("Before action") }
    }
    private inline fun nonInlineFunction(action: () -> Unit) {
        println("Before action")
        action()
        println("After action")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CoreConceptsTheme {
        Greeting("Android")
    }
}
class Person(val name: String, val age: Int)
class Animal(val name: String, var age: Int)