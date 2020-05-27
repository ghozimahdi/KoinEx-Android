package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val data = arrayListOf("Nug", "Aldi", "Danu", "Aris")
        for (i in 0..5) {
            println(data.random())
        }

        assertEquals(4, 2 + 2)
    }
}
