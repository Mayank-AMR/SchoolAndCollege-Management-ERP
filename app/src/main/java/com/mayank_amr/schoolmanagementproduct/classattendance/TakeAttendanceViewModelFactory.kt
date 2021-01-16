package com.mayank_amr.schoolmanagementproduct.classattendance

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.TakeAttendanceRepository
import com.mayank_amr.schoolmanagementproduct.profile.profiledata.ProfileRepository

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 11-01-2021 04:18 PM
 */
@Suppress("UNCHECKED_CAST")
class TakeAttendanceViewModelFactory(
    private val profileRepository: TakeAttendanceRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return TakeAttendanceViewModel(profileRepository) as T
    }
}