package net.MyKanisa.ui.worship

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.MyKanisa.R
import net.MyKanisa.ui.auth.AuthViewModel
import net.MyKanisa.ui.home.appBarTitle
import net.MyKanisa.ui.home.bottomBoxes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun WorshipTimesPage(navController: NavHostController, viewModel: AuthViewModel?) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = {
                    appBarTitle(viewModel, navController)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFFC2DBE0))
            )
        },
        content = {

            Box {

                Image(
                    painter = painterResource(id = R.drawable.resized_background1),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Spacer(modifier = Modifier.height(35.dp))
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        elevation = CardDefaults.cardElevation(10.dp)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Worship Times",
                                style = MaterialTheme.typography.headlineMedium,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                            WorshipTime("Sunday Worship", "Morning Service: 10:00 AM")
                            WorshipTime("Sunday Worship", "Evening Service: 6:00 PM")
                            WorshipTime("Wednesday Prayer Meeting", "Time: 7:00 PM")
                        }
                    }
                    val colors = listOf<Color>(
                        Color.Gray,
                        Color.LightGray,
                        Color.LightGray,
                        Color.LightGray,
                    )
                    bottomBoxes(navController = navController, colors = colors)
                }
            }
        })
}

@Composable
fun WorshipTime(day: String, time: String) {
    Column(
        modifier = Modifier.padding(bottom = 8.dp)
    ) {
        Text(
            text = day,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = time,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}
