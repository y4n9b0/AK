package com.y4n9b0.ak

import com.y4n9b0.ak.app.curry
import com.y4n9b0.fp.curry
import com.y4n9b0.fp.uncurry
import org.junit.Test

import org.junit.Assert.*
import kotlin.jvm.functions.FunctionN

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    private fun foo(a: Int, b: Int, c: Int, d: Int): Int {
        return a + 10 * b + 100 * c + 1000 * d
    }

    private fun bar(
        a: Int,
        b: Int,
        c: Int,
        d: Int,
        e: Int,
        f: Int,
        g: Int,
        h: Int,
        i: Int,
        j: Int,
        k: Int,
        l: Int,
        m: Int,
        n: Int,
        o: Int,
        p: Int,
        q: Int,
        r: Int,
        s: Int,
        t: Int,
        u: Int,
        v: Int,
        w: Int
    ): Int {
        return -1;
    }

    private fun baz(vararg i: Int): Int {
        return 0
    }

    @Test
    fun testCurrying() {
        val curry = ::foo.curry()
        val uncurry = curry.uncurry()
        val b1 = ::foo is Function1<*, *>
        val b2 = curry is Function1<*, *>
        val b3 = ::foo is FunctionN<*>
        val b4 = ::bar is FunctionN<*>
        val b5 = ::baz is FunctionN<*>
        val b6 = ::baz is Function1<*, *>
        println("b1=$b1 b2=$b2 b3=$b3 b4=$b4 b5=$b5 b6=$b6 foo.name=${::foo.name}")
        println("foo=${foo(9, 5, 2, 7)}  curry=${curry(9)(5)(2)(7)}")
        assertEquals(foo(9, 5, 2, 7), curry(9)(5)(2)(7))
        assertEquals(foo(9, 5, 2, 7), uncurry(9, 5, 2, 7))
        assertNotEquals(foo(9, 5, 2, 7), curry(1)(3)(1)(4))
        assertNotEquals(foo(9, 5, 2, 7), uncurry(1, 3, 1, 4))
    }
}