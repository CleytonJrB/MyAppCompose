package com.example.myappcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myappcompose.Navigation.Screen
import com.example.myappcompose.ui.theme.BlueCart


@Composable
fun Payment(navController: NavController) {

  var isSelected by remember {
    mutableStateOf(false)
  }

  var color = if(isSelected){
    Color(0xFFAAFFCA)
  }else colorResource(id = R.color.white)

  val focado by remember { mutableStateOf(true)}

  Card(
    modifier = Modifier
      .padding(horizontal = 12.dp, vertical = 38.dp)
      .fillMaxWidth()
      .border(width = 3.dp, color)
//      .onFocusChanged {
//        color = if (it.isFocused) Color(0xFFAAFFCA) else Color.White
//      }
      .clickable(
        onClick = {
          isSelected = ! isSelected
        }
      ),

    elevation = 4.dp,
//    backgroundColor = Color.White,
//    shape = RoundedCornerShape(corner = CornerSize(20.dp))
  ) {
    Column(
      modifier = Modifier
        .padding(10.dp)
        .fillMaxWidth(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
//      TextField(
//        value = "Meu campo de texto",
//        onValueChange = { },
//        modifier = Modifier.onFocusChanged { focusState ->
//          when {
//            focusState.isFocused ->
//              println("Estou focado!")
//            focusState.hasFocus ->
//              println("A filho meu tem foco!")
//          }
//        }
//      )
//      OutlinedTextField(
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("Primeiro Nome") }
//      )
//      OutlinedTextField(
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("Nome do Cartao") }
//      )
//      OutlinedTextField(
//        value = text,
//        onValueChange = { text = it },
//        label = { Text("Tipo de Cartao") }
//      )
      Text(
        text = "Adicionar",
        style = TextStyle(Color.White),
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
          .padding(vertical = 10.dp)
          .clickable { navController.navigate(Screen.MainScreen.route) }
          .width(200.dp)
          .align(alignment = Alignment.CenterHorizontally)
          .clip(RoundedCornerShape(10.dp))
          .background(Color.DarkGray)
          .padding(bottom = 10.dp, top = 10.dp, start = 10.dp, end = 10.dp)
      )
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PaymentPreview() {
  Payment(rememberNavController())
}