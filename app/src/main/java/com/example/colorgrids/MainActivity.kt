package com.example.colorgrids

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.colorgrids.ui.theme.ColorGridsTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorGridsTheme {
                MyApp()
            }
        }
    }
}


@Composable
fun MyApp(modifier: Modifier = Modifier){

    LazyVerticalGrid(columns = GridCells.Adaptive(100.dp),
        contentPadding = PaddingValues(16.dp)
    ){
        items( 200){
            MyCard(it = it, modifier = modifier)
        }


    }


}

@Composable
fun MyCard(
    it : Int, modifier: Modifier
){
    Card(
        modifier
            .size(100.dp)
            .padding(6.dp),
        elevation = 10.dp,

        ){
        Box(
            modifier.fillMaxSize().background(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),)
            ),
            contentAlignment = Alignment.Center
        ){
            Text( text = it.toString(), fontSize = 22.sp)
        }

    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ColorGridsTheme {
        MyApp()
    }
}