package com.example.myappcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myappcompose.Navigation.Navigation
import com.example.myappcompose.Navigation.Screen
import com.example.myappcompose.ui.theme.BlueBlack
import com.example.myappcompose.ui.theme.White

@Composable
fun ModalBottomSheet() {

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(White)
  ) {
    Column(
      modifier = Modifier
        .height(80.dp)
    ) {
      Text(
        text = "NorBr",
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.h5,
        color = BlueBlack,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
      )
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
      ) {
        Text(
          text = "$",
          fontSize = 26.sp,
          color = BlueBlack,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(end = 45.dp)
        )
        Text(
          text = "50.50",
          fontSize = 26.sp,
          color = BlueBlack,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.padding(start = 45.dp)
        )
      }
    }
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .align(Alignment.CenterHorizontally)
    ) {

      Navigation()

    }
    Row(
      modifier = Modifier
        .fillMaxWidth(),
      horizontalArrangement = Arrangement.Center
    ) {
      Text(
        text = "CONFIRMAR PAGAMENTO",
        style = TextStyle(Color.White),
        textAlign = TextAlign.Center,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
          .fillMaxWidth()
          .align(Alignment.CenterVertically)
          .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp))
          .background(Color.DarkGray)
          .padding(bottom = 20.dp, top = 20.dp)
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
  ModalBottomSheet()
}
