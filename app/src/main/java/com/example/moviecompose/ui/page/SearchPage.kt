package com.example.moviecompose.ui.page

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.component.RecentSearch
import com.example.moviecompose.ui.component.SearchBar

@Composable
fun SearchPage() {
    var text by remember { mutableStateOf("") }
    Column(Modifier.fillMaxWidth()) {

        SearchBar(searchText = text) {
            text = it
        }

        Spacer(modifier = Modifier.padding(top = 16.dp))
        Text(
            text = "Recent Searches",
            color = Gray3,
            fontSize = 16.sp,
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