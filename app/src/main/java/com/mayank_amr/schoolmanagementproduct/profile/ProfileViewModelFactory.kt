package com.mayank_amr.schoolmanagementproduct.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.schoolmanagementproduct.profile.profiledata.ProfileRepository

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 11-01-2021 04:18 PM
 */
@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(
    private val repository: ProfileRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return ProfileViewModel(repository) as T
    }
}