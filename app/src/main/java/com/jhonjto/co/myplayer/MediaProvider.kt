package com.jhonjto.co.myplayer

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import kotlin.random.Random

/**
 * Created by jhon on 28/03/2020
 */
object MediaProvider {

    private const val thumbBase = "https://i.picsum.photos/id/"
    private val rnd = Random(1)

    private var data = emptyList<MediaItem>()

    private fun randomType() = rnd.nextInt(2).let {
        if (it == 0) MediaItem.Type.PHOTO else MediaItem.Type.VIDEO
    }

    fun dataAsync(type: String = "cats", f: (List<MediaItem>) -> Unit) = doAsync {
        if (data.isEmpty()) {
            data = dataSync(type)
        }
        uiThread {
            f(data)
        }
    }

    fun dataSync(type: String): List<MediaItem> {
        Thread.sleep(2000)
        return (230..240).map {
            MediaItem(
                it, "Title $it", "$thumbBase$it/200/200.jpg",
                if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO
            )
        }
    }
}