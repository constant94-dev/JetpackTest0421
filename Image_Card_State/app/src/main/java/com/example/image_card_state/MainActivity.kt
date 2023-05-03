package com.example.image_card_state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // 외부에서 발생한 이벤트를 기억해서 재사용하는 방법
            // 'rememberSaveable' 상태를 관리하는 함수
            var isFavorite by rememberSaveable {
                mutableStateOf(false)
            }
            // 외부에서 발생한 이미지카드 구성요소를 재사용하는 방법
            ImageCard(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp),
                isFavorite = isFavorite
            ) { favorite ->
                isFavorite = favorite
            }
        }
    }
}

@Composable
fun ImageCard(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    onTabFavorite: (Boolean) -> Unit
) {
    // 컴포즈에서 제공하는 remember 가 isFavorite 상수에 저장되는 Boolean 값을 관리해준다
    /*val isFavorite = remember {
        mutableStateOf(false)
    }*/

    // 'isFavorite' 사용할 때 델리게이터 형태를 사용할 수 있다
    // 'by' 를 사용해서 isFavorite 변수를 mutableStateOf 형태가 아닌 Boolean 형태를 사용하게 만들어
    // 사용시 'isFavorite.value' 로 찾지 않아도 된다
    // 아래 내용의 수동 설정이 필요하다
    // import androidx.compose.runtime.getValue
    // import androidx.compose.runtime.setValue
    // 'rememberSaveable' 은 화면을 회전했을 때 초기화되는 이벤트를 기억해주는 역할을 한다
    /*var isFavorite by rememberSaveable {
        mutableStateOf(false)
    }*/

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Box( // 박스 형태의 이미지를 넣는다
            modifier = Modifier.height(366.dp)
        ) {
            Image( // 영화 조커 포스터 이미지 요소
                painter = painterResource(id = R.drawable.joker_poster),
                contentDescription = "joker poster",
                contentScale = ContentScale.Crop
            )
            Box(
                // 부모 박스 내부의 새로운 박스를 넣는다
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.TopEnd,
            ) {
                IconButton(onClick = { // 아이콘 버튼을 클릭할 때 값을 반대로(true/false) 변경한다
                    /*isFavorite.value = !isFavorite.value*/
                    /*isFavorite = !isFavorite*/
                    onTabFavorite.invoke(!isFavorite)
                }) {
                    Icon( // 기본으로 제공하는 벡터 아이콘 요소
                        imageVector = if (/*isFavorite.value*/isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "favorite",
                        tint = Color.White
                    )
                }
            }
        }
    }
}