package com.gunay.coroutineswithkotlin

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking{
        launch {
            delay(5000)
            println("runBlocking")
        }

        //burada küçük c ile başladı çünkü başka bir coroutine içinde
        coroutineScope {
            launch {
                delay(3000)
                println("coroutineScope")
            }
        }
    }



}