package com.example.chatapp.base.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CBSeparator(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textColor: Color
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(color = color)
        )
        Text(
            modifier = Modifier.padding(horizontal = 15.dp),
            text = text,
            color = textColor,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(
            modifier = Modifier
                .weight(1f)
                .height(1.dp)
                .background(color = color)
        )
    }
}