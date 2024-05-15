package com.example.chatapp.base.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.chatapp.R


@Composable
fun CBAuthOptions(
    modifier: Modifier = Modifier,
    onFacebookBtnClick: () -> Unit,
    onGoogleBtnClick: () -> Unit,
    borderColor: Color = colorResource(id = R.color.grey_2)
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        AuthOptionsItem(
            icon = R.drawable.ic_facebook_icon,
            contentDescription = stringResource(id = R.string.facebook_logo),
            onClick = onFacebookBtnClick,
            borderColor = borderColor
        )
        AuthOptionsItem(
            modifier = Modifier.padding(start = 22.dp),
            icon = R.drawable.ic_google_icon,
            contentDescription = stringResource(id = R.string.google_logo),
            onClick = onGoogleBtnClick,
            borderColor = borderColor
        )
    }
}

@Composable
private fun AuthOptionsItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    contentDescription: String,
    onClick: () -> Unit,
    borderColor: Color
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .border(
                width = 1.dp,
                color = borderColor,
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable { onClick() }
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(end = 1.dp),
            painter = painterResource(id = icon),
            contentDescription = contentDescription
        )
    }
}