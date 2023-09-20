import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.foundation.ViewState
import com.example.pokemonapps.R
import com.example.pokemonapps.feature.detail.ui.model.UIPokemonDetail
import com.example.pokemonapps.feature.list.ui.viewmodel.PokemonListViewModel


@Composable
fun PokemonDetailScreen(
    viewModel: PokemonListViewModel,
    pokemonId: String,
    modifier: Modifier = Modifier
) {
    val pokemon by viewModel.pokemonDetailState.collectAsState()
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = Unit) {
        viewModel.getPokemonDetail(pokemonId)
    }

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedVisibility(visible = loading) {
            CircularProgressIndicator(
                modifier = Modifier.padding(16.dp)
            )
        }

        when (pokemon) {
            is ViewState.Loading -> {
                loading = true
            }

            is ViewState.Success -> {
                loading = false
                SuccessContent((pokemon as ViewState.Success<UIPokemonDetail>).data)
            }

            is ViewState.Failure -> {
                loading = false
                Toast.makeText(
                    LocalContext.current,
                    "There was an error while making the API call",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

@Composable
private fun SuccessContent(
    pokemon: UIPokemonDetail
) {
    Image(pokemon.urlImage)
    Spacer(modifier = Modifier.height(20.dp))

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = pokemon.name.replaceFirstChar { it.uppercase() },
            style = MaterialTheme.typography.h4,
        )
        Spacer(modifier = Modifier.width(16.dp))
    }
    Text(
        text = "Height: ${pokemon.height}",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.paddingFromBaseline(top = 16.dp)
    )
    Text(
        text = "Weight: ${pokemon.weight}",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier.paddingFromBaseline(8.dp)
    )
    Spacer(Modifier.height(16.dp))
    LazyRow( // This was initially a LazyHorizontalGrid but took too much space
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(pokemon.moves.take(3)) { move ->
            Text(
                text = move,
                modifier = Modifier
                    .background(Color(0xFFFFF176), shape = RoundedCornerShape(8.dp))
                    .padding(8.dp)
            )
        }
    }
    Row(
        Modifier
            .padding(16.dp)
            .border(2.dp, Color.Blue, RoundedCornerShape(32.dp))
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            pokemon.types.forEach {
                Text(
                    text = it,
                    style = MaterialTheme.typography.body1,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun Image(urlImage: String, modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.Center) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(urlImage)
                .crossfade(true)
                .build(),
            placeholder = painterResource(R.drawable.ic_photo), alpha = 0.45f,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = modifier
        )
    }
}