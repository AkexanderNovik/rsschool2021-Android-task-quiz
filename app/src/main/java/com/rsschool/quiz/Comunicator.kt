package com.rsschool.quiz

interface Comunicator {


    fun passData(previousChoose: Int, chosenAnswer: Int, i: Int, text: String)
}