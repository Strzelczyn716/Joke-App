package com.example.jokeapp.ui.joke

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jokeapp.data.model.Joke
import com.example.jokeapp.R

@Composable
fun JokeListItem(joke: Joke) {
    val TYPE = "single"
    val CATEGORY = "Programming"
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .align(Alignment.CenterVertically)
            ) {
                if (joke.type == TYPE) {
                    Text(text = joke.joke.toString(), style = typography.h6)

                } else {
                    Text(text = joke.setup.toString(), style = typography.h6)
                    Text(text = joke.delivery.toString(), style = typography.caption)
                }
                if(joke.category == CATEGORY){
                    Text(text = stringResource(id = R.string.good_joke), textAlign = TextAlign.Center)
                }
            }
        }
    }
}