package com.example.chatapp.splash_screen.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.chatapp.R
import com.example.chatapp.ui.theme.ChatAppTheme

@Composable
fun SplashScreen() {
    ChatAppTheme {
        Box (
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.primary_white))
        ){
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box{
                    Image(
                        painter = painterResource(id = R.drawable.ic_chat_box_logo_background),
                        contentDescription = null
                    )
                    Image(
                        modifier = Modifier.padding(start = .9.dp),
                        painter = painterResource(id = R.drawable.ic_chat_box_logo),
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = stringResource(id = R.string.app_name),
                    color = colorResource(id = R.color.primary_black),
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontStyle = FontStyle.Italic,
                    )
                )
            }
        }
    }
}