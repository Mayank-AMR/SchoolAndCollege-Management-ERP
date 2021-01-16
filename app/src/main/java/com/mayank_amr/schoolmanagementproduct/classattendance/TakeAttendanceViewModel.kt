package com.mayank_amr.schoolmanagementproduct.classattendance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.StudentAttendanceModel
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.TakeAttendanceRepository
import com.mayank_amr.schoolmanagementproduct.utils.Coroutines
import kotlinx.coroutines.Job

class TakeAttendanceViewModel(
    private val repository: TakeAttendanceRepository
) : ViewModel() {
    private lateinit var job: Job

    private val _students = MutableLiveData<List<StudentAttendanceModel>>()

    val students: LiveData<List<StudentAttendanceModel>>
        get() = _students

    fun getStudents() {
        job = Coroutines.ioThenMain(
            { repository.getStudents() },
            { _students.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}