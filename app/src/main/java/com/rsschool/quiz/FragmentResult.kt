package com.rsschool.quiz

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.rsschool.quiz.databinding.FragmentResultBinding
import kotlin.system.exitProcess

class FragmentResult : Fragment(R.layout.fragment_result) {
    private var viewBinding: FragmentResultBinding? = null
    private val binding get() = requireNotNull(viewBinding)
    private var indexOfQuestion = 0
    private lateinit var callback: OnBackPressedCallback
    private var listener: Comunicator? = null
    private lateinit var userAnswers: MutableList<String>
    private val correctAnswers = DataValues().arrayCorrectAnswers

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val result = calculatePercentageOfCorrectAnswers()
        val resultText = formResult()
        viewBinding?.resultTextTile?.text = result
        viewBinding?.resultText?.text = resultText


        viewBinding?.goBack?.setOnClickListener {
            listener?.passData(indexOfQuestion, indexOfQuestion, 0, "")
        }

        viewBinding?.close?.setOnClickListener {
            activity?.finishAndRemoveTask()
            exitProcess(0)
        }

        viewBinding?.share?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND).apply {
                data = Uri.parse("mailto:")
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, "Quiz result")
                putExtra(Intent.EXTRA_TEXT, "$result $resultText")
            }
            startActivity(intent)
        }


        callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                listener?.passData(indexOfQuestion, indexOfQuestion, 5, "")
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner, callback)
    }

    private fun calculatePercentageOfCorrectAnswers(): String {
        var numberOfCorrectAnswers = 0
        for (i in 1 until correctAnswers.size) {
            if (correctAnswers[i].compareTo(userAnswers[i]) == 0) {
                numberOfCorrectAnswers += 1
            }
        }
        return "Your result: ${(numberOfCorrectAnswers * 100 / 5)} %"
    }

    private fun formResult(): String{
        var formedResult = ""

        for (i in 1 until correctAnswers.size) {
            formedResult = formedResult.plus(
                "\n\n Question $i) \n" +
                        " Your answer: " + userAnswers[i]+"\n Correct answer: "+ correctAnswers[i])
        }
        return formedResult
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = activity as Comunicator
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
        callback.remove()
    }

    companion object {
        fun newInstance(list: MutableList<String>): FragmentResult {
            val fragment = FragmentResult()
            fragment.userAnswers = list
            return fragment
        }
    }
}