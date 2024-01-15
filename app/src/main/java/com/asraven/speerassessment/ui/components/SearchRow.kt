package com.asraven.speerassessment.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun SearchRow(userName: String, userImage: String, userInfo: String){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .border(1.dp, color = MaterialTheme.colorScheme.onSurface, RoundedCornerShape(4.dp))
    ) {
        appAsyncImage(logo = userImage)

        Text(
            userName
        )
        Spacer(Modifier.weight(1f))

    }

}



@Preview
@Composable
fun SearchRowPreview(){

}


@Composable
fun appAsyncImage(
    logo: String?,
    modifier: Modifier = Modifier
        .size(width = 27.dp, height = 20.dp)
        .clip(RoundedCornerShape(2.dp)),
    contentDescription : String = "flag",
    contentScale: ContentScale = ContentScale.Inside,
){
    AsyncImage(
        model = logo,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
    )
}
