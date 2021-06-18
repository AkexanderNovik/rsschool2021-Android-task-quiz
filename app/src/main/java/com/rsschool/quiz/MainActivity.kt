package com.rsschool.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Comunicator {

    private lateinit var binding: ActivityMainBinding
    private var list = mutableListOf(0, 0, 0, 0, 0, 0)

    private var userAnswers = mutableListOf("", "", "", "", "", "")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        openFragment(1, list)
    }

    private fun openFragment(questionNumber: Int, list: MutableList<Int>) {

        val transaction = supportFragmentManager.beginTransaction()
        if (questionNumber != 6) {
            val fragment: Fragment = FragmentQuiz.newInstance(questionNumber, list)
            transaction.replace(R.id.container, fragment).commit()
        } else {
            transaction.replace(R.id.container, FragmentResult.newInstance(userAnswers)).commit()
        }
    }

    override fun passData(questionNumber: Int, chosenAnswer: Int, i: Int, text: String) {
        if (questionNumber == 0) {
            list.fill(0)
            userAnswers.fill("")
            openFragment(1, list)
        } else {
            list[questionNumber] = chosenAnswer
            userAnswers[questionNumber] = text
            openFragment(questionNumber + i, list)
        }
    }
}