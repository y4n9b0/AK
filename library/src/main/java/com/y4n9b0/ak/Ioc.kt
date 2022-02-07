package com.y4n9b0.ak

infix fun <T , R> T.to(block: (T) -> R): R = block(this)
