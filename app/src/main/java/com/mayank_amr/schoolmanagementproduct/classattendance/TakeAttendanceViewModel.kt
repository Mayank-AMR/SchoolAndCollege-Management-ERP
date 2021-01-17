package com.mayank_amr.schoolmanagementproduct.classattendance

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.AllClassResponse
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.ClassSections
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.StudentsOfClassAndSection
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.TakeAttendanceRepository
import com.mayank_amr.schoolmanagementproduct.utils.Coroutines
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TakeAttendanceViewModel(
    private val repository: TakeAttendanceRepository
) : ViewModel() {
    private lateinit var job: Job

    private val _students = MutableLiveData<StudentsOfClassAndSection>()

    private val _allClasses = MutableLiveData<List<AllClassResponse.Data>>()
    private val _sectionOfClass = MutableLiveData<ClassSections>()

    init {
        viewModelScope.launch {
            Log.i(TAG, ": \n\n Fetching All Classes from database.........................\n\n")

            job = Coroutines.ioThenMain(
                { repository.getAllClasses() },
                { _allClasses.value = it }
            )
        }
    }

    val students: LiveData<StudentsOfClassAndSection>
        get() = _students

    val classes: LiveData<List<AllClassResponse.Data>>
        get() = _allClasses

    val sections: LiveData<ClassSections>
        get() = _sectionOfClass


    fun fetchSection(classId: Int) {
        job = Coroutines.ioThenMain(
            { repository.getAllSectionByClassId() },
            { _sectionOfClass.value = it }
        )
    }

    fun fetchStudentsOfSection(classId:Int,sectionId: Int) {
        job = Coroutines.ioThenMain(
            { repository.getAllStudentsByClassAndSection() },
            { _students.value = it }
        )
    }


    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}