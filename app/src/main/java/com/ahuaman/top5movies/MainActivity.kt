package com.ahuaman.top5movies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahuaman.top5movies.ui.theme.Top5MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Top5MoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalTextApi::class)
@Composable
fun CustomTopMovie(name: String, fontSize: TextUnit = 40.sp, modifier: Modifier) {
    Box(
        modifier = modifier.offset(
            x = 3.dp,
            y = 8.dp
        ),
        contentAlignment = Alignment.BottomStart
    ) {
        Text(
            text = name,
            style = TextStyle(
                fontSize = fontSize,
                fontFamily = FontFamily(Font(R.font.monserat_semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF242A32),
            )
        )
        Text(
            text = name,
            style = TextStyle(
                fontSize = fontSize,
                fontFamily = FontFamily(Font(R.font.monserat_semibold)),
                fontWeight = FontWeight(600),
                color = Color(0xFF0296E5),
                drawStyle = Stroke(
                    width = 1f,
                    cap = Stroke.DefaultCap,
                    join = Stroke.DefaultJoin,
                )
            )
        )

    }
}


@Composable
fun MovieItem(
    name: String = "1",
    modifier: Modifier = Modifier,
){
    Column() {
        Box {
            Image(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 8.dp,
                            topEnd = 8.dp,
                            bottomStart = 8.dp,
                            bottomEnd = 8.dp
                        )
                    ),
                painter = painterResource(id = R.drawable.img_sample), contentDescription = null,
            )

            CustomTopMovie(name = name,
                modifier = Modifier.align(Alignment.BottomStart))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Top5MoviesTheme {
       CustomTopMovie(name = "2", modifier = Modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun CustomItemMoviePreview() {
    Top5MoviesTheme {
        MovieItem()
    }
}

@Preview
@Composable
fun AllItemsTop5() {
    LazyRow(
        userScrollEnabled = true,
    ) {
        item {
            MovieItem(name = "1")
            MovieItem(name = "2")
            MovieItem(name = "3")
            MovieItem(name = "4")
            MovieItem(name = "5")
        }
    }
    
}