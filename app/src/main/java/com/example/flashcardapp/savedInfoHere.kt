package com.example.flashcardapp

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class savedInfoHere(private val savedStateHandle: SavedStateHandle): ViewModel() {
    var count : Int
        get() = savedStateHandle.get("hi") ?: 0
        set(value) = savedStateHandle.set("hi", value)
    var resultlist : MutableList<Boolean>
        get() = savedStateHandle.get("hi") ?: mutableListOf<Boolean>()
        set(value) = savedStateHandle.set("hi", value)

    var submitted : Boolean
        get() = savedStateHandle.get("hi") ?: false
        set(value) = savedStateHandle.set("hi", value)

    var userAnswer : Int
        get() = savedStateHandle.get("hi") ?: 0
        set(value) = savedStateHandle.set("hi", value)

    var num1 : Int
        get() = savedStateHandle.get("hi") ?: 69
        set(value) = savedStateHandle.set("hi", value)

    var num2 : Int
        get() = savedStateHandle.get("hi") ?: 0
        set(value) = savedStateHandle.set("hi", value)

    var Symbol : String
        get() = savedStateHandle.get("hi") ?: ""
        set(value) = savedStateHandle.set("hi", value)

    var answer : Int
        get() = savedStateHandle.get("hi") ?: 0
        set(value) = savedStateHandle.set("hi", value)

    //sees if the info has been changed before
    var changed: Boolean
        get() = savedStateHandle.get("hi") ?: false
        set(value) = savedStateHandle.set("hi", value)

    fun updateVals(c: Int, rl: MutableList<Boolean>, sub: Boolean, ua: Int, n1: Int, n2: Int, s: String, ans: Int) {
        count = c.toInt()
        resultlist = rl
        submitted = sub
        userAnswer = ua
        num1 = n1.toInt()
        num2 = n2
        Symbol = s
        answer = ans
        changed = true
    }

}