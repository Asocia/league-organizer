package com.example.leagueorganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import com.example.leagueorganizer.teams.TeamsFragment

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
            setOnClickListener { showFragment() }
        }

    }
    private fun showFragment() {
        val fragment = TeamsFragment()
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit()
    }
}