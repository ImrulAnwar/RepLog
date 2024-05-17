package com.imrul.replog.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.imrul.replog.ui.theme.Maroon70

@Composable
fun CustomIcon(
    painter: Painter,
    contentDescription: String,
    onClick: () -> Unit,
    padding: Dp = 10.dp,
    size: Dp = 24.dp,
) {
    Icon(
        painter = painter,
        contentDescription = contentDescription,
        tint = Maroon70,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onClick() }
            .padding(padding)
            .size(size)
    )
}