package eu.tutorials.practiceapp

import android.annotation.SuppressLint
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.shape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.tutorials.practiceapp.ui.theme.Background
import eu.tutorials.practiceapp.ui.theme.BtnGreen
import eu.tutorials.practiceapp.ui.theme.Gray
import eu.tutorials.practiceapp.ui.theme.TextBlack
import eu.tutorials.practiceapp.ui.theme.TextGray
import eu.tutorials.practiceapp.ui.theme.TextGreen
import eu.tutorials.practiceapp.ui.theme.TextLightGray
import java.util.Date
import java.util.Locale


@Composable
fun HomeScreen() {


    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA)
    val date = Date()

    var yearState by remember { mutableStateOf(formatter.format(date).split("-").first()) }
    var monthState by remember { mutableStateOf(formatter.format(date).split("-")[1]) }
    var dayState by remember { mutableStateOf(formatter.format(date).split("-").last()) }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 20.dp, top = 77.dp, end = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "2024년 8월",
                modifier = Modifier
                    .size(width = 200.dp, height = 40.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            )
            Row() {
                Button(modifier = Modifier.size(width = 24.dp, height = 34.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Background,
                        contentColor = TextBlack,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.White
                    ),
                    onClick = { }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        tint = TextBlack,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(0.dp)
                            .fillMaxSize()
                    )
                }
                Spacer(modifier = Modifier.padding(8.dp))
                Button(modifier = Modifier.size(width = 24.dp, height = 34.dp),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Background,
                        contentColor = TextBlack,
                        disabledContainerColor = Color.White,
                        disabledContentColor = Color.White
                    ),
                    onClick = { /* 수정 */ }
                ) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        tint = TextBlack,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(0.dp)
                            .fillMaxSize()
                    )
                }
            }
        }
    }
    Column {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, top = 133.dp, end = 20.dp),
            horizontalArrangement = Arrangement.Center){
            Button(modifier = Modifier
                .size(width = 130.dp, height = 30.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gray,
                    contentColor = TextBlack,
                    disabledContainerColor = Color.White,
                    disabledContentColor = TextGreen
                ),
                onClick = { /* 주간 */ }
            ) {
                Text(text = "주간",
                    modifier = Modifier
                        .size(width = 35.dp, height = 20.dp)
                        .padding(0.dp),
                    style = TextStyle(
                        color = TextGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Button(modifier = Modifier
                .size(width = 130.dp, height = 30.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Gray,
                    contentColor = TextBlack,
                    disabledContainerColor = Color.White,
                    disabledContentColor = TextGreen
                ),
                onClick = { /* 월간 */ }
            ) {
                Text(text = "월간",
                    modifier = Modifier
                        .size(width = 35.dp, height = 20.dp)
                        .padding(0.dp),
                    style = TextStyle(
                        color = TextGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(top = 195.dp),
            horizontalArrangement = Arrangement.Center) {
            Button(modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 37.dp, height = 37.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextBlack,
                    disabledContainerColor = TextGreen,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 해당 날짜로 이동 */ }
            ) {
                Text(
                    text = "20",
                    modifier = Modifier
                        .size(width = 37.dp, height = 37.dp)
                        .padding(vertical = 7.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Button(modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 37.dp, height = 37.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextBlack,
                    disabledContainerColor = TextGreen,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 해당 날짜로 이동 */ }
            ) {
                Text(
                    text = "6",
                    modifier = Modifier
                        .size(width = 37.dp, height = 37.dp)
                        .padding(vertical = 7.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Button(modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 37.dp, height = 37.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextBlack,
                    disabledContainerColor = TextGreen,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 해당 날짜로 이동 */ }
            ) {
                Text(
                    text = "20",
                    modifier = Modifier
                        .size(width = 37.dp, height = 37.dp)
                        .padding(vertical = 7.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Button(modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 37.dp, height = 37.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextBlack,
                    disabledContainerColor = TextGreen,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 해당 날짜로 이동 */ }
            ) {
                Text(
                    text = "20",
                    modifier = Modifier
                        .size(width = 37.dp, height = 37.dp)
                        .padding(vertical = 7.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Button(modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 37.dp, height = 37.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextBlack,
                    disabledContainerColor = TextGreen,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 해당 날짜로 이동 */ }
            ) {
                Text(
                    text = "20",
                    modifier = Modifier
                        .size(width = 37.dp, height = 37.dp)
                        .padding(vertical = 7.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Button(modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 37.dp, height = 37.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextBlack,
                    disabledContainerColor = TextGreen,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 해당 날짜로 이동 */ }
            ) {
                Text(
                    text = "20",
                    modifier = Modifier
                        .size(width = 37.dp, height = 37.dp)
                        .padding(vertical = 7.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
            Button(modifier = Modifier
                .padding(start = 5.dp, end = 5.dp)
                .size(width = 37.dp, height = 37.dp),
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextBlack,
                    disabledContainerColor = TextGreen,
                    disabledContentColor = Color.White
                ),
                onClick = { /* 해당 날짜로 이동 */ }
            ) {
                Text(
                    text = "20",
                    modifier = Modifier
                        .size(width = 37.dp, height = 37.dp)
                        .padding(vertical = 7.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }

    }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ){
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, top = 244.dp, end = 32.dp)
        ){
            Spacer(modifier = Modifier.padding(10.dp))
            Text(text = "일",
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .padding(0.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            )
            Spacer(modifier = Modifier.padding(11.dp))
            Text(text = "월",
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .padding(0.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                ))
            Spacer(modifier = Modifier.padding(11.dp))
            Text(text = "화",
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .padding(0.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                ))
            Spacer(modifier = Modifier.padding(11.dp))
            Text(text = "수",
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .padding(0.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                ))
            Spacer(modifier = Modifier.padding(11.dp))
            Text(text = "목",
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .padding(0.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                ))
            Spacer(modifier = Modifier.padding(11.dp))
            Text(text = "금",
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .padding(0.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                ))
            Spacer(modifier = Modifier.padding(11.dp))
            Text(text = "토",
                modifier = Modifier
                    .size(width = 25.dp, height = 25.dp)
                    .padding(0.dp),
                style = TextStyle(
                    color = TextBlack,
                    fontWeight = FontWeight.Medium,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                ))
        }
    }
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
        Canvas(modifier = Modifier.fillMaxSize()){
            val canvasWidth = size.width

            drawLine(
                start = Offset(x=0F, y = 800F),
                end = Offset(x = canvasWidth, y = 800F),
                color = TextLightGray,
                strokeWidth = 1F
            )
        }
    }
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 315.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top){
        LazyRowTegList(this@Column)
        }

    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 348.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top) {
        MyApp {
            AddTodoScreen()
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MaterialTheme {
        content()
    }
}

@Composable
fun dateBtn(){
    //val weekDate = listOf("#전체", "#건강", "#공부", "#취미", "#재태크", "#독서", "#커리어", "#생활습관")

    Button(modifier = Modifier
        .padding(start = 4.dp, end = 4.dp)
        .size(width = 37.dp, height = 37.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Background,
            contentColor = TextBlack,
            disabledContainerColor = TextGreen,
            disabledContentColor = Color.White
        ),
        onClick = { /* 해당 날짜로 이동 */ }
    ) {
        Text(
            text = "20",
            modifier = Modifier
                .size(width = 37.dp, height = 37.dp)
                .padding(0.dp),
            style = TextStyle(
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun LazyRowTegList(context: ColumnScope){
    val itemsIndexedTegLists = listOf("#전체", "#건강", "#공부", "#취미", "#재태크", "#독서", "#커리어", "#생활습관")

    LazyRow(
        modifier = Modifier
        .fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        contentPadding = PaddingValues(start = 19.dp, end = 19.dp)){
        items(itemsIndexedTegLists){
            Button(modifier = Modifier
                .size(width = 68.dp, height = 35.dp)
                .padding(4.dp),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, TextBlack),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Background,
                    contentColor = TextGray,
                    disabledContainerColor = BtnGreen,
                    disabledContentColor = TextGreen
                ),
                onClick = { /* 해당 태그로 이동 */ }
            ) {
                Text(
                    text = "$it",
                    modifier = Modifier
                        .size(width = 61.dp, height = 28.dp)
                        .padding(vertical = 3.dp),
                    style = TextStyle(
                        fontWeight = FontWeight.Medium,
                        fontSize = 12.sp,
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }

    }
}

    /*
@Composable
fun TodoList(
    todos: List<Todo>,
    onChange: (i: Int, todo: Todo) -> Unit,
    onDelete: (i: Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        itemsIndexed(items = todos) { i, todo ->
            TodoItem(
                item = todo,
                onChange = { onChange(i, it) },
                onDelete = { onDelete(i) }
            )
        }
    }
}

@Composable
fun TodoItem(item: Todo, onChange: (todo: Todo) -> Unit, onDelete: () -> Unit) {

    Column(modifier = Modifier
        .padding(horizontal = 6.dp, vertical = 20.dp)
        .fillMaxSize()
        .border(
            border = BorderStroke(1.dp, Color.White),
            shape = RoundedCornerShape(16)
        )
    ) {
        Row(modifier = Modifier
            .padding(start = 16.dp, end = 50.dp, top = 19.dp, bottom = 19.dp)
        ) {
            Column {
                Text(
                    text = item.text,
                    style = TextStyle(
                        color = TextBlack,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start
                    ),
                    textDecoration = if (item.done) {
                        TextDecoration.LineThrough
                    } else TextDecoration.None,
                    modifier = Modifier
                        .padding(bottom = 9.dp)
                )
                Text(
                    text = item.time,
                    style = TextStyle(
                        color = TextGreen,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Start
                    ),
                )
            }
            Checkbox(
                colors = CheckboxDefaults.colors(
                    checkedColor = TextGreen,
                    uncheckedColor = Color(0XFFcbc6c1),
                    checkmarkColor = Color.White
                ),
                modifier = Modifier.align(Alignment.CenterVertically),
                checked = item.done,
                onCheckedChange = { onChange(item.copy(done = it)) }
            )
        }
    }
}


@Composable
fun AddTodo() {
    var list: List<Todo> by rememberSaveable { mutableStateOf(listOf()) }

    fun addTodo(todo: Todo) {
        list = list + listOf(todo)
    }

    fun editTodo(i: Int, todo: Todo) {
        list = list.toMutableList().also { it[i] = todo }
    }

    Column {
        TodoList(
            list,
            onChange = { i, todo -> editTodo(i, todo) },
            onDelete = { }
        )
    }
}

/*
@Composable
fun DeleteDialog(
    showDialog: Boolean,
    setShowDialog: (Boolean) -> Unit,
    onConfirm: () -> Unit
) {
    if (!showDialog) return
    AlertDialog(
        onDismissRequest = { setShowDialog(false) },
        title = { Text(text = stringResource(R.string.delete_dialog_title)) },
        text = { Text(text = stringResource(R.string.delete_dialog_text)) },
        confirmButton = {
            Button(
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryColor),
                onClick = {
                    onConfirm()
                    setShowDialog(false)
                }) {
                Text(
                    text = stringResource(R.string.dialog_confirm),
                    color = MaterialTheme.colors.primaryColor
                )
            }
        },
        dismissButton = {
            Button(
                elevation = ButtonDefaults.elevation(defaultElevation = 0.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryColor),
                onClick = { setShowDialog(false) }) {
                Text(
                    text = stringResource(R.string.dialog_cancel),
                    color = MaterialTheme.colors.primaryColor
                )
            }
        }
    )
}



 */


     */