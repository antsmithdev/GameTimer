package com.droidsmith.gametimer.viewmodel

import android.os.CountDownTimer


class TimerViewmodel{

    val tickInterval : Long = 1

    public fun getTimer(duration: Long) : CountDownTimer{
        return object : CountDownTimer(duration, tickInterval){
            override fun onFinish() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTick(millisUntilFinished: Long) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }


}