package com.rsschool.quiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Comunicator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        openFragment(1, 0)
    }

    private fun openFragment(indexFromFragment: Int, chosenAnswer: Int) {
        val fragment: Fragment = FragmentQuiz.newInstance(indexFromFragment, chosenAnswer)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment).commit()
    }

    override fun passData(previousChoose: Int, chosenAnswer: Int) {
        openFragment(previousChoose, chosenAnswer)
    }
}