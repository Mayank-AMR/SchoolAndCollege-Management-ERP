package com.mayank_amr.schoolmanagementproduct.assignment.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mayank_amr.schoolmanagementproduct.assignment.data.repository.AssignmentRepository
import com.mayank_amr.schoolmanagementproduct.assignment.data.repository.NewAssignmentResponse
import kotlinx.coroutines.launch
import java.io.File

class NewAssignmentViewModel(
    private val repository: AssignmentRepository
) : ViewModel() {

    private val _result = MutableLiveData<NewAssignmentResponse>()
    val result: LiveData<NewAssignmentResponse> = _result

    init {
        viewModelScope.launch {
            //_result.value =
        }
    }

    suspend fun createNewAssignment(question: String, file: File, dueDate: String) {
        _result.value = repository.createNewAssignment(question, file, dueDate)
    }


}