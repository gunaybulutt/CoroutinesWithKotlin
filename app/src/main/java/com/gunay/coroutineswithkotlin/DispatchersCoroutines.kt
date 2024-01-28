package com.gunay.coroutineswithkotlin

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){

    //Dispatcher --- coroutine'leri hangi Thread üzerinde çalıştıracağımızı ayarlamamızı sağlar
    //Dispatcher.Default ---> CPU Intensive(cpu yoğun) işlemler için kullanılır - görsel işleme veya binlerce karşılaştırma işlemi
    //Dispatcher.IO ---> Input / OUTPUT, Networking --- internetten veri alma gönderme gibi işlemler
    //Dispatcher.Main ---> UI proccesing --- kullanıcı arayüzü yani kullanıcının göreceği işlemlerin yapıldığı yer
    //Dispatcher.Unconfined ---> Inherited Dispatcher --- çağrıldığı yerden miras alır


    runBlocking {
        launch(Dispatchers.Main) {
            println("Main Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO) {
            println("IO Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Default) {
            println("Default Thread : ${Thread.currentThread().name}")
        }
        launch(Dispatchers.Unconfined) {
            println("Unconfined Thread : ${Thread.currentThread().name}")
        }
    }

}