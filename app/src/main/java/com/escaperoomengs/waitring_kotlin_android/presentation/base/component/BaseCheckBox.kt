package com.escaperoomengs.waitring_kotlin_android.presentation.base.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BaseCheckBox(modifier: Modifier = Modifier,
                 isChecked: Boolean,
                 text: String? = null,
                 onCheckedChange: ()->Unit) {

    Row(horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically){
        CircleCheckBox(isChecked = isChecked,
            onChecked = onCheckedChange,
            modifier = modifier,
            checkedBackgroundColor = Color(0xFFFF3D00),
            unCheckedBackgroundColor = Color(0xFFD9D9D9))
        text?.let{ Text(it) }
    }
}

@Composable
fun CircleCheckBox(
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    onChecked: () -> Unit = {},
    checkedBackgroundColor: Color = MaterialTheme.colorScheme.primary,
    unCheckedBackgroundColor: Color = Color.LightGray,
    checkedIconColor: Color = Color.White,
    unCheckedIconColor: Color = Color.White
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .clickable { onChecked() }
            .background(
                color = if (isChecked) checkedBackgroundColor else unCheckedBackgroundColor,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Default.Check,
            contentDescription = null,
            modifier = Modifier.padding(3.dp),
            tint = if (isChecked) checkedIconColor else unCheckedIconColor
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BaseCheckBoxPreview(){
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        BaseCheckBox(isChecked = false, text = "checkbox") {}
        BaseCheckBox(isChecked = true, text = "checkbox") {}
    }
}