package gabyshev.denis.forecast.feature.select_city.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import gabyshev.denis.forecast.feature.select_city.R

@Composable
fun SearchCity(viewModel: SelectCityViewModel) {
    Box(Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.city_background),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),
            contentDescription = null
        )

        Column(modifier = Modifier
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                SearchCityField(viewModel)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchCityField(viewModel: SelectCityViewModel) {
    val textValue = remember { mutableStateOf(TextFieldValue("")) }
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .padding(1.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Row {
            Icon(
                painter = painterResource(id = R.drawable.magnify),
                contentDescription = null,
                modifier = Modifier
                    .background(Color.White)
                    .padding(vertical = 8.dp)
                    .padding(start = 16.dp),
                tint = Color(0xFF4285f4)
            )
            BasicTextField(
                value = textValue.value,
                onValueChange = { textValue.value = it },
                singleLine = true,
                modifier = Modifier
                    .background(Color.White)
                    .padding(vertical = 16.dp, horizontal = 8.dp),
                decorationBox = { innerTextField ->
                    if (textValue.value.text.isEmpty()) {
                        Text(
                            stringResource(id = R.string.search_city),
                            style = TextStyle(color = Color.Gray, fontSize = 16.sp),
                        )
                    }
                    innerTextField()
                },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(
                    onDone = {
                        keyboardController?.hide()
                        viewModel.onDoneButtonClicked(textValue.value.text)
                    }
                ),
                textStyle = MaterialTheme.typography.body1
            )
        }
    }
}