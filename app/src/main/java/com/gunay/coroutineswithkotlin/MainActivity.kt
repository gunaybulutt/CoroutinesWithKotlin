package com.gunay.coroutineswithkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //coroutines light weightness bir yapıdır ve thread'lere gore daha verimlidir
        //scope = kapsam
        //scope nerede coroutines'in çalıştırılacağını belirleyen ve yasam döngüsünü belirleyen yapıdır
        //GlobalScope --> bütün uygulama içeriinde çalıştırabileceğimiz bir kapsamda çalışır
        println("globalScope start")
        GlobalScope.launch {
            delay(10000)
            println("globalScope")
        }
        println("globalScope end")

        /* GlobalScope.launch {
             repeat(100000){
                 launch {
                     println("android")
                 }
             }
         }*/


        //runBlocking ---> içerisindeki coroutines işlemleri bitene kadar sonrasındaki işlemlerin çalışmasını engeller
        //CoroutineScope --> içerisindeki coroutine'ler bitene kadar çalışmaya devam eder
        //launch coroutine başlatma kelimesidir
        //delay geciktirici ---> içindeki değeri milisaniye cinsinden geciktirir
        println("runBlocking start")
        runBlocking {
            delay(5000)
            launch {
                println("runBlocking")
            }
        }
        println("runBlocking finish")



        //coroutineScope yanlızca bir coroutine içersinden yada suspend fonksiyonlar içerisinden çağrılabilir fakat büyük C ile Coroutine şeklinde yazarak
        // herhangibir yapı içinden olmadan çağrılabilir ama tanımlanma sırasında context kısmında activity context'i değil coroutine context verilmesi gerekiyor
        //CoroutineScope'un GlobalScope'tan farkı hangi threadlerde çalışabileceğine kadar karar verebilmemiz globalScope'ta heryerde çalışıyor
        println("coroutineScope start")
        CoroutineScope(Dispatchers.Default).launch {
            delay(10000)
            println("coroutineScope")
        }
        println("coroutineScope end")







    }
}