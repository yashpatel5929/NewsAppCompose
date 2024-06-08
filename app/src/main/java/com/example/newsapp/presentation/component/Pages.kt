package com.example.newsapp.presentation.component

import androidx.annotation.DrawableRes
import com.example.newsapp.R

data class Pages(
    val title : String,
    val description : String,
    @DrawableRes val image : Int
)

val pages = listOf<Pages>(
    Pages(
        title = "Lorem Ipsume dummy 1",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        image = R.drawable.image2
    ),
    Pages(
        title = "Lorem Ipsume dummy 2",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        image = R.drawable.image3
    ),
    Pages(
        title = "Lorem Ipsume dummy 3",
        description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book",
        image = R.drawable.image4
    )
)
