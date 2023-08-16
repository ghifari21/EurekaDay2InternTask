package com.gosty.palindrome

fun main() {
    println("Input String")
    val str = readLine()
    if (str != null) {
        val result = isPalindrome(str)
        if (result) {
            println("Palindrom")
        } else {
            println("Bukan Palindrom")
        }
    }
}

fun isPalindrome(input: String): Boolean {
    var reversedString = ""

    for (i in input.length - 1 downTo 0) {
        reversedString += input[i]
    }

    return input.run {
        equals(reversedString, true)
    }
}