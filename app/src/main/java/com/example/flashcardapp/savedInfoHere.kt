package com.example.flashcardapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class savedInfoHere : ViewModel() {
    var count = 0
    var resultlist = mutableListOf<Boolean>()

    var submitted = false

    var userAnswer = 0

    var num1 = 0

    var num2 = 0

    var Symbol = ""

    var answer = 0

    //sees if the info has been changed before
    var changed = false

    fun updateVals(c: Int, rl: MutableList<Boolean>, sub: Boolean, ua: Int, n1: Int, n2: Int, s: String, ans: Int) {
        count = c
        resultlist = rl
        submitted = sub
        userAnswer = ua
        num1 = n1
        num2 = n2
        Symbol = s
        answer = ans
        changed = true
    }

}