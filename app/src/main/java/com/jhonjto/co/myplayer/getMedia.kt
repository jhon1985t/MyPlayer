package com.jhonjto.co.myplayer

/**
 * Created by jhon on 23/03/2020
 */
private const val thumbBase = "https://lorempixel.com/400/400/cats/"

object MediaProvider {
    val data = (1..10).map {
        MediaItem(
            "Title $it",
            "${thumbBase}$it",
            if (it % 3 == 0) MediaItem.Type.PHOTO else MediaItem.Type.VIDEO
        )
    }
}

fun getMedia() = (1..10).map {
    MediaItem("Title $it", "${thumbBase}$it", if (it % 3 == 0) MediaItem.Type.PHOTO else MediaItem.Type.VIDEO)
/*listOf(
    MediaItem("Title 1", "${thumbBase}1", MediaItem.Type.PHOTO),
    MediaItem("Title 2", "${thumbBase}2", MediaItem.Type.PHOTO),
    MediaItem("Title 3", "${thumbBase}3", MediaItem.Type.VIDEO),
    MediaItem("Title 4", "${thumbBase}4", MediaItem.Type.PHOTO),
    MediaItem("Title 5", "${thumbBase}5", MediaItem.Type.PHOTO),
    MediaItem("Title 6", "${thumbBase}6", MediaItem.Type.VIDEO),
    MediaItem("Title 7", "${thumbBase}7", MediaItem.Type.VIDEO),
    MediaItem("Title 8", "${thumbBase}8", MediaItem.Type.PHOTO),
    MediaItem("Title 9", "${thumbBase}9", MediaItem.Type.PHOTO),
    MediaItem("Title 10", "${thumbBase}10", MediaItem.Type.VIDEO)*/
}

fun test(items: List<MediaItem>) {

    val urlList: List<String> = items
        .filter { it.type == MediaItem.Type.PHOTO }
        .sortedBy { it.title }
        .map { it.thumbUrl }

    val mutableList = mutableListOf(2, 3, 5)
    mutableList.add(4)
    mutableList.remove(2)
}