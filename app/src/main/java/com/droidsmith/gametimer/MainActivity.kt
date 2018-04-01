package com.droidsmith.gametimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.droidsmith.gametimer.view.TimerFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frag_container, TimerFragment()).commit()
        }
    }
}
