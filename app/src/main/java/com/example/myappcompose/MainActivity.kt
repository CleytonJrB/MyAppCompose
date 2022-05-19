package com.example.myappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myappcompose.ui.theme.BlueBlack
import com.example.myappcompose.ui.theme.BlueLigth
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {

      ModalBottomLayout()

    }
  }

  @OptIn(ExperimentalMaterialApi::class)
  @Composable
  fun ModalBottomLayout() {
    val modalBottomSheetState =
      rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden, confirmStateChange = {
        it != ModalBottomSheetValue.HalfExpanded
      })
    val scope = rememberCoroutineScope()

    ModalBottomSheetLayout(
      sheetContent = {

        ModalBottomSheet()

      },
      sheetState = modalBottomSheetState,
      sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
      sheetBackgroundColor = Color.White,
    ) {
      Scaffold() {
        MainContent(scope = scope, state = modalBottomSheetState)
      }
    }
  }

  @OptIn(ExperimentalMaterialApi::class)
  @Composable
  fun MainContent(scope: CoroutineScope, state: ModalBottomSheetState) {



    Column(
      Modifier
        .fillMaxSize()
        .background(color = Color.White),
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Button(
        colors = ButtonDefaults.buttonColors(
          backgroundColor = BlueLigth,
          contentColor = Color.White
        ),
        onClick = {
          scope.launch {
            if (state.isVisible) {
              state.hide()
            } else {
              state.animateTo(ModalBottomSheetValue.Expanded)
            }
          }
        }) {
        Text(text = "Abrir o Modal Bottom Sheet", color = BlueBlack)
      }
    }
  }

  @Preview(showBackground = true, showSystemUi = false)
  @Composable
  fun DefaultPreview() {
    ModalBottomLayout()
  }
}
