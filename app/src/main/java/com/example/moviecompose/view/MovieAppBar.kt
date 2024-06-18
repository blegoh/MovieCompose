package com.example.moviecompose.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.theme.LineColor
import com.example.moviecompose.theme.TitleColor

@Composable
fun MovieAppBar(
    currentScreen: MovieScreen
) {
    if (currentScreen != MovieScreen.Detail) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = currentScreen.title,
                color = TitleColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(vertical = 16.dp)
            )
            Divider(color = LineColor, thickness = 1.dp)

        }
    }
}