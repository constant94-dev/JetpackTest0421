package com.example.advancestate

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.*
import com.example.advancestate.ui.theme.AdvanceStateTheme


@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
        }
    }
}



@ExperimentalMaterial3Api
@Composable
private fun HomeScreen(viewModel: MainViewModel = viewModel()) {
    // 'text1' 변수는 'mutableState' 상태로 사용한다.
    val text1: MutableState<String> = remember {
        mutableStateOf("")
    }

    // 'by' 는 코틀린의 델리게이트 프로퍼티 기능을 활용해서 setter, getter 를 재정의 해놓은 것
    // 'text2' 변수는 'String' 상태로 사용한다.
    var text2: String by remember {
        mutableStateOf("")
    }

    // '구조분해'를 사용해 'text' 변수는 상수 값 'setText' 는 값을 변경하고 싶을 때 사용할 수 있다.
    val (text: String, setText: (String) -> Unit) = remember {
        mutableStateOf("")
    }

    // 기존 코드의 liveData 를 사용했다면 compose 에서 State 로 변환을 지원하고 있어 'observeAsState' 를 사용해 변환할 수 있다.
    val text3: State<String> = viewModel.liveData.observeAsState("")

    Column {
        Text(text = "Hello World")
        Button(onClick = {
            text1.value = "변경"
            print(text1.value)
            text2 = "변경"
            print(text2)
            setText(text)
            viewModel.changeValue("변경")
        }) {
            Text(text = "클릭")
        }
        TextField(value = text, onValueChange = setText)
    }
}

class MainViewModel : ViewModel() {
    private val _value = mutableStateOf("Hello World") // 'mutableStateof' 쓰기와 읽기가 가능하다
    val value: State<String> = _value // 'State' 읽기만 가능하다

    // 기존의 liveData 를 사용해 코드 했다면 아래와 같은 코드가 존재한다.
    private val _liveDate = MutableLiveData<String>()
    val liveData: LiveData<String> = _liveDate

    // 읽기만 가능한 ViewModel 의 value 는 별도의 함수를 만들어 해당 함수에서 변경해야한다.
    fun changeValue(value: String) {
        _value.value = value
    }
}