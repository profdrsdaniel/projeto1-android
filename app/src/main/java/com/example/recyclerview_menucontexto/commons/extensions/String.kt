package com.example.recyclerview_menucontexto.commons.extensions

fun String.convertToMoneyWithSymbol() = "R$".plus(this.replace(".", ","))