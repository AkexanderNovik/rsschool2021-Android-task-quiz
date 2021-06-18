package com.rsschool.quiz

class DataValues {
    private companion object {
        const val FIRST_QUESTION = "To be, or not to be..."
        const val FIRST_QUESTION_FIRST_OPTION = "To be"
        const val FIRST_QUESTION_SECOND_OPTION = "Not to be "
        const val FIRST_QUESTION_THIRD_OPTION = "I don't know"
        const val FIRST_QUESTION_FOURTH_OPTION = "It's not my problem"
        const val FIRST_QUESTION_FIFTH_OPTION = "that is the question"
        const val FIRST_QUESTION_CORRECT_ANSWER = FIRST_QUESTION_FIFTH_OPTION

        const val SECOND_QUESTION = "The tallest skyscraper"
        const val SECOND_QUESTION_FIRST_OPTION = "Shanghai Tower, Shanghai"
        const val SECOND_QUESTION_SECOND_OPTION = "Burj Khalifa, Dubai"
        const val SECOND_QUESTION_THIRD_OPTION = "Trump International Hotel, Chicago"
        const val SECOND_QUESTION_FOURTH_OPTION = "Central Park Tower, New York"
        const val SECOND_QUESTION_FIFTH_OPTION = "Eiffel Tower, Paris"
        const val SECOND_QUESTION_CORRECT_ANSWER = SECOND_QUESTION_SECOND_OPTION

        const val THIRD_QUESTION = "What is superfluous?"
        const val THIRD_QUESTION_FIRST_OPTION = "Discord"
        const val THIRD_QUESTION_SECOND_OPTION = "Slack"
        const val THIRD_QUESTION_THIRD_OPTION = "Kotlin"
        const val THIRD_QUESTION_FOURTH_OPTION = "It's a word"
        const val THIRD_QUESTION_FIFTH_OPTION = "Telegram"
        const val THIRD_QUESTION_CORRECT_ANSWER = THIRD_QUESTION_FOURTH_OPTION

        const val FOURTH_QUESTION = "The biggest animal"
        const val FOURTH_QUESTION_FIRST_OPTION = "Cat"
        const val FOURTH_QUESTION_SECOND_OPTION = "Elephant"
        const val FOURTH_QUESTION_THIRD_OPTION = "Bat"
        const val FOURTH_QUESTION_FOURTH_OPTION = "White whale"
        const val FOURTH_QUESTION_FIFTH_OPTION = "Human"
        const val FOURTH_QUESTION_CORRECT_ANSWER = FOURTH_QUESTION_FOURTH_OPTION

        const val FIFTH_QUESTION = "Who was the 9th President of the USA?"
        const val FIFTH_QUESTION_FIRST_OPTION = "Martin Van Buren"
        const val FIFTH_QUESTION_SECOND_OPTION = "Abraham Lincoln"
        const val FIFTH_QUESTION_THIRD_OPTION = "William Henry Harrison"
        const val FIFTH_QUESTION_FOURTH_OPTION = "Zachary Taylor"
        const val FIFTH_QUESTION_FIFTH_OPTION = "John Quincy Adams"
        const val FIFTH_QUESTION_CORRECT_ANSWER = FIFTH_QUESTION_THIRD_OPTION
    }

    val arrayFirstQuestion = listOf(
        FIRST_QUESTION,
        FIRST_QUESTION_FIRST_OPTION,
        FIRST_QUESTION_SECOND_OPTION,
        FIRST_QUESTION_THIRD_OPTION,
        FIRST_QUESTION_FOURTH_OPTION,
        FIRST_QUESTION_FIFTH_OPTION
    )

    val arraySecondQuestion = listOf(
        SECOND_QUESTION,
        SECOND_QUESTION_FIRST_OPTION,
        SECOND_QUESTION_SECOND_OPTION,
        SECOND_QUESTION_THIRD_OPTION,
        SECOND_QUESTION_FOURTH_OPTION,
        SECOND_QUESTION_FIFTH_OPTION
    )

    val arrayThirdQuestion = listOf(
        THIRD_QUESTION,
        THIRD_QUESTION_FIRST_OPTION,
        THIRD_QUESTION_SECOND_OPTION,
        THIRD_QUESTION_THIRD_OPTION,
        THIRD_QUESTION_FOURTH_OPTION,
        THIRD_QUESTION_FIFTH_OPTION
    )

    val arrayFourthQuestion = listOf(
        FOURTH_QUESTION,
        FOURTH_QUESTION_FIRST_OPTION,
        FOURTH_QUESTION_SECOND_OPTION,
        FOURTH_QUESTION_THIRD_OPTION,
        FOURTH_QUESTION_FOURTH_OPTION,
        FOURTH_QUESTION_FIFTH_OPTION
    )

    val arrayFifthQuestion = listOf(
        FIFTH_QUESTION,
        FIFTH_QUESTION_FIRST_OPTION,
        FIFTH_QUESTION_SECOND_OPTION,
        FIFTH_QUESTION_THIRD_OPTION,
        FIFTH_QUESTION_FOURTH_OPTION,
        FIFTH_QUESTION_FIFTH_OPTION
    )

    val arrayCorrectAnswers= listOf(
        "",
        FIRST_QUESTION_CORRECT_ANSWER,
        SECOND_QUESTION_CORRECT_ANSWER,
        THIRD_QUESTION_CORRECT_ANSWER,
        FOURTH_QUESTION_CORRECT_ANSWER,
        FIFTH_QUESTION_CORRECT_ANSWER
    )
}