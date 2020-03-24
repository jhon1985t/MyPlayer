package com.jhonjto.co.myplayer

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

/**
 * Created by jhon on 21/03/2020
 */
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun RecyclerView.ViewHolder.toast(message: String) = itemView.context.toast(message)

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(
        layoutRes,
        this,
        false
    )
}

fun ImageView.loadUrl(url: String) {
    Picasso.with(context).load(url).into(this)
}

inline fun <reified T: View> View.find(idRes: Int): T {
    return findViewById(idRes) as T
}

inline fun <reified T: View> RecyclerView.ViewHolder.find(idRes: Int): T {
    return itemView.find(idRes) as T
}

inline fun <reified T: Activity> Context.startActivity() {
    startActivity(Intent(this, T::class.java))
}