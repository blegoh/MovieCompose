package com.example.moviecompose.ui.page

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import com.example.moviecompose.repositories.data.MovieSeries
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.ui.component.RecentSearch
import com.example.moviecompose.ui.component.SearchBar
import com.example.moviecompose.ui.template.MovieCardPortrait

@Composable
fun SearchPage() {
    var text by remember { mutableStateOf("") }
    val result = listOf(
        MovieSeries(
            id = 1,
            title = "Deadpool & Wolverine",
            poster = "https://upload.wikimedia.org/wikipedia/en/2/23/Deadpool_%282016_poster%29.png",
            type = 1
        )
    )
    LazyColumn(Modifier.fillMaxWidth()) {

        item {
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
}

@Preview()
@Composable
fun PreviewSearchPage() {
    MovieComposeTheme(darkTheme = false, dynamicColor = false) {
        SearchPage()
    }
}