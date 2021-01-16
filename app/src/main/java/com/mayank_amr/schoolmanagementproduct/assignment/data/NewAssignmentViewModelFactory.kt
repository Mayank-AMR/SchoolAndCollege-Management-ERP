package com.mayank_amr.schoolmanagementproduct.assignment.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.schoolmanagementproduct.assignment.data.repository.AssignmentRepository

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 05-12-2020 04:30 PM
 */

@Suppress("UNCHECKED_CAST")
class NewAssignmentViewModelFactory(
    private val repository: AssignmentRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewAssignmentViewModel(repository) as T
    }
}