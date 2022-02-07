package com.y4n9b0.fp

// https://rosettacode.org/wiki/Y_combinator#Kotlin
//typealias Func<T, R> = (T) -> R
//fun <T, R> y(f: (Func<T, R>) -> Func<T, R>): Func<T, R> = { f(y(f))(it) }

// https://gist.github.com/jubinjacob19/99989899ddb2d8e1d1055730e6ecace4
fun <In, Out> y(f: ((In) -> Out) -> (In) -> Out): (In) -> Out = { f(y(f))(it) }

//fun factorial(f: (Int) -> Int) = { x: Int -> if (x <= 1) 1 else x * f(x - 1) }
//fun fibonacci(f: (Int) -> Int) = { x: Int -> if (x <= 2) 1 else f(x - 1) + f(x - 2) }
fun factorial(f: (Int) -> Int) = fun(x: Int) = if (x <= 1) 1 else x * f(x - 1)
fun fibonacci(f: (Int) -> Int) = fun(x: Int) = if (x <= 2) 1 else f(x - 1) + f(x - 2)

fun main() {
    print("Factorial(1..10) :  ")
    for (i in 1..10) print("${y(::factorial)(i)}  ")
    print("\nFibonacci(1..10) :  ")
    (1..10).map { "${y(::fibonacci)(it)}  " }.forEach(::print)
    println()
}

//[函数式编程的 Y Combinator 有哪些实用价值](https://www.zhihu.com/question/20115649/answer/14029761){:target="_blank"}
//https://zhidao.baidu.com/question/1692175573465734828.html
//https://blog.csdn.net/papamilk/article/details/53763830  lambda演算模型，alpha变换和beta规约