package com.escaperoomengs.waitring_kotlin_android.presentation.base.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BaseBottomButton(icon: Int? = null,
                     text: String? = null,
                     enabled: Boolean = true,
                     onClick: ()->Unit) {
    Button(modifier = Modifier
        .fillMaxWidth()
        .height(80.dp),
        enabled = enabled,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFFF3D00),
            disabledContainerColor = Color(0xFFAFAFAF)
        ),
        onClick = onClick){
        icon?.let{
            Icon(painterResource(id = it), contentDescription = text)
        }
        text?.let{
            Text(it, color = Color.White)
        }
    }
}

@Preview
@Composable
fun BaseBottomButtonPreview(){
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        BaseBottomButton(text = "test", enabled = true) {}
        BaseBottomButton(text = "test", enabled = false) {}
    }

}