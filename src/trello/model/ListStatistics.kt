package com.example.trello.model

data class ListStatistics(
    val name: String,
    var cards: Array<Card>?,
    var labelAmounts: MutableMap<String, Int>
)