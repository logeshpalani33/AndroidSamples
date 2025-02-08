package com.example.taskcompletedui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompletedui.ui.theme.TaskCompletedUITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskCompletedUITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TaskCompleted(
                        message = stringResource(R.string.nice_work),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeInfoCard(
    backgroundColor: Color,
    title: Int,
    description: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(title),
            modifier = Modifier.padding(16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(description),
            textAlign = TextAlign.Justify,
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun QuadLayoutPreview() {

    TaskCompletedUITheme {
    val modifier: Modifier = Modifier
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Row(modifier = modifier.weight(1f)) {
            ComposeInfoCard(
                Color(0xFFEADDFF),
                R.string.text_composable, R.string.text_composable_description,
                modifier = modifier.weight(1f)
            )
            ComposeInfoCard(
                Color(0xFFD0BCFF),
                R.string.image_composable, R.string.image_composable_decription,
                modifier = modifier.weight(1f)
            )
        }
        Row(modifier = modifier.weight(1f)) {
            ComposeInfoCard(
                Color(0xFFB69DF8),
                R.string.row_composable, R.string.row_composable_description,
                modifier = modifier.weight(1f)
            )
            ComposeInfoCard(
                Color(0xFFF6EDFF),
                R.string.column_composable,
                R.string.column_composable_description,
                modifier = modifier.weight(1f)
            )
        }
    }
    }
}

@Composable
fun TaskCompleted(message: String, modifier: Modifier = Modifier) {
    val taskCompleted = painterResource(R.drawable.ic_task_completed)
    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
        content = {
            Image(
                painter = taskCompleted,
                modifier = modifier,
                contentDescription = null
            )
            Text(
                text = stringResource(R.string.all_tasks_completed),
                modifier = modifier.padding(top = 24.dp, bottom = 8.dp),
                fontWeight = FontWeight.Bold
            )
            Text(
                text = message,
                modifier = modifier,
                fontSize = 16.sp
            )
        })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    TaskCompletedUITheme {
        TaskCompleted("Nice Work")
    }
}