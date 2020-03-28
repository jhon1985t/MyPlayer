package com.jhonjto.co.myplayer

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by jhon on 28/03/2020
 */
object MediaProvider {

    private const val thumbBase = "https://lorempixel.com/400/400/cats/"

    private var data = emptyList<MediaItem>()

    fun dataAsync(callback: (List<MediaItem>) -> Unit) {
        doAsync {
            if (data.isEmpty()) {
                Thread.sleep(2000)
                data = (1..10).map {
                    MediaItem(it,"Title $it", "$thumbBase$it",
                        if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO)
                }
            }
            uiThread {
                callback(data)
            }
        }
    }
}