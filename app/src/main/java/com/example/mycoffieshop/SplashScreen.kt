package com.example.mycoffieshop

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mycoffieshop.ui.theme.MyCoffieShopTheme
import com.example.mycoffieshop.ui.theme.buttonColor

class SplashScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffieShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SplashScreenBackground(
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        val intent = Intent(this, Dashboard::class.java)
                        startActivity(intent)
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreenBackground(modifier: Modifier = Modifier, callback : () -> Unit) {
    Box(modifier = Modifier
        .fillMaxHeight()
        .fillMaxWidth()) {
        createConstraint(callback)

    }
}

@Composable
fun createConstraint(callback : () -> Unit) {
    ConstraintLayout {
        val guidLine66 = createGuidelineFromTop(0.66f)
        val guidLine55 = createGuidelineFromTop(0.55f)

        val (top_bg, bottom_bg) = createRefs()
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(bottom_bg) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guidLine66)
                },
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.onbording_image),
            contentDescription = "splash_screen_background_2"
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(top_bg) {
                    bottom.linkTo(parent.bottom)
                    top.linkTo(guidLine55)
                },
            contentScale = ContentScale.Crop,
            painter = painterResource(id = R.drawable.shadow_container),
            contentDescription = "splash_screen_background"
        )
    }
    foreground(callback)
}

@Composable
fun foreground (callback : () -> Unit) {
    Box(modifier = Modifier.fillMaxHeight() ){
        Column (
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ){
//            Spacer(modifier = Modifier.weight(0.66f))
            Column(){
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    text = "Fall in Love with",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    text = "Coffee in Blissful",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 5.dp),
                    text = "Delight!",
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Text(
                text = "Welcome to our cozy coffee corner, where every cup is delightful for you",
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                fontSize = 20.sp
            )
            Button(
                onClick = {
                    callback()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp, 0.dp),
                shape = RoundedCornerShape(30),
                colors = ButtonColors(contentColor = Color.White, containerColor = buttonColor, disabledContentColor = Color.Gray, disabledContainerColor = Color.White)
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(20.dp, 16.dp)
                )
            }
            Spacer(modifier = Modifier.size(64.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SplashScreenBackground(modifier = Modifier.padding(16.dp)) {

    }
}