package com.jhonjto.co.myplayer

/**
 * Created by jhon on 8/03/2020
 */
open class Person(name: String, val age: Int) {

    var name: String = name
    get() = "Name: $field"
    set(value) {
        if (value != field) {
            field = value
        }
    }

/*    fun test(list: List<MediaItem>) {
        for ((name, age) in list) {
            print(name + "" + age)
        }
    }*/
}