package com.example.mycoffieshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffieshop.ui.theme.MyCoffieShopTheme

class coffee4Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffieShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting4(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Composable
fun Greeting4(modifier: Modifier = Modifier) {
    Column {
        Row{
            Icon(
                painter = painterResource(R.drawable.back),
                contentDescription = "Back"
            )
            Text(
                text = "Detail",
                Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 32.sp
            )
            Icon(
                painter = painterResource(R.drawable.like),
                contentDescription = "Add to favourites"
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.c4),
            contentDescription = "Coffee 1",
            modifier = Modifier.fillMaxWidth()
        )
        Row{
            Column (modifier = Modifier.weight(1f)){
                Text(text = "My Coffee 2")
                Text(text = "Ice/Hot", fontSize = 12.sp, color = Color.Gray)
            }
            Icon(painter = painterResource(id = R.drawable.superiority), contentDescription = "Three icons")
        }
        Row {
            Icon(painter = painterResource(id = R.drawable.star), contentDescription = "Rating star")
            Text(text = "4.8")
            Text(text = "(230)", color = Color.Gray)
        }
        Spacer(modifier = modifier.height(16.dp))
        Text(text = "Description")
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "A cappuccino is an approximately 150 ml (5 oz) beverage, with 25 ml of espresso coffee and 85ml of fresh milk the fo.. Read More",
            color = Color.Gray,
            fontSize = 12.sp
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(text = "Size")
        Row {
            Icon(
                painter = painterResource(id = R.drawable.small),
                contentDescription = "Small button",
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.medium),
                contentDescription = "Medium button",
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.large),
                contentDescription = "Large button",
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(modifier = modifier.height(16.dp))
        Row (modifier = Modifier.background(Color.White).padding(16.dp)) {
            Column (modifier = Modifier.weight(1f)){
                Text(
                    text = "Price",
                    color = Color.Gray
                )
                Text(text = "$ 1.53", color = Color(0XFFC67C4E))
            }
            Icon(
                painter = painterResource(R.drawable.buy_button),
                contentDescription = "Button to Buy now"
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview6() {
    MyCoffieShopTheme {
        Greeting4()
    }
}