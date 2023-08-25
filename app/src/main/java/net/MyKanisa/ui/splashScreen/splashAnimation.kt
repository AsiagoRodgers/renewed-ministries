package net.MyKanisa.ui.splashScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.*
import kotlinx.coroutines.delay
import net.MyKanisa.navigation.ROUTE_LOGIN


@Composable
fun LottieAnimationComponent(navController: NavHostController) {
    var animationProgress by remember { mutableStateOf(0f) }

    var animationStartTime by remember { mutableStateOf(0L) }
    val animationDurationMillis = 3000L // Replace with your desired duration in milliseconds


    LaunchedEffect(Unit) {
        animationStartTime = System.currentTimeMillis()
        while (animationProgress < 1f) {
            val elapsedTime = System.currentTimeMillis() - animationStartTime
            val progress = (elapsedTime / animationDurationMillis.toDouble()).coerceIn(0.0, 1.0)
            animationProgress = progress.toFloat()

            if (progress >= 0.5) {
                navController.navigate(ROUTE_LOGIN)
                break
            }
            delay(100)
        }
    }

}
