package com.gunay.coroutineswithkotlin

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    runBlocking {

        //launch'lar aslında bir job objesidir ve farklı şekillerde kullanılabilirler
        val myJob = launch {
            delay(2000)
            println("job")
            //launch içinde launch oluşturulabilir
            val secondJob = launch {
                println("job2")
            }
        }

        //oluşturduğumuz job'lara işlem yapabiliyoruz burada job --->
        // yani launch bittikten sonra yapılacak işlem yazılır
        myJob.invokeOnCompletion {
            println("my job end")
        }

        //myJob burada çalıştırılmayacaktır çünkü 2 sn delay arasında bu kod okunacak ve myJob iptal edilecek
        //myJob bşlıyacak fakat 2 sn beklerken bu kısım okunacak ve iptal edilecek bu sebeble
        // myJob içindeki secondJob'da iptal edilmiş olacak ama her türlü işlem bittiği için println("my job end") kodu çalışacak
        myJob.cancel()

    }


}