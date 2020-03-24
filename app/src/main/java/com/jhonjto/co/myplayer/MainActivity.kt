package com.jhonjto.co.myplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_2.*

class MainActivity : AppCompatActivity(), Logger, CanWalk {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        //button.setOnClickListener { showToast("${message.text}" ) }

        d("Hello")
        toast("Hello from extensions", length = Toast.LENGTH_LONG)
        applicationContext.toast("Hello with context")

        recycler.adapter = MediaAdapter(getMedia()) { mediaItem -> toast(mediaItem.title) }
        asyncOp(20) { result ->
            d(result)
        }

        val textView = TextView(this).apply2 {
            text = "Hello"
            textSize = 20f
        }
    }

    private fun showToast(message: String) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

    override fun doStep() = walk(5)
}

fun asyncOp(value: Int, callback: (result: String) -> Unit) {

}

fun <T> T.apply2(f: T.() -> Unit): T {
    this.f()
    return this
}

interface Logger {

    val tag: String
        get() = javaClass.simpleName

    fun d(message: String) = Log.d(tag, message)
}

interface CanWalk {

    fun doStep()

    fun walk(numSteps: Int) {
        (1..numSteps).forEach { _ -> doStep() }
    }
}