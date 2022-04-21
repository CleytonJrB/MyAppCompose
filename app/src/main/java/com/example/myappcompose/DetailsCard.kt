package com.example.myappcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myappcompose.Navigation.Screen
import com.example.myappcompose.models.CredictCard
import com.example.myappcompose.ui.theme.*

@Composable
fun DetailsCardContent(card: CredictCard,navController: NavController) {

  fun paymentApp(): Arrangement.Horizontal {
    return if (card.cardtype == null) {
      Arrangement.Center
    } else {
      Arrangement.SpaceBetween
    }
  }

  Card(
    modifier = Modifier
      .padding(horizontal = 12.dp, vertical = 38.dp)
      .fillMaxWidth()
      .height(220.dp)
      .clickable {
        navController.navigate(Screen.MainScreen.route)
      },
    elevation = 4.dp,
    backgroundColor = BlueCart,
    shape = RoundedCornerShape(corner = CornerSize(20.dp))
  ) {
      Column(
        modifier = Modifier
          .padding(10.dp)
          .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
      Row(
        modifier = Modifier
          .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = paymentApp()
      ) {
        card.cardtype?.let {
          Text(
            modifier = Modifier
              .padding(5.dp),
            text = it,
            color = White,
            fontSize = 22.sp,
            fontFamily = Ubuntu
          )
        }
        Image(
          painter = painterResource(id = card.image),
          contentDescription = null,
          contentScale = ContentScale.Fit,
          modifier = Modifier
            .padding(5.dp)
            .size(60.dp, 60.dp)
        )
        }
        Column(
          modifier = Modifier
            .fillMaxSize()
            .padding(5.dp),
          horizontalAlignment = Alignment.Start,
          verticalArrangement = Arrangement.Center
        ) {
          Image(
            painter = painterResource(id = R.drawable.subtract),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
              .size(50.dp, 35.dp)
          )
          Column(
            modifier = Modifier
              .fillMaxSize()
              .padding(top = 15.dp),
            horizontalAlignment = Alignment.Start
          ) {
            Row(
              modifier = Modifier
                .fillMaxWidth(),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.SpaceBetween
            ) {
              Text(
                text = card.firstName.toString(),
                color = White,
                fontSize = 28.sp,
                fontFamily = Ibm
              )
              Text(
                text = "CVV",
                color = White,
                fontSize = 22.sp,
                fontFamily = Ibm,
                modifier = Modifier
                  .padding(end = 18.dp)
              )

            }
            Text(
              modifier = Modifier.fillMaxWidth(),
              text = "**** **** **** ****",
              color = White,
              fontSize = 28.sp,
              fontFamily = Ibm
            )
          }
        }
      }
    }
  }

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun DetailsPreview() {
  DetailsCardContent(card = CredictCard(1, "Filipe R.", "Visa", R.drawable.applepay, null),
    rememberNavController())
}