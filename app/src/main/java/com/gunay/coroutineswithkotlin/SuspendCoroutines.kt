package com.gunay.coroutineswithkotlin

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    //suspend fonksiyonlar ya başka bir suspend fonksiyon yada coroutines içinden çağrılabilirler direk adını yazıp çağıramassın
    GlobalScope.launch {
        println("globalScope")
        hello("globalScope")
    }


    //suspend fonksiyonlar ya başka bir suspend fonksiyon yada coroutines içinden çağrılabilirler direk adını yazıp çağıramassın
    runBlocking {
        //delay(2000)
        println("runBlocking")
        hello("runBlocking")
    }

}

//Suspend fonksiyon ----> içerisinde coroutines çalıştıralabilen fonksiyonlardır. bu fonksiyonlar istenildiği zaman durdurulup devam edilebilir(suspend edilebilir)
//suspend fonksiyonlar ya başka bir suspend fonksiyon yada coroutines içinden çağrılabilirler direk adını yazıp çağıramassın
//coroutineScope yanlızca bir coroutine içersinden yada suspend fonksiyonlar içerisinden çağrılabilir
suspend fun hello(where : String){
    coroutineScope {
        delay(5000)
        println("scope : " + where)
    }
}