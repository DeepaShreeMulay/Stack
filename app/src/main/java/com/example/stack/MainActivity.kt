package com.example.stack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private val stack = Stack(10) // Initialize stack with size 10
    private lateinit var valueEditText: EditText
    private lateinit var bulkValueEditText: EditText
    private lateinit var searchEditText: EditText
    private lateinit var pushButton: Button
    private lateinit var popButton: Button
    private lateinit var bulkPushButton: Button
    private lateinit var searchButton: Button
    private lateinit var traverseButton: Button
    private lateinit var clearButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pushButton = findViewById(R.id.pushButton)
        valueEditText = findViewById(R.id.valueEditText)
        popButton = findViewById(R.id.popButton)
        bulkPushButton = findViewById(R.id.bulkPushButton)
        bulkValueEditText = findViewById(R.id.bulkValueEditText)
        searchButton = findViewById(R.id.searchButton)
        searchEditText = findViewById(R.id.searchEditText)
        traverseButton = findViewById(R.id.traverseButton)
        clearButton = findViewById(R.id.clearButton)

        pushButton.setOnClickListener {
            val value = valueEditText.text.toString().toIntOrNull()
            if (value != null) {
                if (stack.isFull()) {
                    showToast("Stack is full!")
                } else {
                    stack.push(value)
                    showToast("$value pushed onto stack")
                }
            } else {
                showToast("Please enter a valid number")
            }
        }

        popButton.setOnClickListener {
            if (stack.isEmpty()) {
                showToast("Stack is empty!")
            } else {
                val poppedValue = stack.pop()
                showToast("$poppedValue popped from stack")
            }
        }

        bulkPushButton.setOnClickListener {
            val values = bulkValueEditText.text.toString().split(",").mapNotNull { it.toIntOrNull() }
            for (value in values) {
                if (!stack.isFull()) {
                    stack.push(value)
                } else {
                    showToast("Stack is full!")
                    break
                }
            }
            showToast("Bulk values pushed onto stack")
        }

        searchButton.setOnClickListener {
            val searchValue = searchEditText.text.toString().toIntOrNull()
            if (searchValue != null) {
                val position = stack.search(searchValue)
                if (position != -1) {
                    showToast("$searchValue found at position $position in stack")
                } else {
                    showToast("$searchValue not found in stack")
                }
            } else {
                showToast("Please enter a valid number to search")
            }
        }

        traverseButton.setOnClickListener {
            val stackContent = stack.traverse()
            showToast("Stack contents: $stackContent")
        }

        clearButton.setOnClickListener {
            stack.clear()
            showToast("Stack cleared")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
