package com.jhonjto.co.myplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main_2.*

class MainActivity : AppCompatActivity(), Logger, CanWalk {
    private val adapter = MediaAdapter(MediaProvider.data) { (title) -> toast(title) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_2)

        //button.setOnClickListener { showToast("${message.text}" ) }

        recycler.adapter = adapter

        d("Hello")
        toast("Hello from extensions", length = Toast.LENGTH_LONG)
        applicationContext.toast("Hello with context")

        val myLazyVal by lazy { Log.d("", "") }

/*        val adapter = MediaAdapter { (title) -> toast(title) }
        recycler.adapter = adapter
        adapter.items = getMedia()*/
        //recyclerView.adapter = MediaAdapter(getMedia()) { (title) -> toast(title) }
        //recycler.adapter = MediaAdapter(getMedia()) { mediaItem -> toast(mediaItem.title) }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        adapter.items = MediaProvider.data.let { media ->
            when (item.itemId) {
                R.id.filter_all -> media
                R.id.filter_photos -> media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos -> media.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }
        }

        return true
    }
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