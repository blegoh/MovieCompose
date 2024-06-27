package com.example.moviecompose.view.items

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.moviecompose.R
import com.example.moviecompose.repositories.data.MovieDetail
import com.example.moviecompose.theme.Blue1
import com.example.moviecompose.theme.Gray2
import com.example.moviecompose.theme.Gray3
import com.example.moviecompose.theme.MovieComposeTheme
import com.example.moviecompose.view.MovieGenre

@Composable
fun Detail(movieDetail: MovieDetail, onBack: () -> Unit) {
    Column {
        AsyncImage(
            model = "https://image.tmdb.org/t/p/w500/${movieDetail.backdropPath}",
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1.778f)
        )
        Text(
            text = movieDetail.title.toString(), style = TextStyle(
                fontSize = 24.sp, lineHeight = 28.sp
            ), color = Gray2, modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        )
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Text(text = movieDetail.releaseDate?.split("-")?.firstOrNull() ?: "", color = Gray3)
            Text(text = "1 hr 34m", color = Gray3, modifier = Modifier.padding(start = 16.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { },
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Blue1,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(4.dp),
        ) {
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Play",
                modifier = Modifier.size(24.dp)  // Set the size of the icon
            )
            Text("Watch Now")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = movieDetail.overview ?: "",
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        MovieGenre(
            listOf("Action", "Comedy", "Adventure"),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp)
        )
        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            val (share) = createRefs()
            val (download) = createRefs()
            val (watchlist) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.share),
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(share) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                    }
                    .height(20.dp)
                    .width(20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.download),
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(download) {
                        top.linkTo(parent.top)
                        end.linkTo(share.start, margin = 32.dp)
                    }
                    .height(24.dp)
                    .width(24.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.watchlist),
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(watchlist) {
                        top.linkTo(parent.top)
                        end.linkTo(download.start, margin = 32.dp)
                    }
                    .height(20.dp)
                    .width(16.dp)
            )
        }
    }
    Image(
        painter = painterResource(id = R.drawable.back),
        contentDescription = "",
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                onBack()
            },
    )
}

@Preview
@Composable
fun PreviewMovieDetail() {
    MovieComposeTheme(darkTheme = false) {
        Detail(MovieDetail()) {}
    }
}