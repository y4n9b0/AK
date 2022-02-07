package com.y4n9b0.ak

inline fun <reified T> shuffle(list: MutableList<T>) {
    val shuffleThreshold = 5
    if (list.size < shuffleThreshold) {
        for (i in list.size - 1 downTo 0) {
            val random = (0..i).random()
            list[i] = list[random].also { list[random] = list[i] }
        }
    } else {
        list.copyFrom(list.toTypedArray().apply(::shuffle))
    }
}

fun <T> shuffle(array: Array<T>) {
    for (i in array.size - 1 downTo 0) {
        val random = (0..i).random()
        array[i] = array[random].also { array[random] = array[i] }
    }
}
