package com.krivosheev.mikhail.demoapp

import android.view.View
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed

import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import androidx.test.platform.app.InstrumentationRegistry
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleInstrumentedTest {


    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun activityShouldShowAppropriateText() {

        val testingText = "HelloPostResume"

        onView(withId(R.id.textViewHello)).check(matches(withText(testingText)))

        onView(withId(R.id.btnClick)).perform(click())
        onView(withId(R.id.textViewHello)).check(matches(withText("NEW TEXT")))

        with(activityRule.activity) {
            runOnUiThread {
                InstrumentationRegistry.getInstrumentation().callActivityOnPause(this)
                InstrumentationRegistry.getInstrumentation().callActivityOnStop(this)
                InstrumentationRegistry.getInstrumentation().callActivityOnStart(this)
                InstrumentationRegistry.getInstrumentation().callActivityOnResume(this)
            }
        }

       onView(withId(R.id.textViewHello)).check(matches(withText(testingText)))
    }
}
