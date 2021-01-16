package com.mayank_amr.schoolmanagementproduct.assignment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.schoolmanagementproduct.dumywork.MovieRepository

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 08-01-2021 12:06 PM
 */
@Suppress("UNCHECKED_CAST")
class AssignmentHomeViewModelFactory(
    private val repository: MovieRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        //return super.create(modelClass)
        return AssignmentHomeViewModel(repository) as T
    }
}