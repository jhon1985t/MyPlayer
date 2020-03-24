package com.jhonjto.co.myplayer

import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by jhon on 8/03/2020
 */
data class MediaItem(val title: String, val thumbUrl: String, val type: Type) {

    fun test(list: List<MediaItem>) {
        for ((title, thumbUrl) in list) {
            print(title + "" + thumbUrl)
        }
    }

    fun test(type: Type) {
        when (type) {
            Type.PHOTO -> print("photo")
            Type.VIDEO -> print("video")
        }
    }

    fun test(view: View) {
        val stringType = when (view) {
            is TextView -> "textView"
            is ViewGroup -> "viewGroup"
            else -> "unknown"
        }
        val myInt = if (view is TextView) 20 else 0
    }
    enum class Type {
        PHOTO, VIDEO
    }
}