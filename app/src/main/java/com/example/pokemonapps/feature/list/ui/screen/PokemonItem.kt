package com.example.pokemonapps.feature.list.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokemonapps.R
import com.example.pokemonapps.feature.list.ui.model.UIPokemon
import com.example.pokemonapps.navigation.Route

@Composable
fun PokemonItem(
    pokemon: UIPokemon,
    navHostController: NavHostController
) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            .fillMaxWidth()
            .clickable {
                navHostController.navigate(Route.Detail.route + "/${pokemon.id}")
            },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        MovieTitle(
            pokemon.name,
            modifier = Modifier.weight(1f)
        )
        MovieImage(
            pokemon.urlImage,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(90.dp)
        )
    }
}

@Composable
fun MovieImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_photo), alpha = 0.45f,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )

}

@Composable
fun MovieTitle(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = title,
        maxLines = 2,
        style = MaterialTheme.typography.h6,
        overflow = TextOverflow.Ellipsis
    )
}