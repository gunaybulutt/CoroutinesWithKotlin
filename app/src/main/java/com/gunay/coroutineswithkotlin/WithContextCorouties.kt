package com.gunay.coroutineswithkotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(){
    runBlocking {


        //bir launch içerinden farklı bir dispatcher'a sahip launch'a referans verilebilir
        //bu sayede aynı scope içerisinde farklı thread'ler üzerinde işlem yapılabilir
        //mesela default'ta bir işlem yapıp sonra başka bir thread üzerine geçilebilir aşşağıda default'tan io'ya geçilmiştir
        //bu işlem için withContext yapısı kullanılır
        launch(Dispatchers.Default) {

            //içinte bulunulan dispatcher gösterilir
            println("context: ${coroutineContext}")

            withContext(Dispatchers.IO) {
                println("context: ${coroutineContext}")
            }

        }


    }
}