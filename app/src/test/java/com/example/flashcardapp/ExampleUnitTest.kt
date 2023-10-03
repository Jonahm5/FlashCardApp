package com.example.flashcardapp

import android.widget.Button
import android.widget.TextView
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */


class ExampleUnitTest {
    @Test
    fun savedInfoInitializesCorrectly() {
        var newInfo = savedInfoHere()
        assertEquals(newInfo.count, 0)
        assertEquals(newInfo.resultlist.size, 0)
        assertEquals(newInfo.submitted, false)
        assertEquals(newInfo.userAnswer, 0)
        assertEquals(newInfo.num1, 0)
        assertEquals(newInfo.num2, 0)
        assertEquals(newInfo.Symbol, "")
        assertEquals(newInfo.answer, 0)
        assertEquals(newInfo.changed, false)
    }

    @Test
    fun generatorWorks() {
        var hi = savedInfoHere()
        var count = 100
        var resultlist = mutableListOf<Boolean>()
        var submitted = false
        var userAnswer = 100
        var num1 = 100
        var num2 = 100
        var Symbol = ""
        var answer = 100
        hi.updateVals(count, resultlist, submitted, userAnswer, num1, num2, Symbol, answer)

        assertEquals(hi.count, count)
        assertEquals(hi.resultlist, resultlist)
    }
}