package com.example.android.testing.espresso.BasicSample

import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.platform.app.InstrumentationRegistry
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

    @Test
    fun testOpenActivityChangeTextButton() {
        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val editText = activity.findViewById<EditText>(R.id.editTextUserInput)
            val openActivityButton = activity.findViewById<Button>(R.id.activityChangeTextBtn)

            editText.setText("123")
            openActivityButton.performClick()
        }

        val context = InstrumentationRegistry.getInstrumentation().targetContext
        val intent = ShowTextActivity.newStartIntent(context, "123")
        ActivityScenario.launch<ShowTextActivity>(intent).onActivity { showTextActivity ->
            val showTextView = showTextActivity.findViewById<TextView>(R.id.show_text_view)
            assertEquals("123", showTextView.text.toString())
        }

        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val editText = activity.findViewById<EditText>(R.id.editTextUserInput)
            val openActivityButton = activity.findViewById<Button>(R.id.activityChangeTextBtn)

            editText.setText("abcdef")
            openActivityButton.performClick()
        }

        val intent2 = ShowTextActivity.newStartIntent(context, "abcdef")
        ActivityScenario.launch<ShowTextActivity>(intent2).onActivity { showTextActivity ->
            val showTextView = showTextActivity.findViewById<TextView>(R.id.show_text_view)
            assertEquals("abcdef", showTextView.text.toString())
        }

        ActivityScenario.launch(MainActivity::class.java).onActivity { activity ->
            val editText = activity.findViewById<EditText>(R.id.editTextUserInput)
            val openActivityButton = activity.findViewById<Button>(R.id.activityChangeTextBtn)

            editText.setText("")
            openActivityButton.performClick()
        }

        val intent3 = ShowTextActivity.newStartIntent(context, "")
        ActivityScenario.launch<ShowTextActivity>(intent3).onActivity { showTextActivity ->
            val showTextView = showTextActivity.findViewById<TextView>(R.id.show_text_view)
            assertEquals("", showTextView.text.toString())
        }
    }

    @Test
    fun useAppContext() { // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.android.testing.espresso.BasicSample", appContext.packageName)
    }
}