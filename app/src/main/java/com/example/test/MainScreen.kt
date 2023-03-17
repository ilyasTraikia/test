package com.example.test

import android.util.Log
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.test.ui.theme.TestTheme








@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {

    var TextState by remember { mutableStateOf("Add a task")}



 Column(
   modifier = modifier
       .fillMaxWidth()
       .padding(
           start = 43.dp, end = 28.dp,
           top = 45.dp, bottom = 45.dp
       ),
     verticalArrangement = Arrangement.spacedBy(50.dp)
 ) {
     
     Row(
         modifier = Modifier.fillMaxWidth(),
         horizontalArrangement = Arrangement.SpaceBetween,
         verticalAlignment = Alignment.CenterVertically

     ) {
         BasicTextField(value = TextState,
             onValueChange = { newValue ->
                 TextState = newValue
             },
             maxLines = 1,
             modifier = Modifier.width(200.dp)
         )

         Button(onClick = {
             tasks.add(Task(tasks.lastIndex+2,TextState))
             Log.v("ADD","Added a task")
                          }, shape = RoundedCornerShape(10)) {
             Text(text = "ADD", fontStyle = FontStyle.Italic)
         }
     }



     LazyColumn(
         verticalArrangement = Arrangement.spacedBy(80.dp),
         contentPadding = PaddingValues(vertical = 20.dp)
     ) {
         items(tasks) { item ->
             TodoTask(text = item.text)
         }
     }















     
 }


}



//@Preview(showBackground = true, widthDp = 390, heightDp = 400)
@Composable
fun MainScreenPreview() {
    TestTheme {
         MainScreen()
    }
}



@Composable
fun TodoTask(
    modifier: Modifier = Modifier,
    text:String = "",
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically


    ) {

        Text(text=text)


        Row(
            horizontalArrangement = Arrangement.spacedBy(41.dp)
        ) {
            Image(painter = painterResource(id = R.drawable.edit),
                contentDescription = null,modifier = Modifier.width(21.dp).height(21.dp))
            Image(painter = painterResource(id = R.drawable.delete),
                contentDescription = null,modifier = Modifier.width(19.dp).height(23.dp))
        }

    }

}


data class Task(val id:Int,val text:String)

val tasks = mutableListOf<Task>(Task(1,"Task1")
    ,Task(2,"Task2"),Task(3,"Task3"),Task(4,"Task4"),
    Task(5,"Task5"),Task(6,"Task6"),Task(7,"Task7"),
    Task(8,"Task8"),Task(9,"Task9"),Task(10,"Task10"),
    Task(11,"Task11"),Task(12,"Task12"))





