package com.example.chatapp.onboarding.ui

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.chatapp.R
import com.example.chatapp.base.component.ChatboxButton
import com.example.chatapp.ui.theme.ChatAppTheme

@Composable
fun OnboardingScreen(
    onSignUpClick: () -> Unit,
    onLogInClick: () -> Unit,
    onSignUpWithFacebookClick: () -> Unit,
    onSignUpWithGoogleClick: () -> Unit
) {
    val screenWidth: Int = LocalConfiguration.current.screenWidthDp
    val screenHeight: Int = LocalConfiguration.current.screenHeightDp
    val context = LocalContext.current as ComponentActivity

    DisposableEffect(key1 = Unit){
        context.enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.light(
                scrim = context.getColor(R.color.transparent),
                darkScrim = context.getColor(R.color.transparent)
            )
        )
        onDispose {  }
    }

    ChatAppTheme {
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.eerie_black))
                .verticalScroll(rememberScrollState())
        ) {
            Box(
                modifier = Modifier
                    .requiredHeight(screenHeight.dp)
                    .requiredWidth(screenWidth.dp)
                    .blur(radius = 148.dp)
                    .background(
                        brush = Brush.linearGradient(
                            0.0f to colorResource(id = R.color.eerie_black),
                            0.2f to colorResource(id = R.color.eerie_black),
                            0.3f to colorResource(id = R.color.maastricht_blue),
                            0.4f to colorResource(id = R.color.persian_indigo).copy(alpha = .5f),
                            0.6f to colorResource(id = R.color.persian_indigo),
                            0.8f to colorResource(id = R.color.persian_indigo).copy(alpha = .5f),
                            0.9f to colorResource(id = R.color.maastricht_blue),
                            1.0f to colorResource(id = R.color.eerie_black),
                            start = Offset(x = 0f, y = screenHeight * .24f),
                            end = Offset(x = screenWidth * 1.2f, y = screenHeight * 1.1f)
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp)
                    .windowInsetsPadding(WindowInsets.systemBars),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.padding(top = 22.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_chatbox_logo_white),
                        contentDescription = stringResource(id = R.string.chatbox_logo)
                    )
                    Text(
                        modifier = Modifier.padding(start = 6.dp),
                        text = stringResource(id = R.string.app_name),
                        color = colorResource(id = R.color.primary_white),
                        style = MaterialTheme.typography.titleMedium,
                        textAlign = TextAlign.Center
                    )
                }
                Text(
                    modifier = Modifier.padding(top = 43.dp),
                    text = getModifiedTitle(),
                    color = colorResource(id = R.color.primary_white),
                    style = MaterialTheme.typography.displayLarge.copy(
                        fontWeight = FontWeight.Normal
                    )
                )
                Text(
                    modifier = Modifier.padding(top = 20.dp),
                    text = stringResource(id = R.string.onboarding_content),
                    color = colorResource(id = R.color.grey_2),
                    style = MaterialTheme.typography.titleLarge.copy(
                        lineHeight = 26.sp
                    )
                )
                Row(
                    modifier = Modifier.padding(top = 38.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    IconItem(
                        icon = R.drawable.ic_facebook_icon,
                        contentDescription = stringResource(id = R.string.facebook_logo),
                        onClick = onSignUpWithFacebookClick
                    )
                    IconItem(
                        modifier = Modifier.padding(start = 22.dp),
                        icon = R.drawable.ic_google_icon,
                        contentDescription = stringResource(id = R.string.google_logo),
                        onClick = onSignUpWithGoogleClick
                    )
                }
                Row(
                    modifier = Modifier.padding(top = 30.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Separator()
                    Text(
                        modifier = Modifier.padding(horizontal = 15.dp),
                        text = stringResource(id = R.string.or).uppercase(),
                        color = colorResource(id = R.color.grey_3),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Separator()
                }
                ChatboxButton(
                    modifier = Modifier.padding(top = 30.dp),
                    onClick = onSignUpClick,
                    text = stringResource(id = R.string.sign_up_with_email),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.primary_white),
                        contentColor = colorResource(id = R.color.primary_vampire_black)
                    )
                )
                Row(
                    modifier = Modifier.padding(top = 46.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = stringResource(id = R.string.existing_account),
                        color = colorResource(id = R.color.grey_2),
                        style = MaterialTheme.typography.titleMedium
                    )
                    Text(
                        modifier = Modifier
                            .padding(start = 4.dp)
                            .clickable { onLogInClick() },
                        text = stringResource(id = R.string.log_in),
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = colorResource(id = R.color.primary_white),
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}


@Composable
private fun Separator() {
    Spacer(
        modifier = Modifier
            .width(132.dp)
            .height(1.dp)
            .background(colorResource(id = R.color.grey_2).copy(alpha = .2f))
    )
}

@Composable
private fun IconItem(
    modifier: Modifier = Modifier,
    @DrawableRes icon: Int,
    contentDescription: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .border(
                width = 1.dp,
                color = colorResource(id = R.color.grey_2),
                shape = CircleShape
            )
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

@Composable
private fun getModifiedTitle(): AnnotatedString {
    return buildAnnotatedString {
        append(stringResource(id = R.string.connect_friends))
        append(" ")
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold
            )
        ) {
            append(stringResource(id = R.string.easily_and_quickly))
        }
    }
}