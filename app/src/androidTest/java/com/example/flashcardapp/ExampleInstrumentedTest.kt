﻿package com.example.flashcardapp

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.uiautomator.UiDevice
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.flashcardapp", appContext.packageName)
    }

}
@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    private lateinit var  scenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }

    @After
    fun tearDown() {
        scenario.close()
    }

    @Test
    fun rotation3times() {
        val device = UiDevice.getInstance(getInstrumentation())

        device.setOrientationLeft()
        device.setOrientationNatural()
        device.setOrientationRight()
        onView(withId(R.id.Num1)).check(matches(withText(R.string.hashtag)))

        //checks if the text stays the same after rotation
    }

    @Test
    fun testGenButOnlyOnce(){
        onView(withId(R.id.GenProbs)).perform(click())
        onView(withId(R.id.GenProbs)).check{view, _ ->
            assert(!view.isEnabled)
        }
    }
}