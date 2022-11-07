package com.pedro.cards_list.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.pedro.cards_list.R
import com.pedro.cards_list.domain.model.CardsListModel
import com.pedro.cards_list.presentation.event.CardsListScreenEvent
import com.pedro.cards_list.presentation.viewmodel.CardsListViewModel
import com.pedro.designsystem.components.CustomDialog
import org.koin.androidx.compose.getViewModel

@Composable
fun CardsListScreen(
    viewModel: CardsListViewModel = getViewModel(),
    onItemCLick: (String) -> Unit
) {
    val state = viewModel.state.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(5.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.retry1),
                contentDescription = "retry",
                modifier = Modifier
                    .clickable { viewModel.onEvent(CardsListScreenEvent.OnRetry) }
                    .fillMaxHeight()
            )
        }

        when {
            state.value.loading -> {
                OnLoadingStateComposable()
            }

            state.value.error -> {
                OnErrorStateComposable(viewModel = viewModel)
            }

            state.value.cardsList.isNotEmpty() -> {
                OnSuccessStateComposable(list = state.value.cardsList, onItemCLick = onItemCLick)
            }
        }
    }
}

@Composable
private fun OnLoadingStateComposable() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun OnErrorStateComposable(viewModel: CardsListViewModel) {
    CustomDialog(text = "Do you want to retry ?") {
        viewModel.onEvent(CardsListScreenEvent.OnRetry)
    }
}

@Composable
fun OnSuccessStateComposable(list: List<CardsListModel>, onItemCLick: (String) -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize()
        ) {
            items(items = list) { cardListModel ->
                CardItem(
                    imageUrl = cardListModel.img,
                    name = cardListModel.name
                ) {
                    onItemCLick(cardListModel.cardId)
                }
            }
        }
    }
}

@Composable
fun CardItem(imageUrl: String, name: String, onItemCLick: () -> Unit = {}) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(550.dp)
            .padding(8.dp)
            .clickable { onItemCLick() },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.fillMaxHeight()) {
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                placeholder = painterResource(id = R.drawable.loading),
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Gray
                            ),
                            startY = 900f
                        )
                    )
            )
            Text(
                text = name,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp),
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}
