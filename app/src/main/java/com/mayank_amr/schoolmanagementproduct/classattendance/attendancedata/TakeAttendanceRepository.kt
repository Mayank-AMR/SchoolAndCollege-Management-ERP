package com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata

import android.content.ContentValues.TAG
import android.util.Log
import com.mayank_amr.schoolmanagementproduct.network.MyApi
import com.mayank_amr.schoolmanagementproduct.network.SafeApiRequest

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 13-01-2021 10:03 AM
 */
class TakeAttendanceRepository(
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun getAllClasses(): List<AllClassResponse.Data> {
        val allClassResponse: AllClassResponse = apiRequest { api.getAllClasses() }
        Log.d(TAG, "\n\n getAllClasses: ......................."+allClassResponse.data.size)
        return allClassResponse.data

    }


    suspend fun getAllSectionByClassId() = apiRequest { api.getAllSectionByClassId() }



    suspend fun getAllStudentsByClassAndSection() = apiRequest { api.getAllStudentsByClassAndSection() }



    /*suspend fun postAttendanceRecord() = apiRequest { api.postAttendanceRecord() }*/

}