package com.example.moviecompose.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.component.RecentSearch

@Composable
fun SearchPage() {
    Column(Modifier.fillMaxWidth()) {
        TextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search, contentDescription = "clear"
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.Clear, contentDescription = "clear"
                )
            },
            shape = CircleShape
        )
        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            text = "Recent Searches",
            color = Gray3,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 16.dp)
        )

        Spacer(modifier = Modifier.padding(top = 8.dp))
        RecentSearch(keyword = "Marvel", modifier = Modifier.padding(horizontal = 16.dp))
        RecentSearch(keyword = "Marvel", modifier = Modifier.padding(horizontal = 16.dp))
        RecentSearch(keyword = "Marvel", modifier = Modifier.padding(horizontal = 16.dp))
        RecentSearch(keyword = "Marvel", modifier = Modifier.padding(horizontal = 16.dp))
    }
}

@Preview()
@Composable
fun PreviewSearchPage() {
    MovieComposeTheme(darkTheme = false, dynamicColor = false) {
        SearchPage()
    }
}