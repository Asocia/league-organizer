package com.example.leagueorganizer.teams

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leagueorganizer.network.TeamsApi
import kotlinx.coroutines.launch

class TeamsViewModel: ViewModel() {
    private val _status = MutableLiveData<String>()

    val status: LiveData<String> = _status

    fun getTeamNames() {
        viewModelScope.launch {

            try {
                val listResult = TeamsApi.RETROFIT_SERVICE.getTeamNames("surname", "10")
                _status.value = listResult.toString()
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}
