package com.example.motos

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.MotosTheme
import com.example.motos.model.Motos
import com.example.motos.model.RepositorioMoto
import androidx.compose.ui.Modifier.Companion as Modifier1

@Composable
fun CardMotos(
    motos: Motos,
) {
    var expaned by remember {
        mutableStateOf(false)
    }
    val color by animateColorAsState(
        targetValue =
        if (expaned) {
            MaterialTheme.colorScheme.error
        } else MaterialTheme.colorScheme.primary
    )

    Card(
        modifier = Modifier
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .background(color = color)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
        ) {
            Row(
                modifier = Modifier.background(color = color)
            ) {
                Box() {
                    Image(
                        painter = painterResource(motos.imagemMoto),
                        contentDescription = null,
                        modifier = Modifier
                            .size(
                                dimensionResource(id = R.dimen.tamanho_imagem),
                            )
                            .padding(
                                dimensionResource(id = R.dimen.padding_small)
                            )
                            .clip(
                                MaterialTheme.shapes.small
                            ),
                        contentScale = ContentScale.Crop
                    )
                }
                Column() {
                    Text(
                        text = stringResource(motos.nomeMoto),
                        Modifier.padding(
                            top = dimensionResource(id = R.dimen.padding_small),
                            start = dimensionResource(id = R.dimen.padding_medium),
                        ),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.background
                    )
                    Text(
                        text = stringResource(motos.marcaMoto),
                        Modifier1.padding(
                            start = dimensionResource(id = R.dimen.padding_medium)
                        ),
                        color = MaterialTheme.colorScheme.primaryContainer
                    )
                }

                Spacer(Modifier1.weight(1f))
                IconeBotao(
                    onClick = { expaned = !expaned },
                    expaned = expaned
                )
            }

            if (expaned) {
                Column {
                    Text(
                        text = stringResource(motos.valorMoto),
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_medium),
                                bottom = dimensionResource(id = R.dimen.padding_small)
                            ),
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                    )
                    Text(
                        text = stringResource(id = R.string.pesquisa),
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_small),
                                bottom = dimensionResource(id = R.dimen.padding_small)
                            ),
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                    )
                    Text(
                        text = stringResource(id = R.string.combustivel),
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_small),
                                bottom = dimensionResource(id = R.dimen.padding_small)
                            ),
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                    )
                    Text(
                        text = stringResource(id = R.string.partida),
                        modifier = Modifier
                            .padding(
                                start = dimensionResource(id = R.dimen.padding_medium),
                                top = dimensionResource(id = R.dimen.padding_small),
                                bottom = dimensionResource(id = R.dimen.padding_small)
                            ),
                        color = MaterialTheme.colorScheme.tertiaryContainer,
                    )
                }
            }
        }
    }
}

@Composable
fun IconeBotao(
    onClick: () -> Unit,
    expaned: Boolean,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
    ) {
        Icon(
            imageVector = if (expaned) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.background
        )
    }
}

@Composable
fun ListaMoto(
    motos: List<Motos>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {
    LazyColumn(contentPadding = contentPadding) {
        items(motos) { motos ->
            CardMotos(
                motos = motos,
            )
        }
    }
}

@Preview
@Composable
fun PreviewCard() {
    MotosTheme {
        val moto = Motos(
            R.string.nome_moto1,
            R.string.marca_honda,
            R.drawable.honda_160,
            R.string.valor_1,
        )
        CardMotos(motos = moto)
    }
}

@Preview
@Composable
fun ListaItens() {
    MotosTheme {
        ListaMoto(motos = RepositorioMoto.motos)
    }
}