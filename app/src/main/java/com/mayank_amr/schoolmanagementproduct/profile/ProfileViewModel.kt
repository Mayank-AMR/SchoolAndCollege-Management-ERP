package com.mayank_amr.schoolmanagementproduct.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayank_amr.schoolmanagementproduct.profile.profiledata.ProfileRepository
import com.mayank_amr.schoolmanagementproduct.profile.profiledata.User
import kotlinx.coroutines.Job

class ProfileViewModel(
    private val repository: ProfileRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _profile = MutableLiveData<User>()

    val profile: LiveData<User>
        get() = _profile  // Here I return live data outside bz it can't be changed only observe.

    fun getProfile() {
        // ToDo(Need to discus profile primary key to fetch data from server)
//        job = Coroutines.ioThenMain(
//            { repository.getProfile() },
//            { _profile.value = it }
//        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}