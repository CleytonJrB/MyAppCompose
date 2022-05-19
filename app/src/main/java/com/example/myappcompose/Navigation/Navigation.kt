package com.example.myappcompose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myappcompose.*
import com.example.myappcompose.models.CredictCard
import com.google.gson.Gson

@Composable
fun Navigation() {

  val navController = rememberNavController()

  NavHost(navController = navController, startDestination = Screen.MainScreen.route) {
    composable(route = Screen.MainScreen.route) { CardsLazyColumn(navController) }
    composable(
      route = Screen.DetailScreen.route + "/{detail}",
      arguments = listOf(
        navArgument("detail") { type = NavType.StringType }
      )
    ) { entry ->

      entry.arguments?.getString("detail")?.let { json ->
        val detail = Gson().fromJson(json, CredictCard::class.java)
        DetailsCardContent(card = detail,navController)

      }
    }
    composable(route= Screen.NewPayment.route){ Payment(navController)}
  }
}

