package com.y4n9b0.ak

val Int.isOdd: Boolean
    get() = (this and 1) == 1

val Int.isEven: Boolean
    get() = (this and 1) == 0
