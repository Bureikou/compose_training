package jp.co.faith.playlog_android.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CountLabel(
    imageVector: ImageVector,
    count: Int,
    iconTint: Color,
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current,
) {

    Row (modifier = modifier){
        Icon(
            imageVector = imageVector,
            contentDescription = "Likes",
            tint = iconTint,
        )
        Spacer(modifier = Modifier.width(5.dp))
        Text(
            text = count.toString(),
            color = color,
            modifier = Modifier.align(Alignment.CenterVertically),
            style = MaterialTheme.typography.bodyMedium,
        )
    }
}

@Preview
@Composable
fun show_countLabel()
{
    CountLabel(imageVector = Icons.Default.Favorite, count = 100, iconTint = Color.Magenta)
}