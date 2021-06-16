package com.rsschool.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Comunicator {

    private lateinit var binding: ActivityMainBinding
    private var list= mutableListOf<Int>(0,0,0,0,0,0)

    private var userAnswers = mutableListOf<String>("","","","","","")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list= mutableListOf<Int>(0,0,0,0,0,0)
        openFragment(1, list)
    }

    private fun openFragment(questionNumber: Int, list: MutableList <Int>) {
        val fragment: Fragment = FragmentQuiz.newInstance(questionNumber, list)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment).commit()
    }

    override fun passData(questionNumber: Int, chosenAnswer: Int, i: Int, text: String) {
        list[questionNumber] = chosenAnswer
        userAnswers[questionNumber] = text
        userAnswers
        userAnswers

        openFragment(questionNumber + i, list)
    }

    override fun onDestroy() {
        super.onDestroy()
        list
        userAnswers
    }
}