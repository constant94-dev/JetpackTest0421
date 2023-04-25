package com.example.test0421

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize() /* 화면의 꽉 채우는 설정 */
                            .background(color = Color.Blue) /* 화면 배경색상 */
                            .padding(16.dp), /* 패딩 크기 */
                        horizontalAlignment = Alignment.CenterHorizontally, /* 가로 정렬 설정 */
                        verticalArrangement = Arrangement.SpaceBetween /* 세로 정렬 설정 */
                    ) { /* 수직 배열 */
                        Text("Hello")
                        Text("World")
                    }
                    /*Row {*//* 수평 배열 *//*
                        Text("Hello")
                        Spacer(Modifier.width(16.dp))
                        Text("World")
                    }*/

                }
            }
        }
    }
}

