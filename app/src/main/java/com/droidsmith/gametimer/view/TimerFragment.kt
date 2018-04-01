package com.droidsmith.gametimer.view

import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droidsmith.gametimer.MainActivity
import com.droidsmith.gametimer.R
import com.droidsmith.gametimer.view.*
import kotlinx.android.synthetic.main.timer_fragment.*


class TimerFragment :  BaseFragment(){

    enum class PlayState{ PLAYING, STOPPED }

    val TICK_INTERVAL : Long = 1

    var duration_1: Long = 0
    var duration_2: Long = 0
    var duration_3: Long = 0

    var con: Context? = null
    private var currentState = PlayState.STOPPED


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.timer_fragment, container, false)
    }


    override fun onStart() {
        super.onStart()
        duration_1 = 3
        duration_2 = 3
        duration_3 = 10

        media_button.setOnClickListener{ v ->
            updateButtons()
        }

    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        con = context!!
        val resources = context.resources
    }



    private fun updateButtons() {
        when(currentState){
            PlayState.STOPPED ->{
                media_button.setImageDrawable(ContextCompat.getDrawable(con!!, R.drawable.ic_action_play))
                startTimer_1()
            }
            PlayState.PLAYING ->{
                media_button.setImageDrawable(ContextCompat.getDrawable(con!!, R.drawable.ic_action_stop))
                resetTimers()
            }
        }
    }


    private fun startTimer_1(){

        object : CountDownTimer(duration_1 * 1000, TICK_INTERVAL){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timer_1.text = "$timeLeft"
            }

            override fun onFinish() {
                startTimer_2()
            }

        }.start()

    }
    private fun startTimer_2(){

        object : CountDownTimer(duration_2 * 1000, TICK_INTERVAL){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timer_2.text = "$timeLeft"
            }

            override fun onFinish() {
                startTimer_3()
            }

        }.start()

    }
    private fun startTimer_3(){

        object : CountDownTimer(duration_3 * 1000, TICK_INTERVAL){
            override fun onTick(millisUntilFinished: Long) {
                val timeLeft = millisUntilFinished / 1000
                timer_3.text = "$timeLeft"
            }

            override fun onFinish() {
                resetTimers()
            }

        }.start()

    }

    private fun resetTimers() {
        timer_1.text = "$duration_1"
        timer_2.text = "$duration_2"
        timer_3.text = "$duration_3"
        currentState = PlayState.STOPPED
    }











}