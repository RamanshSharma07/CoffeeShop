package com.example.mycoffieshop.model

data class ItemModel (
    val itemImage: String,
    val contentDescription: String,
    var itemPrice: Int,
    val rating: Ratings,
    val itemName: String,

)