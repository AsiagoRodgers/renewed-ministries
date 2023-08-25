package net.MyKanisa.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import net.MyKanisa.R

import net.MyKanisa.navigation.ROUTE_COMMUNITIES
import net.MyKanisa.navigation.ROUTE_EVENTS
import net.MyKanisa.navigation.ROUTE_HOME
import net.MyKanisa.navigation.ROUTE_WORSHIP

@Composable
fun bottomBoxes(navController: NavHostController, colors: List<Color>){
    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
            ){

        Box {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(colors[0])
                    .clickable {
                        navController.navigate(ROUTE_WORSHIP)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_watch_later_24),
                    contentDescription = null
                )
            }
        }
        Box {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(colors[1])
                    .clickable {
                        navController.navigate(ROUTE_HOME)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_home_24),
                    contentDescription = null
                )
            }
        }
        Box {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(colors[2])
                    .clickable {
                        navController.navigate(ROUTE_EVENTS)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.calendartoday),
                    contentDescription = null
                )
            }
        }
        Box {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(colors[3])
                    .clickable {
                        navController.navigate(ROUTE_COMMUNITIES)
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_groups_24),
                    contentDescription = null
                )
            }
        }
    }
}
