package com.escaperoomengs.waitring_kotlin_android.presentation.base.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun BaseTextField(value: String, onValueChange: (String) -> Unit, placeholder: String?) {
    TextField(
        value = value, onValueChange = onValueChange,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { placeholder?.let { Text(text = placeholder) } }
    )
}