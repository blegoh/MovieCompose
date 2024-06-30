package com.example.moviecompose.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviecompose.theme.MovieComposeTheme

@Composable
fun RecentSearch(keyword: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "Search"
            )
            Text(text = keyword)
        }
        Icon(
            imageVector = Icons.Filled.Clear,
            contentDescription = "clear"
        )
    }
}

@Preview()
@Composable
fun PreviewRecentSearch() {
    MovieComposeTheme(darkTheme = false, dynamicColor = false) {
        RecentSearch("Marvel")
    }
}