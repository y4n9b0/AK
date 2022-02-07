package com.y4n9b0.ak

fun <T> MutableList<in T>.copyFrom(array: Array<out T>) {
    val iterator = listIterator()
    array.forEach {
        if (iterator.hasNext()) {
            iterator.next()
            iterator.set(it)
        } else {
            iterator.add(it)
        }
    }
    while (iterator.hasNext()) {
        iterator.next()
        iterator.remove()
    }
}
