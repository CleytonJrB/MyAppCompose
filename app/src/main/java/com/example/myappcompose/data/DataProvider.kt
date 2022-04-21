package com.example.myappcompose.data

import com.example.myappcompose.R
import com.example.myappcompose.models.CredictCard

object DataProvider {

  val cardtype = "Credito ou Debito"

  val cardsList = listOf(

    CredictCard(
      id = 1,
      firstName = "Filipe Ret.",
      nameCard = "Visa",
      image = R.drawable.visa,
      cardtype = cardtype
    ),
    CredictCard(
      id = 2,
      firstName = "Djonga",
      nameCard = "Master Card",
      image = R.drawable.master,
      cardtype = cardtype
    ),
    CredictCard(
      id = 3,
      firstName = "Bk D`Lapa",
      nameCard = "Discover",
      image = R.drawable.discover,
      cardtype = cardtype
    ),
    CredictCard(
      id = 4,
      firstName = "Cleyton B.",
      nameCard = "Diners Club",
      image = R.drawable.dinnersclub,
      cardtype = cardtype
    ),
    CredictCard(
      id = 5,
      nameCard = "PayPal",
      firstName = "Cleyson B.",
      image = R.drawable.paypal,
      cardtype = null
    ),
    CredictCard(
      id = 6,
      nameCard = "GooglePay",
      firstName = "Wallace V.",
      image = R.drawable.googlepay,
      cardtype = null
    ),
    CredictCard(
      id = 7,
      nameCard = "ApplePay",
      firstName = "Daniel M.",
      image = R.drawable.applepay,
      cardtype = null
    ),
  )
}