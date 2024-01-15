package com.asraven.speerassessment.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SearchRow(userName: String){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            userName
        )
    }

}



@Preview
@Composable
fun SearchRowPreview(){

}