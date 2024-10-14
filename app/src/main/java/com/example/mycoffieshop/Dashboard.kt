package com.example.mycoffieshop

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.mycoffieshop.model.ItemModel
import com.example.mycoffieshop.model.Ratings
import com.example.mycoffieshop.ui.theme.DashboardBg
import com.example.mycoffieshop.ui.theme.MyCoffieShopTheme

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyCoffieShopTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    dashboardCreater(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun dashboardCreater(modifier: Modifier) {
    Background(mod = modifier)
    forground(modifier = modifier)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun forground(modifier: Modifier) {
    val context = LocalContext.current
    Column(modifier = modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(32.dp))
        Text(text = "Location", color = Color.Green)
        val countries = listOf(
            "Select",
            "Afghanistan",
            "Albania",
            "Algeria",
            "Andorra",
            "Angola",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bhutan",
            "Bolivia",
            "Bosnia and Herzegovina",
            "Botswana",
            "Brazil",
            "Brunei",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cabo Verde",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Central African Republic",
            "Chad",
            "Chile",
            "China",
            "Colombia",
            "Comoros",
            "Congo (Congo-Brazzaville)",
            "Costa Rica",
            "Croatia",
            "Cuba",
            "Cyprus",
            "Czech Republic",
            "Democratic Republic of the Congo",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Eswatini",
            "Ethiopia",
            "Fiji",
            "Finland",
            "France",
            "Gabon",
            "Gambia",
            "Georgia",
            "Germany",
            "Ghana",
            "Greece",
            "Grenada",
            "Guatemala",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Honduras",
            "Hungary",
            "Iceland",
            "India",
            "Indonesia",
            "Iran",
            "Iraq",
            "Ireland",
            "Israel",
            "Italy",
            "Ivory Coast",
            "Jamaica",
            "Japan",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Kosovo",
            "Kuwait",
            "Kyrgyzstan",
            "Laos",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands",
            "Mauritania",
            "Mauritius",
            "Mexico",
            "Micronesia",
            "Moldova",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Morocco",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands",
            "New Zealand",
            "Nicaragua",
            "Niger",
            "Nigeria",
            "North Korea",
            "North Macedonia",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines",
            "Poland",
            "Portugal",
            "Qatar",
            "Romania",
            "Russia",
            "Rwanda",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Korea",
            "South Sudan",
            "Spain",
            "Sri Lanka",
            "Sudan",
            "Suriname",
            "Sweden",
            "Switzerland",
            "Syria",
            "Taiwan",
            "Tajikistan",
            "Tanzania",
            "Thailand",
            "Timor-Leste",
            "Togo",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates",
            "United Kingdom",
            "United States of America",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Vatican City",
            "Venezuela",
            "Vietnam",
            "Yemen",
            "Zambia",
            "Zimbabwe"
        )
        var selectedIndex by rememberSaveable {
            mutableStateOf(0)
        }
        DropDownList(
            countries = countries,
            selectedIndex = selectedIndex
        ) {
            selectedIndex = it
        }
        Spacer(modifier = Modifier.height(32.dp))
        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(vertical = 0.dp, horizontal = 10.dp)
        ) {
            Box {
                Row {
                    var searchCoffee by remember {
                        mutableStateOf("Search coffee")
                    }
                    TextField(
                        value = searchCoffee,
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.real_search_icon),
                                contentDescription = "emailIcon"
                            )
                        },
                        onValueChange = {
                            searchCoffee = it
                        }
                    )
                }
            }
