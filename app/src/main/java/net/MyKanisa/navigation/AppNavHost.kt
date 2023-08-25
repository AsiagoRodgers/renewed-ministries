package net.MyKanisa.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.MyKanisa.ui.auth.AuthViewModel
import net.MyKanisa.ui.auth.LoginScreen
import net.MyKanisa.ui.auth.SignupScreen
import net.MyKanisa.ui.communities.Communities
import net.MyKanisa.ui.communities.CommunitiesPage
import net.MyKanisa.ui.events.Event
import net.MyKanisa.ui.events.EventsPage
import net.MyKanisa.ui.home.HomeScreen
import net.MyKanisa.ui.splashScreen.splashScreen
import net.MyKanisa.ui.worship.WorshipTimesPage

@Composable
fun AppNavHost(
    viewModel: AuthViewModel,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUTE_SPLASH_SCREEN
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(ROUTE_LOGIN) {
            LoginScreen(viewModel, navController)
        }

        composable(ROUTE_SIGNUP) {
            SignupScreen(viewModel, navController)
        }

        composable(ROUTE_HOME) {
            HomeScreen(viewModel, navController)
        }

        composable(ROUTE_COMMUNITIES) {
            CommunitiesPage(communities = communities, onJoinClick = { communities -> communities.isJoined = !communities.isJoined } , navController, viewModel)
        }
        composable(ROUTE_WORSHIP) {
                WorshipTimesPage(navController, viewModel)
        }
        composable(ROUTE_EVENTS) {
               EventsPage(events = events, onEventClick = {}, navController, viewModel)
        }
        composable(ROUTE_SPLASH_SCREEN){
              splashScreen(navController)
        }
    }
}


val communities = listOf(
    Communities(
        name = "Prayer Group",
        description = "Join us in praying for one another",
        isJoined = false
    ),
    Communities(
        name = "Bible Study Group",
        description = "Study and discuss the Scriptures",
        isJoined = true
    ),
    Communities(
        name = "Youth Fellowship",
        description = "Engage in activities and fellowship",
        isJoined = false
    )
)

val events = listOf(
    Event(
        title = "Church Service",
        description = "Join us for Sunday service",
        date = "June 12, 2023, 10:00 AM"
    ),
    Event(
        title = "Bible Study",
        description = "Discuss and learn from the Scriptures",
        date = "June 15, 2023, 7:00 PM"
    ),
    Event(
        title = "Youth Group",
        description = "Engage in activities and fellowship",
        date = "June 18, 2023, 4:00 PM"
    )
)

