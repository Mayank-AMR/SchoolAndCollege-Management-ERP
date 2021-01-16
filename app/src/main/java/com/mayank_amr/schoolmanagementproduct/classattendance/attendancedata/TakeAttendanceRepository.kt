package com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata

import com.mayank_amr.schoolmanagementproduct.network.MyApi
import com.mayank_amr.schoolmanagementproduct.network.SafeApiRequest

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 13-01-2021 10:03 AM
 */
class TakeAttendanceRepository(
    private val api: MyApi
) : SafeApiRequest() {
    //ToDo: need to change for attendance
    suspend fun getStudents() = apiRequest { api.getStudentForAttendance() }

    /*suspend fun submitAttendance() = apiRequest { api.submitStudentAttendence() }*/

}