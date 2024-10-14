package com.example.mycoffieshop

import android.graphics.fonts.FontStyle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycoffieshop.ui.theme.MyCoffieShopTheme
import com.example.mycoffieshop.ui.theme.buttonColor

class orderActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffieShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Order(modifier = Modifier.padding(innerPadding), 0)
                }
            }
        }
    }
}

@Composable
fun Order(modifier: Modifier = Modifier, a:Int) {
    Column {
        Box(modifier = Modifier.fillMaxWidth()){
            Icon(painter = painterResource(id = R.drawable.back), contentDescription = "back button")
            Text(
                text = "Order",
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f),
                colors = ButtonColors(contentColor = Color.White, containerColor = buttonColor, disabledContentColor = Color.Gray, disabledContainerColor = Color.White)
            ) {
                Text(text = "Deliver")
            }
            FilledTonalButton(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                Text(text = "Pick Up")
            }
        }
        Text(
            text = "Delivery Address",
            modifier = Modifier
                .padding(16.dp),
            fontWeight = FontWeight.Bold
        )
        var address by remember {
            mutableStateOf("Enter the address")
        }
        TextField(
            value = address,
            onValueChange = { newAddress ->
                address = newAddress
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row (modifier = Modifier.padding(16.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.c1),
                contentDescription = "photo",
                modifier = Modifier.sizeIn(maxHeight = 54.dp)
            )
            Column (modifier = Modifier.weight(1f)) {
                Text(text = "Caffe Mocha")
                Text(text = "Deep foam", color = Color.Gray, fontSize = 16.sp)
            }
            var quantity by remember {
                mutableStateOf(1)
            }
            Icon(
                painter = painterResource(id = R.drawable.minus_circle),
                contentDescription = "Minus Circle",
                modifier = Modifier.clickable(onClick = {
                    quantity--
                })
            )
            Text(text = quantity.toString())
            Icon(
                painter = painterResource(id = R.drawable.pluscircle),
                contentDescription = "Plus Circle",
                modifier = Modifier.clickable(onClick = {
                    quantity++
                })
            )
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black)
        ) {
            Icon(painter = painterResource(id = R.drawable.discount), contentDescription = "Discount icon")
            Text(text = "1 Discount code is applicable", modifier = Modifier.weight(1f))
            Icon(painter = painterResource(id = R.drawable.discount_arrow), contentDescription = "Discount arrow")
        }
        Text(text = "Payment Summary", fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp))
        Row (modifier = Modifier.padding(16.dp)) {
            Text(text = "Price" , modifier = Modifier.weight(1f))
            Text(text = "$4.53")
        }
        Row (modifier = Modifier.padding(16.dp)) {
            Text(text = "Delivery Fee" , modifier = Modifier.weight(1f))
            Text(
                text = "$2.0",
                style = TextStyle(textDecoration = TextDecoration.LineThrough)
            )
            Text(text = "  $1.0 ")
        }
        Box(modifier = Modifier.background(Color.White)){
            Column {
                Row (modifier = Modifier.padding(16.dp)) {
                    Box(modifier = Modifier.sizeIn(50.dp)){
                        Icon(painter = painterResource(id = R.drawable.wallet), contentDescription = "Wallet", modifier = Modifier)
                    }
                    Column (modifier = Modifier.weight(1f)) {
                        Text(text = "Cash/Wallet", fontWeight = FontWeight.Bold)
                        Text(text = "$5.53")
                    }
                    Icon(painter = painterResource(id = R.drawable.option_payment), contentDescription = "Payment options button")
                }
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp, 16.dp),
                    shape = RoundedCornerShape(30),
                    colors = ButtonColors(contentColor = Color.White, containerColor = buttonColor, disabledContentColor = Color.Gray, disabledContainerColor = Color.White)
                ) {
                    Text(
                        text = "Order",
                        fontSize = 16.sp,
                        modifier = Modifier.padding(16.dp, 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview8() {
    MyCoffieShopTheme {
        Order(a = 0)
    }
}