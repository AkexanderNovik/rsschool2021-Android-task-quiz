package com.rsschool.quiz

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentQuizBinding


class FragmentQuiz : Fragment(R.layout.fragment_quiz) {
    private var viewBinding: FragmentQuizBinding? = null
    private val binding get() = requireNotNull(viewBinding)
    private var indexOfQuestion = 1
    private var listener: Comunicator? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewBinding = FragmentQuizBinding.inflate(inflater, container, false)


        var indexOfChosenAnswer = 0

        when (indexOfQuestion) {
            1 -> indexOfChosenAnswer = arguments?.getInt(FIRST_RESULT_KEY) ?: 0
            2 -> indexOfChosenAnswer = arguments?.getInt(SECOND_RESULT_KEY) ?: 0
            3 -> indexOfChosenAnswer = arguments?.getInt(THIRD_RESULT_KEY) ?: 0
            4 -> indexOfChosenAnswer = arguments?.getInt(FORTH_RESULT_KEY) ?: 0
            5 -> indexOfChosenAnswer = arguments?.getInt(FIFTH_RESULT_KEY) ?: 0
        }




        if (indexOfQuestion == 1) viewBinding?.previousButton?.isEnabled = false
        viewBinding?.nextButton?.isEnabled = false





        var list = mutableListOf<String>()

        when (indexOfQuestion) {
            1 -> list = DataValues().arrayFirstQuestion.toMutableList()
            2 -> list = DataValues().arraySecondQuestion.toMutableList()
        }

        viewBinding?.question?.text = list[0]
        viewBinding?.optionOne?.text = list[1]
        viewBinding?.optionTwo?.text = list[2]
        viewBinding?.optionThree?.text = list[3]
        viewBinding?.optionFour?.text = list[4]
        viewBinding?.optionFive?.text = list[5]

        var chosenAnswer = 0





        viewBinding?.radioGroup?.setOnCheckedChangeListener { _, _ ->

            if (viewBinding?.radioGroup?.checkedRadioButtonId !== -1) {
                viewBinding?.nextButton?.isEnabled =
                    true
                chosenAnswer = viewBinding?.radioGroup?.checkedRadioButtonId ?: 0
            }
        }

        viewBinding?.nextButton?.setOnClickListener() {
//            viewBinding?.radioGroup?.clearCheck()
//            it.isEnabled = false


            val arg = Bundle()
            when (indexOfQuestion) {
                1 -> arg.putInt(FIRST_RESULT_KEY, chosenAnswer)
                2 -> arg.putInt(SECOND_RESULT_KEY, chosenAnswer)
                3 -> arg.putInt(THIRD_RESULT_KEY, chosenAnswer)
                4 -> arg.putInt(FORTH_RESULT_KEY, chosenAnswer)
                5 -> arg.putInt(FIFTH_RESULT_KEY, chosenAnswer)
            }
            this.arguments = arg


            (activity as Comunicator)?.passData(indexOfQuestion + 1, chosenAnswer)
        }

        viewBinding?.previousButton?.setOnClickListener() {
            (activity as Comunicator)?.passData(indexOfQuestion - 1, chosenAnswer)
        }


        val view = binding.root

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = activity as MainActivity
    }


    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    companion object {

        private const val FIRST_RESULT_KEY = "FIRST_RESULT"
        private const val SECOND_RESULT_KEY = "SECOND_RESULT"
        private const val THIRD_RESULT_KEY = "THIRD_RESULT"
        private const val FORTH_RESULT_KEY = "FORTH_RESULT"
        private const val FIFTH_RESULT_KEY = "FIFTH_RESULT"

        fun newInstance(index: Int, chosenAnswer: Int): FragmentQuiz {
            val fragment = FragmentQuiz()
            fragment.indexOfQuestion = index
//            val args = Bundle()
//            when (index) {
//                1 -> args.putInt(FIRST_RESULT_KEY, chosenAnswer)
//                2 -> args.putInt(SECOND_RESULT_KEY, chosenAnswer)
//                3 -> args.putInt(THIRD_RESULT_KEY, chosenAnswer)
//                4 -> args.putInt(FORTH_RESULT_KEY, chosenAnswer)
//                5 -> args.putInt(FIFTH_RESULT_KEY, chosenAnswer)
//            }
//            fragment.arguments = args
            return fragment

        }
    }

}