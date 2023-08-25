package net.MyKanisa.ui.events

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.MyKanisa.R
import net.MyKanisa.ui.auth.AuthViewModel
import net.MyKanisa.ui.home.appBarTitle
import net.MyKanisa.ui.home.bottomBoxes

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EventsPage(events: List<Event>, onEventClick: (Event) -> Unit, navController: NavHostController, viewModel: AuthViewModel?) {
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
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                    ) {
                        Spacer(
                            modifier = Modifier.height(70.dp)
                        )
                        LazyColumn {
                            items(events) { event ->
                                EventCard(event = event, onEventClick = onEventClick)
                                Spacer(modifier = Modifier.height(16.dp))
                            }
                        }
                    }
                    val colors = listOf<Color>(
                        Color.LightGray,
                        Color.LightGray,
                        Color.Gray,
                        Color.LightGray,
                    )
                    bottomBoxes(navController = navController, colors = colors)
                    }
                }
        })
}

@Composable
fun EventCard(event: Event, onEventClick: (Event) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onEventClick(event) },
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = event.title,
                style = MaterialTheme.typography.headlineSmall,
                textAlign = TextAlign.Center
            )
            Text(
                text = event.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
            Text(
                text = event.date,
                style = MaterialTheme.typography.labelSmall,
                textAlign = TextAlign.Center,
                color = Color.Gray
            )
        }
    }
}



