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
import com.example.myappcompose.ui.theme.BlueBlack

@Composable
fun AddNewPayment(){
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
        .padding(start = 0.dp),
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.SpaceEvenly
    ) {
      Image(
        painter =
        painterResource(id = R.drawable.ic_baseline_add_24),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier
          .size(50.dp, 50.dp)
          .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
      )
      Text(
        text = "Novo metodo de pagamento",
        color = BlueBlack,
        style = MaterialTheme.typography.h6
      )
    }
  }
}

@Preview
@Composable
fun AddNewPaymentPreview(){
  AddNewPayment()
}