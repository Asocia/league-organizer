package com.example.leagueorganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<NumberPicker>(R.id.npNumOfTeams).apply {
            maxValue = 16
            minValue = 3
            wrapSelectorWheel = false
        }

        findViewById<Button>(R.id.btnDrawFixture).apply {
            setOnClickListener { drawFixture()
            }
        }
    }

    private fun drawFixture() {
        TODO("Not yet implemented")
    }
}