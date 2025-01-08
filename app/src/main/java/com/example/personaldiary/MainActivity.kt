package com.example.personaldiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

   class DiaryEntry (val date: String, val content: String)

    class MainActivity : AppCompatActivity() {

        private val diaryEntries = mutableListOf<DiaryEntry>()

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val dateInput: EditText = findViewById(R.id.dateInput)
            val contentInput: EditText = findViewById(R.id.contentInput)
            val saveButton: Button = findViewById(R.id.saveButton)
            val displayTextView: TextView = findViewById(R.id.displayTextView)

            saveButton.setOnClickListener {
                val date = dateInput.text.toString()
                val content = contentInput.text.toString()
                if (date.isNotEmpty() && content.isNotEmpty()) {
                    val entry = DiaryEntry(date, content)
                    diaryEntries.add(entry)
                    Toast.makeText(this, "Entry saved!", Toast.LENGTH_SHORT).show()
                    displayEntries(displayTextView)
                    dateInput.text.clear()
                    contentInput.text.clear()
                } else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }
        }

        private fun displayEntries(textView: TextView) {
            val entriesText = diaryEntries.joinToString(separator = "\n\n") { entry ->
                "Date: ${entry.date}\nContent: ${entry.content}"

            }
            textView.text = entriesText
        }
    }