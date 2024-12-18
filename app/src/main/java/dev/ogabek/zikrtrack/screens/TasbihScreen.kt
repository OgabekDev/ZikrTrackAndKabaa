package dev.ogabek.zikrtrack.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import dev.ogabek.zikrtrack.R
import dev.ogabek.zikrtrack.model.Tasbih
import dev.ogabek.zikrtrack.mvvm.viewmodel.TasbihViewModel
import dev.ogabek.zikrtrack.navigation.Graph
import dev.ogabek.zikrtrack.utils.*
import kotlin.random.Random

@Composable
fun TasbihScreen(
    navController: NavHostController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TasbihBackground()
        TasbihView(navController)

    }

}

@Composable
fun TasbihView(
    navController: NavHostController,
    viewModel: TasbihViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    LaunchedEffect(true) {
        viewModel.getList()
    }

    Column(
        modifier = Modifier
            .background(Color.Transparent)
            .padding(bottom = 70.dp)
    ) {

        TopBar(
            title = stringResource(R.string.tasbehlar),
        )

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (viewModel.isLoading.value) {
                Loading()
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        CreateTasbih {
                            if (it.length < 3) {
                                Toast.makeText(context, R.string.error_min_lenth, Toast.LENGTH_SHORT).show()
                            } else {
                                viewModel.create(Tasbih(id = Random.nextInt(), title = it))
                            }
                        }
                    }
                    viewModel.list.value.forEach { tasbih ->
                        item {
                            TasbihItem(
                                tasbih = tasbih,
                                onClick = {
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        "tasbih", it
                                    )
                                    navController.navigate(Graph.TASBIH)
                                },
                                onDeleteClick = {
                                    viewModel.delete(it)
                                },
                                modifier = Modifier
                                    .padding(top = if (viewModel.list.value.first().id == tasbih.id) 10.dp else 0.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}