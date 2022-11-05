package com.pedro.cards_details.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pedro.cards_details.domain.model.CardDetailModel.Companion.defaultCardDetail
import com.pedro.cards_details.presentation.state.CardsDetailScreenState
import com.pedro.cards_details.presentation.viewmodel.CardsDetailsViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun CardsDetailsScreen(
    viewModel: CardsDetailsViewModel = getViewModel(),
    itemId: String
) {

    val state = viewModel.state.collectAsState().value

    LaunchedEffect(key1 = true) {
        viewModel.getCardById(itemId = itemId)
    }

    when {
        (state.loading) -> {
            OnLoadingStateComposable()
        }

        (state.card != defaultCardDetail) -> {
            OnSuccessStateComposable(state = state)
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
private fun OnSuccessStateComposable(state: CardsDetailScreenState) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = state.card.img,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 0.5f
                    )
                )
        )
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.35f)
                .align(Alignment.BottomCenter)
                .background(Color.Black)
                .border(
                    shape = RoundedCornerShape(5.dp, 5.dp, 5.dp, 0.dp),
                    width = 2.dp,
                    color = Color.Gray
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp)
            ) {
                val card = state.card
                Text(text = "Name: ${card.name}", color = Color.LightGray)
                Text(text = "Locale: ${card.locale}", color = Color.LightGray)
                Text(text = "Race: ${card.race}", color = Color.LightGray)
                Text(text = "Rarity: ${card.rarity}", color = Color.LightGray)
            }
        }
    }
}