//            Icon(
//                painter = painterResource(id = R.drawable.filter),
//                contentDescription = "Filter button",
//                modifier = Modifier
//                    .width(40.dp)
//                    .height(40.dp)
//                    .align(Alignment.CenterVertically)
//                    .clickable {
//                        Toast
//                            .makeText(context, "this is a simple toast", Toast.LENGTH_LONG)
//                            .show()
//                    }
//            )
            GlideImage(
                model = "https://www.vecteezy.com/png/25250961-the-cool-cats-generative-ai-ai-generated",
                contentDescription = "icon",
                modifier = Modifier.padding(2.dp)
                    .width(40.dp)
                    .height(40.dp)
                    .align(Alignment.CenterVertically)
                    .clickable {
                    Toast.makeText(context, "this is a simple toast", Toast.LENGTH_LONG).show()
                }

            )
        }
        var selectedIndexOfFilter = remember {
            mutableStateOf(0)
        }
        Spacer(modifier = Modifier.height(200.dp))
        LazyRow {
            items(5) {
                filterChip(
                    text = "All Coffee",
                    index = it
                ) {
                    selectedIndexOfFilter.value = it
                }
            }
        }
        LazyVerticalGrid(
            columns = GridCells.Adaptive(100.dp)
        ) {
            for(i in 0..3){
                var jh = "c"+(1+ i).toString()
                val item = ItemModel(
                    jh,
                    "",
                    100,
                    Ratings.Two,
                    "items ${i+1}"
                )
                item {
                    Row {
                        coffeeBox(itemModel = item)
                    }
                }
            }
        }
    }
}


val coffeeList = arrayListOf("Caffe Mocha", "Flat White", "My Coffee", "My Coffee2")
val coffeeDecList = arrayListOf("Deep foam", "Espresso", "Normal Coffee", "Normal Coffee2")

@Composable
fun coffeeBox(itemModel: ItemModel){

    Column(modifier = Modifier){

        Image(
            painter = painterResource(id = R.drawable.c2),
            contentDescription = "sdfd"
        )
        Text(text = itemModel.itemName)
        Text(text = "${itemModel.itemPrice}", color = Color.LightGray)
        Row {
            Text(text = "$"+"${itemModel.itemPrice}", Modifier.weight(1f))
            IconButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.icon_2), contentDescription = "Add Button")
            }
        }
    }
}

@Composable
fun Background(mod: Modifier) {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val startGuideline = createGuidelineFromTop(0.2f)
        val (WhiteBG, BlackBG, Banner) = createRefs();
        Box(
            modifier = Modifier
                .background(DashboardBg)
                .fillMaxWidth()
                .constrainAs(BlackBG) {
                    top.linkTo(parent.top, margin = 16.dp)
                    bottom.linkTo(startGuideline)
                }
        ) {}
        Card (
            modifier = Modifier.constrainAs(Banner){
                top.linkTo(BlackBG.bottom)
                bottom.linkTo(WhiteBG.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.banner),
                contentDescription = "banner"
            )
        }
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxWidth()
                .constrainAs(WhiteBG) {
                    bottom.linkTo(parent.bottom, margin = 16.dp)
                    top.linkTo(startGuideline)
                }
        ) {}
    }
}


@Composable
fun DropDownList(
    countries: List<String>,
    selectedIndex: Int,
    onItemClick: (Int) -> Unit
) {
    var showDropDown by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxWidth()
            .heightIn(30.dp)
            .clickable { showDropDown = true }
    ) {
        Text(
            text = countries[selectedIndex],
            modifier = Modifier.padding(3.dp)
        )
    }
    if (showDropDown) {
        Popup(
            alignment = Alignment.TopStart,
            properties = PopupProperties(
                excludeFromSystemGesture = true
            ),
            onDismissRequest = { showDropDown = false },
        ) {
            popUpItem(countries = countries) {
                showDropDown = !showDropDown
                onItemClick(it)
            }
        }
    }
}

@Composable
fun popUpItem(
    countries: List<String>,
    onItemClick: (Int) -> Unit
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .background(Color.White, RectangleShape)
            .fillMaxHeight(0.5f)
            .verticalScroll(state = scrollState)
            .border(1.dp, Color.Gray),
        horizontalAlignment = Alignment.Start
    ) {
        countries.onEachIndexed { index, s ->
            if (index != 0) {
                HorizontalDivider(thickness = 1.dp, color = Color.LightGray)
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onItemClick(index)
                    },
                contentAlignment = Alignment.CenterStart
            ) {
                Text(text = s)
            }
        }
    }
}

@Composable
fun filterChip(
    text: String,
    index: Int,
    onItemClick: (Int) -> Unit,
) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = {
            onItemClick(index)
        },
        label = {
            Text(text)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    MyCoffieShopTheme {
        dashboardCreater(modifier = Modifier)
    }
}