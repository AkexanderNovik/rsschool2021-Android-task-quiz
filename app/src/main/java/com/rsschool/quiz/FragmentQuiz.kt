package com.rsschool.quiz

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentQuizBinding


class FragmentQuiz : Fragment(R.layout.fragment_quiz) {
    private var viewBinding: FragmentQuizBinding? = null
//    private val binding get() = requireNotNull(viewBinding)
    private val binding get() = requireNotNull(viewBinding)
    private var indexOfQuestion = 1
    private var listener: Comunicator? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        viewBinding = FragmentQuizBinding.inflate(inflater, container, false)

        val view = binding.root

        return view
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var indexOfChosenAnswer = 0
        var text = ""
        var chosenAnswer = 0

        when (indexOfQuestion) {
            1 -> indexOfChosenAnswer = arguments?.getInt(FIRST_RESULT_KEY) ?: 0
            2 -> indexOfChosenAnswer = arguments?.getInt(SECOND_RESULT_KEY) ?: 0
            3 -> indexOfChosenAnswer = arguments?.getInt(THIRD_RESULT_KEY) ?: 0
            4 -> indexOfChosenAnswer = arguments?.getInt(FORTH_RESULT_KEY) ?: 0
            5 -> indexOfChosenAnswer = arguments?.getInt(FIFTH_RESULT_KEY) ?: 0
        }

        viewBinding?.toolbar?.title = "Question $indexOfQuestion"


        if (indexOfQuestion == 1) {
            viewBinding?.previousButton?.isEnabled = false
            viewBinding?.toolbar?.setNavigationIcon(null)


        }
        viewBinding?.nextButton?.isEnabled = false


        var list = mutableListOf<String>()

        when (indexOfQuestion) {
            1 -> list = DataValues().arrayFirstQuestion.toMutableList()
            2 -> list = DataValues().arraySecondQuestion.toMutableList()
            3-> list = DataValues().arrayThirdQuestion.toMutableList()
            4 -> list = DataValues().arrayFourthQuestion.toMutableList()
            5 -> list = DataValues().arrayFifthQuestion.toMutableList()
        }

        viewBinding?.question?.text = list[0]
        viewBinding?.optionOne?.text = list[1]
        viewBinding?.optionTwo?.text = list[2]
        viewBinding?.optionThree?.text = list[3]
        viewBinding?.optionFour?.text = list[4]
        viewBinding?.optionFive?.text = list[5]



        if (indexOfChosenAnswer != 0) {
            viewBinding?.radioGroup?.check(indexOfChosenAnswer)
            viewBinding?.nextButton?.isEnabled = true
            chosenAnswer = viewBinding?.radioGroup?.checkedRadioButtonId ?: 0

        }




//        if (viewBinding?.radioGroup?.checkedRadioButtonId !== -1) {
//            viewBinding?.nextButton?.isEnabled = true
//            chosenAnswer = viewBinding?.radioGroup?.checkedRadioButtonId ?: 0
//        }


        viewBinding?.radioGroup?.setOnCheckedChangeListener { _, _ ->

            if (viewBinding?.radioGroup?.checkedRadioButtonId !== -1) {
                viewBinding?.nextButton?.isEnabled = true
                chosenAnswer = viewBinding?.radioGroup?.checkedRadioButtonId ?: 0
            }
        }

        viewBinding?.nextButton?.setOnClickListener() {


            text = (view.findViewById(chosenAnswer) as RadioButton).text.toString()


            (activity as Comunicator)?.passData(indexOfQuestion , chosenAnswer, +1, text)



        }

        viewBinding?.previousButton?.setOnClickListener() {

            if (chosenAnswer != 0) text = (view.findViewById(chosenAnswer) as RadioButton).text.toString()
            (activity as Comunicator)?.passData(indexOfQuestion , chosenAnswer, -1, text)
        }





//

        viewBinding?.toolbar?.setNavigationOnClickListener {
            if (chosenAnswer != 0) text =
                (view.findViewById(chosenAnswer) as RadioButton).text.toString()
            (activity as Comunicator)?.passData(indexOfQuestion, chosenAnswer, -1, text)
        }
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

        fun newInstance(index: Int, list: MutableList<Int>): FragmentQuiz {
            val fragment = FragmentQuiz()
            fragment.indexOfQuestion = index
            val args = Bundle()
            args.putInt(FIRST_RESULT_KEY, list[1])
            args.putInt(SECOND_RESULT_KEY, list[2])
            args.putInt(THIRD_RESULT_KEY, list[3])
            args.putInt(FORTH_RESULT_KEY, list[4])
            args.putInt(FIFTH_RESULT_KEY, list[5])
            fragment.arguments = args
            return fragment
        }
    }
}