package net.MyKanisa.ui.home

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.MyKanisa.navigation.ROUTE_COMMUNITIES
import net.MyKanisa.navigation.ROUTE_EVENTS
import net.MyKanisa.navigation.ROUTE_HOME
import net.MyKanisa.navigation.ROUTE_LOGIN
import net.MyKanisa.navigation.ROUTE_WORSHIP
import net.MyKanisa.ui.auth.AuthViewModel
import net.MyKanisa.ui.theme.AppTheme
import net.MyKanisa.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
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
            Box(
                modifier = Modifier.fillMaxSize()
                    .paint(
                        painter = painterResource(id = R.drawable.resized_background),
                        contentScale = ContentScale.FillBounds
                    )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(106.dp))

                    //Worship times button
                    Button(
                        onClick = {
                            navController.navigate(ROUTE_WORSHIP) {
                                popUpTo(ROUTE_HOME) { inclusive = true }}
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painterResource(id = R.drawable.baseline_watch_later_24),
                            contentDescription = "Worship Times"
                        )
                        Text(text = "Worship Times")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    //Locate us button
                    Button(
                        onClick = {

                                  },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = "Find Us"
                        )
                        Text(text = "Find Us")
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    //Events button
                    Button(
                        onClick = {
                            navController.navigate(ROUTE_EVENTS) {
                                popUpTo(ROUTE_HOME) { inclusive = true }}
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            painterResource(id = R.drawable.calendartoday),
                            contentDescription = "Events"
                        )
                        Text(text = "Events")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    // Communities button
                    Button(
                        onClick = {
                            navController.navigate(ROUTE_COMMUNITIES) {
                                popUpTo(ROUTE_HOME) { inclusive = true }}
                        },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = painterResource(id = R.drawable.baseline_groups_24),
                            contentDescription = "groups"
                        )
                        Text(
                            modifier = Modifier.padding(start = 3.dp),
                            text = "Communities"
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(CircleShape)
                            .background(Color.White)
                            .padding(7.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val name = viewModel?.currentUser?.displayName
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(Color.LightGray),
                                contentAlignment = Alignment.Center
                            ) {
                                val firstLetter = when(name){
                                    null -> ""
                                    else -> name.first().uppercase()
                                }
                                Text(
                                    text = firstLetter,
                                )
                            }
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Welcome $name",
                            )

                        }
                    }
                }
            }
        }
    )
}


@Composable
fun appBarTitle(viewModel: AuthViewModel?, navController: NavHostController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(end = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.padding(top = 5.dp)
        )

        Box {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF789499))
                    .clickable {
                        viewModel?.logout()
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }}
                    },
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_logout_24),
                    contentDescription = null
                )
            }
        }
    }
}








//@Composable
//fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {
//    val spacing = MaterialTheme.spacing
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .wrapContentHeight()
//            .padding(spacing.medium)
//            .padding(top = spacing.extraLarge),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//
//        Text(
//            text = stringResource(id = R.string.welcome_back),
//            style = MaterialTheme.typography.headlineSmall,
//            color = MaterialTheme.colorScheme.onSurface
//        )
//
//        Text(
//            text = viewModel?.currentUser?.displayName ?: "",
//            style = MaterialTheme.typography.displaySmall,
//            color = MaterialTheme.colorScheme.onSurface
//        )
//
//        Image(
//            painter = painterResource(id = R.drawable.ic_person),
//            contentDescription = stringResource(id = R.string.empty),
//            modifier = Modifier.size(128.dp)
//        )
//
//        Column(
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(spacing.medium)
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                Text(
//                    text = stringResource(id = R.string.name),
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.3f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//
//                Text(
//                    text = viewModel?.currentUser?.displayName ?: "",
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.7f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//            }
//
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .wrapContentHeight()
//            ) {
//                Text(
//                    text = stringResource(id = R.string.email),
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.3f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//
//                Text(
//                    text = viewModel?.currentUser?.email ?: "",
//                    style = MaterialTheme.typography.bodyLarge,
//                    modifier = Modifier.weight(0.7f),
//                    color = MaterialTheme.colorScheme.onSurface
//                )
//            }
//
//            Button(
//                onClick = {
//                    viewModel?.logout()
//                    navController.navigate(ROUTE_LOGIN) {
//                        popUpTo(ROUTE_HOME) { inclusive = true }
//                    }
//                },
//                modifier = Modifier
//                    .align(Alignment.CenterHorizontally)
//                    .padding(top = spacing.extraLarge)
//            ) {
//                Text(text = stringResource(id = R.string.logout))
//            }
//
//
//
//            Text(
//                modifier = Modifier
//                    .clickable {
//                        navController.navigate(ROUTE_SERMON) {
//                            popUpTo(ROUTE_LOGIN) { inclusive = true }
//                        }
//                    },
//                text = "Sermons",
//                style = MaterialTheme.typography.bodyLarge,
//                textAlign = TextAlign.Center,
//                color = MaterialTheme.colorScheme.onSurface
//            )
//
//
//
//
//
//        }
//    }
//}




@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}
