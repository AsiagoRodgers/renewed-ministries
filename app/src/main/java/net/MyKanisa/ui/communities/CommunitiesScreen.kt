package net.MyKanisa.ui.communities

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.MyKanisa.ui.auth.AuthViewModel
import net.MyKanisa.ui.home.appBarTitle
import net.MyKanisa.ui.home.bottomBoxes
import net.MyKanisa.R


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CommunitiesPage(communities: List<Communities>, onJoinClick: (Communities) -> Unit, navController: NavHostController, viewModel: AuthViewModel?) {
    Scaffold(topBar = {
        SmallTopAppBar(
            title = {
                appBarTitle(viewModel, navController)
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(Color(0xFFC2DBE0))
        )
    })
    {
        Box (
            modifier = Modifier.fillMaxSize()
                .paint(
                    painter = painterResource(id = R.drawable.resized_background1),
                    contentScale = ContentScale.FillBounds
                )
                ){

            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceBetween
            ){

                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Spacer(modifier = Modifier.height(40.dp))
                    LazyColumn {
                        items(communities) {community ->
                            CommunityItem(community = community, onJoinClick = onJoinClick)
                            Divider(
                                modifier = Modifier.padding(horizontal = 16.dp),
                                color = Color.DarkGray
                            )
                        }
                    }
                }

                val colors = listOf<Color>(
                    Color.LightGray,
                    Color.LightGray,
                    Color.LightGray,
                    Color.Gray,
                )
               bottomBoxes(navController = navController, colors = colors)
            }
        }
    }
}

@Composable
fun CommunityItem(community: Communities, onJoinClick: (Communities) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = community.name,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = community.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
        Button(
            onClick = { onJoinClick(community) },
            enabled = !community.isJoined
        ) {
            Text(text = if (community.isJoined) "Joined" else "Join")
        }
    }
}

