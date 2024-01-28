package com.gunay.coroutineswithkotlin

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    var userName = ""
    var userAge = 0


    //örneğin 2 tane veri indirilecek (kullanıcı ad ve yaşı) bunların ne zaman indirileceği veya hepsi indikten sonra mı işlem yapılacağı gibi konular async kullanılarak ayarlanır
    //launch direk çalıştırır async cevap bekler
    runBlocking {

        val downloadedName = async {
            downloadName()
        }

        val downloadedAge = async {
            downloadAge()
        }

        //thread bloklanmadan önce diğer işlemlerin bitmesi beklenir böylece ikiside bittikten sonra işlem yapılır
        userName = downloadedName.await()
        userAge =  downloadedAge.await()

        println("${userName} : ${userAge}")

        /*
        launch {
            val downloadedName = downloadName()
            println(downloadedName)
        }

        launch {
            val downloadedAge = downloadAge()
            println(downloadedAge)

        }
        */

    }


}

suspend fun downloadName() : String{
    delay(2000)
    val userName = "Ali"
    println("username download")
    return userName
}

suspend fun downloadAge() : Int{
    delay(4000)
    val userAge = 32
    println("userAge download")
    return userAge
}