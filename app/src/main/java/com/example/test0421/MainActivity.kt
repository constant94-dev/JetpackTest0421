package com.example.test0421

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test0421.ui.theme.Test0421Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*
        * 앱의 UI 코드에서 Composable 함수를 호출한다.
        * 람다 표현식으로 실제 화면에 노출하는 코드
        * 기존 onCreate() 에서 setContentView(Int) 함수를 호출하던것이 setContent() 함수로 변경됨
        * */
        setContent {
            // 해당 프로젝트에서는 Theme.kt에 여러 테마에 필요한 정보를 정리하고, 컴포즈 UI 구현을 위한 코드 작성
            Test0421Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Yellow
                ) {
                    Greeting("Android API 13")
                }
            }
        }
    }
}

/*
* @Composable 어노테이션을 붙이게 되면 함수 안 다른 함수를 호출
* UI 계층 별 요구하는 컴포넌트 생성
* */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var isSelected by remember { mutableStateOf(false) }
    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Text(
        text = "Hello $name!",
        modifier = modifier
            .padding(24.dp)
            .background(color = backgroundColor)
            .clickable(onClick = { isSelected = !isSelected})
    )
}

/*
* @Preview 해석 그대로 IDE 에서 미리보기를 하기 위한 용도이다.
* */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Test0421Theme {
        Greeting("Preview Android API 13")
    }
}