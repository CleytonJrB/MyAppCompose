package com.example.myappcompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myappcompose.data.DataProvider
import com.example.myappcompose.models.CredictCard
import com.google.gson.Gson

@Composable
fun CardsLazyColumn(navController: NavHostController) {

    fun navigateDetail(card: CredictCard) {
        val detailJson = Gson().toJson(card)
        navController.navigate("detail_screen/${detailJson}")
    }

    val cards = remember {
        DataProvider.cardsList
    }

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 10.dp),
        modifier = Modifier.height(350.dp)
    ) {
        items(cards) { cards ->
            androidx.compose.material.Surface(modifier =
            Modifier
                .clickable {
                    cards?.let {
                        navigateDetail(
                            card = it
                        )
                    }
                }) {

                cards?.let { CardsListItem(cards = it) }

            }
        }
        item {
            androidx.compose.material.Surface(modifier = Modifier.clickable {
                navController.navigate(
                    "Payment_Screen"
                )
            }) {
                AddNewPayment()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CardsLazyColumnPreview() {
    CardsLazyColumn(rememberNavController())
}