package com.y4n9b0.ak

import com.y4n9b0.fp.andThen
import com.y4n9b0.fp.compose
import org.junit.Assert
import org.junit.Test

class ComposeTest {
    @Test
    fun compose() {
        val isOdd = fun(x: Int) = x and 1 == 1
        val length = fun(s: String) = s.length
        val list = listOf("a", "ab", "abc")
        val expected = listOf("a", "abc")
        list.filter(isOdd compose length).forEachIndexed { index, s ->
            Assert.assertEquals(s, expected[index])
        }
        list.filter(length andThen isOdd).forEachIndexed { index, s ->
            Assert.assertEquals(s, expected[index])
        }
    }
}