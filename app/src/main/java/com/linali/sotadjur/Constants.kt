package com.linali.sotadjur

import com.linali.sotadjur.QuestionModel

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"



    fun getQuestions(): ArrayList<QuestionModel> {
        val questionList = ArrayList<QuestionModel>()
        val question = "Vilket djur är det?"
        val animalList = listOf("fågel", "gris","häst","hund","kanin", "katt","ko","orm", "tupp","anka")

        val que1 = QuestionModel(1,
           question,
              R.drawable.katt,
            animalList[5], animalList[3],
            1)

        val que2 = QuestionModel(2,
                question,
                R.drawable.hund,
                animalList[2], animalList[3],
                2)

        val que3 = QuestionModel(3,
                question,
                R.drawable.orm,
                animalList[7], animalList[4],
                1)


        val que4 = QuestionModel(4,
                question,
                R.drawable.fagel,
                animalList[8], animalList[0],
                2)

        val que5 = QuestionModel(5,
                question,
                R.drawable.gris,
                animalList[7], animalList[1],
                2)

        val que6 = QuestionModel(6,
                question,
                R.drawable.hast,
                animalList[2], animalList[5],
                1)

        val que7 = QuestionModel(7,
                question,
                R.drawable.kanin,
                animalList[3], animalList[4],
                2)

        val que8 = QuestionModel(8,
                question,
                R.drawable.anka,
                animalList[9], animalList[4],
                1)

        val que9 = QuestionModel(9,
                question,
                R.drawable.ko,
                animalList[8], animalList[6],
                2)

        val que10 = QuestionModel(10,
                question,
                R.drawable.tupp,
                animalList[8], animalList[2],
                1)

        questionList.add(que1)
        questionList.add(que2)
        questionList.add(que3)
        questionList.add(que4)
        questionList.add(que5)
        questionList.add(que6)
        questionList.add(que7)
        questionList.add(que8)
        questionList.add(que9)
        questionList.add(que10)

        return questionList
    }
}