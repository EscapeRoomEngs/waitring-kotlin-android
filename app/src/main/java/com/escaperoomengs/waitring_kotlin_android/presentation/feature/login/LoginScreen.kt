package com.escaperoomengs.waitring_kotlin_android.presentation.feature.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.escaperoomengs.waitring_kotlin_android.R
import com.escaperoomengs.waitring_kotlin_android.presentation.base.component.BaseBottomButton
import com.escaperoomengs.waitring_kotlin_android.presentation.base.component.BaseTextField

@Composable
fun LoginScreen() {

    val viewModel: LoginViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LoginView(id = uiState.id, pw = uiState.pw)
}

@Composable
private fun LoginView(
    id: String,
    pw: String
) {
    Scaffold(
        topBar = {
            Top()
        },
        bottomBar = {
            Bottom(btnEnabled = id.isNotBlank() && pw.isNotBlank()) {
                //todo 로그인 동작
            }
        }) {
        Box(modifier = Modifier.padding(it)) {
            Body(
                id = id, pw = pw
            )
        }
    }
}

@Composable
private fun Top() {

}

@Composable
private fun Body(id: String, pw: String) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Column {
            Text(text = stringResource(id = R.string.login_title))
            Text(
                text = stringResource(id = R.string.login_none_member),
                modifier = Modifier.padding(vertical = 16.dp)
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(24.dp)) {

            IdPwContent(
                title = R.string.login_id,
                value = id,
                placeholder = R.string.login_id_hint
            )

            IdPwContent(
                title = R.string.login_pw,
                value = pw,
                placeholder = R.string.login_pw_hint
            )

        }

    }
}

@Composable
private fun IdPwContent(
    title: Int,
    value: String,
    onValueChange: (String) -> Unit = {},
    placeholder: Int
) {
    Column {
        Text(text = stringResource(id = title), modifier = Modifier.padding(vertical = 8.dp))
        BaseTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = stringResource(id = placeholder)
        )
    }
}

@Composable
private fun Bottom(
    btnEnabled: Boolean,
    btnOnClick: () -> Unit
) {
    BaseBottomButton(
        text = stringResource(id = R.string.login_title),
        enabled = btnEnabled, onClick = btnOnClick
    )
}

@Preview
@Composable
private fun TopPreview() {

}

@Preview
@Composable
private fun BodyPreview() {
    Body(id = "", pw = "")

}

@Preview
@Composable
private fun BottomPreview() {
    Bottom(true) {}
}

@Preview
@Composable
private fun LoginViewPreview() {
    LoginView(id = "", pw = "")
}