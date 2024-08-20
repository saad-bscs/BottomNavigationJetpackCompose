package com.example.bottomnavigationjetpackcompose.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bottomnavigationjetpackcompose.R

@Composable
fun HomePage(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF1976D2)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            modifier = Modifier.size(160.dp),
            painter = painterResource(id = R.drawable.home_img),
            contentDescription = "Icon",
            tint = Color.Unspecified
        )

        Spacer(modifier = Modifier.size(30.dp))

        Text(
            text = "Home Page",
            fontSize = 40.sp,
            fontWeight = FontWeight.SemiBold,
            color = androidx.compose.ui.graphics.Color.White
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewHomePage() {
    HomePage(modifier = Modifier)
}