package com.jhonjto.co.myplayer

/**
 * Created by jhon on 23/03/2020
 */
interface Callback {
    fun onCallback(result: String)
}

fun doAsync(x: Int, callback: Callback){
    // Background
    callback.onCallback("finished")
}

fun doAsync2(x: Int, callback: (String) -> Unit) {
    // Background
    callback.invoke("finished")
}

fun test2() {
    doAsync(20, object : Callback {
        override fun onCallback(result: String) {
            print(result)
        }
    })

    doAsync2(20) { result -> print(result) }
}

fun test() {
    val f: (Int, Int) -> Int = { a, b -> a + b }

    val sum = { a: Int, b: Int -> a + b }
    applyOp(2, 3, sum) //5

    val mul = { a: Int, b: Int -> a * b }
    applyOp(2, 3, mul) //6

    applyOp(2, 3) { x, y -> x - y }
}

fun applyOp(x: Int, y: Int, f: (Int, Int) -> Int): Int = f(x, y)