package com.example.stack

class Stack(private val maxSize: Int) {

    private val stackArray = IntArray(maxSize)
    private var top = -1

    fun push(value: Int) {
        if (!isFull()) {
            top++
            stackArray[top] = value
        }
    }

    fun pop(): Int {
        if (!isEmpty()) {
            val poppedValue = stackArray[top]
            top--
            return poppedValue
        }
        return -1 // Or throw EmptyStackException
    }

    fun isEmpty(): Boolean {
        return top == -1
    }

    fun isFull(): Boolean {
        return top == maxSize - 1
    }

    fun search(value: Int): Int {
        for (i in 0..top) {
            if (stackArray[i] == value) {
                return i
            }
        }
        return -1
    }

    fun traverse(): String {
        val builder = StringBuilder()
        for (i in 0..top) {
            builder.append(stackArray[i]).append(" ")
        }
        return builder.toString()
    }

    fun clear() {
        top = -1
    }
}
