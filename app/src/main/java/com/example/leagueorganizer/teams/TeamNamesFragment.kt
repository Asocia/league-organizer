package com.example.leagueorganizer.teams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.leagueorganizer.databinding.FragmentTeamNamesBinding

class TeamNamesFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTeamNamesBinding.inflate(inflater)
        val bundle = arguments
        val numOfTeams = bundle!!.getString("numOfTeams").toString()
        val viewModel: TeamsViewModel by viewModels()
        viewModel.getTeamNames(quantity = numOfTeams)
        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root
    }
}
