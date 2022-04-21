package com.example.myappcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappcompose.models.CredictCard
import com.example.myappcompose.ui.theme.BlueBlack

@Composable
fun CardsListItem(cards: CredictCard) {

  Card(
    modifier = Modifier
      .padding(horizontal = 8.dp, vertical = 8.dp)
      .fillMaxWidth()
      .height(70.dp),
    elevation = 4.dp,
    backgroundColor = Color.LightGray,
    shape = RoundedCornerShape(corner = CornerSize(12.dp))
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(start = 30.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.Center
    ) {
      Image(
        painter =
        painterResource(id = cards.image),
        contentDescription = cards.nameCard,
        contentScale = ContentScale.Fit,
        modifier = Modifier
          .size(50.dp, 50.dp)
          .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
      )
      Column(
        modifier = Modifier
          .padding(start = 56.dp, top = 12.dp, bottom = 16.dp)
          .fillMaxWidth(),
      ) {
        cards.nameCard?.let {
          Text(
            text = it,
            color = BlueBlack,
            style = MaterialTheme.typography.h6
          )
        }
        cards.cardtype?.let {
          Text(
            text = it,
            color = BlueBlack,
            style = MaterialTheme.typography.caption
          )
        }
      }
    }
  }
}

@Preview(showBackground = false)
@Composable
fun ListItemPreview() {
  CardsListItem(
    cards = CredictCard(1, null, "ApplePay", R.drawable.applepay)
  )
}
