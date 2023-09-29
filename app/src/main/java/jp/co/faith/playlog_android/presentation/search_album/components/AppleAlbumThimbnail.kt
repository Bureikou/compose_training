package jp.co.faith.playlog_android.presentation.search_album.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import jp.co.faith.playlog_android.domain.model.AppleAlbum


@Composable
fun AppleAlbumThumbnail(
    appleAlbum: AppleAlbum,
    onClick: (AppleAlbum) -> Unit,
) {
    Box(
        modifier = Modifier
            .background(Color.Black)
            .heightIn(min = 100.dp)
            .clickable { onClick(appleAlbum) },
        contentAlignment = Alignment.BottomCenter,
    ) {
//        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(10.dp),
        ) {
            AsyncImage(
                model = appleAlbum?.imageUrl,
                contentDescription = appleAlbum?.name,
                modifier = Modifier
                    .height(80.dp)
                    .width(80.dp)
                    .padding(10.dp),
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(10.dp),
            ) {
                Text(
                    text = appleAlbum?.name ?: "No Description",
                    color = Color.White,
                    style = MaterialTheme.typography.bodyLarge,
                )
                Text(
                    text = appleAlbum.artistName ?: "Unknown photographer",
                    color = Color.White,
                    style = MaterialTheme.typography.bodySmall,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
        }

    }
}

