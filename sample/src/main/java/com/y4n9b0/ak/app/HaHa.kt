package com.y4n9b0.ak.app

import com.y4n9b0.fp.curry


private fun foo(a: Int, b: Int, c: Int): Int {
    return a + 10 * b + 100 * c
}

fun curry(){
    val curry = ::foo.curry()
    println("curry=${curry(5)(2)(0)}")
}