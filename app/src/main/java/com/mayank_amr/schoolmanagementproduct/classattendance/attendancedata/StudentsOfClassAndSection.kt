package com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata

data class StudentsOfClassAndSection(
    val `data`: List<Data>
) {
    data class Data(
        val address: Any?,
        val city: String,
        val created_at: String,
        val date_of_birth: String,
        val email: String,
        val father_name: Any?,
        val gender: String,
        val id: Int,
        val migration: Any?,
        val mobile_no: String,
        val mother_name: Any?,
        val name: String,
        val photo: Any?,
        val pin_code: String,
        val registration_no: String,
        val religion: Any?,
        val roll_no: Any?,
        val state: String,
        val tc: Any?,
        val updated_at: String,
        val username: String
    )
}