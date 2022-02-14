package com.example.leagueorganizer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import com.example.leagueorganizer.teams.TeamNamesFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn = findViewById<Button>(R.id.btnDrawFixture)

        findViewById<NumberPicker>(R.id.npNumOfTeams).apply {
            maxValue = 16
            minValue = 3
            wrapSelectorWheel = false
        }

        findViewById<Button>(R.id.btnGetTeams).apply {
            setOnClickListener { showTeamNamesFragment() }
        }

    }
    private fun showTeamNamesFragment() {
        val bundle = Bundle()
        val numberPicker = findViewById<NumberPicker>(R.id.npNumOfTeams)
        val fragment = TeamNamesFragment()
        bundle.putString("numOfTeams",numberPicker.value.toString())
        fragment.arguments = bundle
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment).commit()
    }
}