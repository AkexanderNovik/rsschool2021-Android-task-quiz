package com.rsschool.quiz

class DataValues {
    private companion object {
        const val FIRST_QUESTION = "To be, or not to be..."
        const val FIRST_QUESTION_FIRST_OPTION = "To be"
        const val FIRST_QUESTION_SECOND_OPTION = "Not to be "
        const val FIRST_QUESTION_THIRD_OPTION = "I don't know"
        const val FIRST_QUESTION_FORTH_OPTION = "It's not my problem"
        const val FIRST_QUESTION_FIFTH_OPTION = "that is the question"
        const val FIRST_QUESTION_CORRECT_ANSWER = FIRST_QUESTION_FIFTH_OPTION

        const val SECOND_QUESTION = "First question"
        const val SECOND_QUESTION_FIRST_OPTION = "sdf"
        const val SECOND_QUESTION_SECOND_OPTION = "2323"
        const val SECOND_QUESTION_THIRD_OPTION = "ytuutyutyu"
        const val SECOND_QUESTION_FORTH_OPTION = "!!!!!!!3"
        const val SECOND_QUESTION_FIFTH_OPTION = "^^^^^"
        const val SECOND_QUESTION_CORRECT_ANSWER = "77777"

        const val THIRD_QUESTION = "First question"
        const val THIRD_QUESTION_FIRST_OPTION = "2323"
        const val THIRD_QUESTION_SECOND_OPTION = "2323"
        const val THIRD_QUESTION_THIRD_OPTION = "2323"
        const val THIRD_QUESTION_FORTH_OPTION = "2323"
        const val THIRD_QUESTION_FIFTH_OPTION = "2323"
        const val THIRD_QUESTION_CORRECT_ANSWER = "2323"
    }

    val arrayFirstQuestion = listOf(
        FIRST_QUESTION,
        FIRST_QUESTION_FIRST_OPTION,
        FIRST_QUESTION_SECOND_OPTION,
        FIRST_QUESTION_THIRD_OPTION,
        FIRST_QUESTION_FORTH_OPTION,
        FIRST_QUESTION_FIFTH_OPTION,
        FIRST_QUESTION_CORRECT_ANSWER
    )

    val arraySecondQuestion = listOf(
        SECOND_QUESTION,
        SECOND_QUESTION_FIRST_OPTION,
        SECOND_QUESTION_SECOND_OPTION,
        SECOND_QUESTION_THIRD_OPTION,
        SECOND_QUESTION_FORTH_OPTION,
        SECOND_QUESTION_FIFTH_OPTION,
        SECOND_QUESTION_CORRECT_ANSWER
    )

}