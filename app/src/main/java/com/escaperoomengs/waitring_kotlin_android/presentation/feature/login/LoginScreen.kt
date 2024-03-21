package com.escaperoomengs.waitring_kotlin_android.presentation.feature.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.escaperoomengs.waitring_kotlin_android.R
import com.escaperoomengs.waitring_kotlin_android.presentation.base.component.BaseBottomButton

@Composable
fun LoginScreen() {

    val viewModel : LoginViewModel = hiltViewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LoginView(id= uiState.id, pw = uiState.pw)
}

@Composable
private fun LoginView(
    id: String?,
    pw: String?
){
    Scaffold(bottomBar = {
        Bottom(btnEnabled = !(id.isNullOrBlank() || pw.isNullOrBlank())) {
            //todo 로그인 동작
        }
    }) {
        Box(modifier = Modifier.padding(it)){

        }
    }
}

@Composable
private fun Top(){

}

@Composable
private fun Bottom(
    btnEnabled: Boolean,
    btnOnClick: ()->Unit
){
    BaseBottomButton(text = stringResource(id = R.string.login_title),
        enabled = btnEnabled, onClick = btnOnClick)
}

@Preview
@Composable
private fun TopPreview(){

}

@Preview
@Composable
private fun BottomPreview(){
    Bottom(true) {}
}

@Preview
@Composable
private fun LoginViewPreview(){
    LoginView(id= null, pw=null)
}