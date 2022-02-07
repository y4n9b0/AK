package com.y4n9b0.fp

infix fun <A, B, C> ((B) -> C).compose(f: (A) -> B): (A) -> C = { a -> this(f(a)) }

infix fun <A, B, C> ((A) -> B).andThen(f: (B) -> C): (A) -> C = { a -> f(this(a)) }

infix fun <A, B> (() -> A).andThen(f: (A) -> B): () -> B = { f(this()) }
