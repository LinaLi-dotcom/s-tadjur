package com.linali.sotadjur

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import com.linali.sotadjur.QuestionModel
import com.linali.sotadjur.ResultActivity
import com.linali.sotadjur.Constants
import com.linali.sotadjur.R


class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<QuestionModel>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswers: Int = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)


        val option1TV: TextView = findViewById<TextView>(R.id.option1TV)
        val option2TV: TextView = findViewById<TextView>(R.id.option2TV)
        val submitBTN = findViewById<Button>(R.id.submit_BTN)


        mQuestionList = Constants.getQuestions()
        setQuestion()


        option1TV.setOnClickListener(this)
        option2TV.setOnClickListener(this)
        submitBTN.setOnClickListener(this)

    }

    private fun setQuestion(){
        val submitBTN = findViewById<Button>(R.id.submit_BTN)
        val question = mQuestionList!![mCurrentPosition-1]
        defaultOptionsView()

        if(mCurrentPosition == mQuestionList!!.size) {
            submitBTN.text = "Klar!"
        } else {
            submitBTN.text = "Sant eller falskt?"
        }


        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar.progress = mCurrentPosition
        progressBar.max = 10
        val progressTV = findViewById<TextView>(R.id.progressTV)
        progressTV.text = "$mCurrentPosition" + "/" + progressBar.max
        val questionTV = findViewById<TextView>(R.id.questionTV)
        questionTV.text = question!!.question
        val questionImage = findViewById<ImageView>(R.id.questionImage)
        questionImage.setImageResource(question.image)


        val option1TV: TextView = findViewById<TextView>(R.id.option1TV)
        val option2TV: TextView = findViewById<TextView>(R.id.option2TV)


        option1TV.text = question.optionOne
        option2TV.text = question.optionTwo

    }

    private fun defaultOptionsView(){
        // create an arrylist of textviews and add them with index
        val options = ArrayList<TextView>()


        val option1TV: TextView = findViewById<TextView>(R.id.option1TV)
        val option2TV: TextView = findViewById<TextView>(R.id.option2TV)

        options.add(0, option1TV)
        options.add(1, option2TV)

        for(option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                    R.drawable.default_option_border_bg)
        }
        
    }

    override fun onClick(v: View?) {
        val submitBTN = findViewById<Button>(R.id.submit_BTN)

        when (v?.id) {
            R.id.option1TV -> {
                val option1TV: TextView = findViewById<TextView>(R.id.option1TV)
                selectedOptionsView(option1TV, 1)
            }
            R.id.option2TV -> {
                val option2TV: TextView = findViewById<TextView>(R.id.option2TV)
                selectedOptionsView(option2TV, 2)
            }

            R.id.submit_BTN -> {
                //selectedoptionposition is reset to 0, no options move to next
                if(mSelectedOptionPosition == 0) {
                    mCurrentPosition ++
                    //by increasing current postion, move to the next question

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }else -> {
                          val intent = Intent(this, ResultActivity::class.java)
                           intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                           intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                           startActivity(intent)
                           finish()
                        //when there are questions left, continue. if not, finish!
                        }
                    }
                }else {
                    //set the question, check answer with selected option
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer !=mSelectedOptionPosition){
                        AnswerView(mSelectedOptionPosition, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers ++
                        AnswerView(mSelectedOptionPosition, R.drawable.correct_option_border_bg)
                        // if the last question, change btn text to finish. otherwise next question
                        if(mCurrentPosition == mQuestionList!!.size) {
                            submitBTN.text = "Klar!"
                        } else {
                            submitBTN.text = "NÄSTA"
                        }
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }
    }

    private fun AnswerView(answer: Int, drawableView: Int) {
        when (answer){
            1-> {
                val option1TV = findViewById<TextView>(R.id.option1TV)
                option1TV.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
            2-> {
                val option2TV = findViewById<TextView>(R.id.option2TV)
                option2TV.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }

        }
    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this,
                R.drawable.selected_option_border_bg)
    }

}