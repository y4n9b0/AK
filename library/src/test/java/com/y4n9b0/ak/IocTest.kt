package com.y4n9b0.ak

import org.junit.Test
import java.io.*

class IocTest {
    @Test
    fun ioc() {
        val reader: BufferedReader = ("/Users/bob/Desktop/iocTest.txt" to ::File to ::FileInputStream to ::InputStreamReader to ::BufferedReader).use {
            assert(it is BufferedReader)
            it
        }
        try {
            // reader should be closed.
            reader.read()
        } catch (e: Exception) {
            assert(e is IOException)
        }
    }
}
