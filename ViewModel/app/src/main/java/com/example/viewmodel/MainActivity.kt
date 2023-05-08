package com.example.viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodel.ui.theme.ViewModelTheme

class MainActivity : ComponentActivity() {
    // Jetpack Compose 를 사용하지 않는 기존 안드로이드에서 ViewModel 을 사용할 때 쓰는 방법
    /*private val viewModel by viewModels<MainViewModel>()*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel = viewModel<MainViewModel>()

            // 'remember' 는 기존의 데이터를 기억하게 하는 compose
           /* val data = remember {
                mutableStateOf("Hello")
            }*/

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = viewModel.data.value,
                    fontSize = 30.sp
                )
                Button(onClick = { viewModel.changeValue() }) {
                    Text(text = "변경")
                }
            }
        }
    }
}

class MainViewModel : ViewModel() {
    // ViewModel 에서 data 값을 MainActivity 에서도 값을 유지하는 이유는 LifeCycle 을 같이 가져가기 때문이다.
    // 또한, viewModel 을 외부에서 접근해서 사용하지 못하게 막아야한다.
    private val _data = mutableStateOf("Hello")
    val data: State<String> = _data // 외부에는 읽기전용으로만 공개한다.

    // 값을 수정하고 싶을 때는 함수로 제공한다.
    fun changeValue() {
        _data.value = "World"
    }
}