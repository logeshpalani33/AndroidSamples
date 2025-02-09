package com.example.taskcompletedui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskcompletedui.ui.theme.TaskCompletedUITheme

@Composable
fun BusinessCard() {
    Column(
        modifier = Modifier.background(Color(0xFFdae5db)),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.android_logo),
            modifier = Modifier
                .size(150.dp).background(Color.Black),
            alignment = Alignment.Center,
            contentDescription = null
        )
        Text(
            text = "Logesh Palani",
            modifier = Modifier,
            fontSize = 40.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Android Developer Extraordinaire",
            modifier = Modifier
                .padding(top = 15.dp),
            textAlign = TextAlign.Center,
            color = Color(0xFF44694f)
        )
        Spacer(Modifier.weight(1f))
        Column(
            modifier = Modifier
                .fillMaxWidth().padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactInfoCard(Icons.Rounded.Call, R.string.mobile_number)
            ContactInfoCard(Icons.Rounded.Share, R.string.twitter_id)
            ContactInfoCard(Icons.Rounded.Email, R.string.email_id)
        }
    }
}

@Composable
private fun ContactInfoCard(imageVector: ImageVector, id: Int) {
    Row(
//        horizontalArrangement = Arrangement.SpaceAround
    )
    {
        Icon(
            imageVector = imageVector,
            contentDescription = "Localized description",
            modifier = Modifier,
        )
        Text(
            text = stringResource(id),
            modifier = Modifier
                .size(width = 220.dp, height = 33.dp)
                .padding(start = 20.dp)
        )
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun BusinessCardPreview() {
    TaskCompletedUITheme {
        BusinessCard()
    }
}