package com.example.android.testing.espresso.BasicSample

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import org.junit.Assert.assertEquals
import org.junit.Test

class MainActivityInstrumentedTest {

    @Test
    fun testChangeTextButton() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val editText = activity.findViewById<EditText>(R.id.editTextUserInput)
            val textView = activity.findViewById<TextView>(R.id.textToBeChanged)
            val changeTextButton = activity.findViewById<Button>(R.id.changeTextBt)

            editText.setText("123")
            changeTextButton.performClick()
            assertEquals("123", textView.text.toString())

            editText.setText("abcdef")
            changeTextButton.performClick()
            assertEquals("abcdef", textView.text.toString())

            editText.setText("")
            changeTextButton.performClick()
            assertEquals("", textView.text.toString())
        }
    }
}