package com.example.newsapp.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import com.example.newsapp.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title : Int?,
    modifier: Modifier = Modifier,
    canNavigateUp : Boolean,
    navigateUp : () -> Unit
){
    TopAppBar(
        title = {
            title?.let {
                Text(text = stringResource(id = title))
            }
        },
        modifier = modifier,
        colors =TopAppBarDefaults.mediumTopAppBarColors(
            containerColor =MaterialTheme.colorScheme.primaryContainer
        ),
        navigationIcon = {
            if(canNavigateUp){
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(id = R.string.back)
                    )
                }
            }
        }

    )

}