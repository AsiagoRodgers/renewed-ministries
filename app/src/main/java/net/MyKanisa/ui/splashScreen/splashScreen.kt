package net.MyKanisa.ui.splashScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import net.MyKanisa.R
import net.MyKanisa.ui.theme.spacing

@Composable
fun splashScreen(navController: NavHostController){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
            ){
        Column {

            val spacing = MaterialTheme.spacing

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = spacing.medium),
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            LottieAnimationComponent(navController)
        }

    }
}

