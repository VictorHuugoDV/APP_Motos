package com.example.motos.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.motos.R

data class Motos(
    @StringRes val nomeMoto:Int,
    @StringRes val marcaMoto: Int,
    @DrawableRes val imagemMoto:Int,
    @StringRes val valorMoto:Int,
)
object RepositorioMoto{
    val motos= listOf<Motos>(
        Motos(R.string.nome_moto1,R.string.marca_honda,R.drawable.honda_160,R.string.valor_1),
        Motos(R.string.nome_moto2,R.string.marca_honda,R.drawable.bis_125,R.string.valor_2),
        Motos(R.string.nome_moto3,R.string.marca_honda,R.drawable.nxr_160,R.string.valor_3),
        Motos(R.string.nome_moto4,R.string.marca_honda,R.drawable.pop_110,R.string.valor_4),
        Motos(R.string.nome_moto5,R.string.marca_honda,R.drawable.twister,R.string.valor_5),
        Motos(R.string.nome_moto6,R.string.marca_yamaha,R.drawable.fazer_250,R.string.valor_6),
        Motos(R.string.nome_moto7,R.string.marca_yamaha,R.drawable.mt_03,R.string.valor_7),
        Motos(R.string.nome_moto8,R.string.marca_yamaha,R.drawable.lander,R.string.valor_8),
        Motos(R.string.nome_moto9,R.string.marca_yamaha,R.drawable.r15,R.string.valor_9),
        Motos(R.string.nome_moto10,R.string.marca_honda,R.drawable.honda_adv,R.string.valor_10),
        Motos(R.string.nome_mot11,R.string.marca_honda,R.drawable.cb_600,R.string.valor_11),
        Motos(R.string.nome_mot12,R.string.marca_honda,R.drawable.xre,R.string.valor_12)
    )
}
