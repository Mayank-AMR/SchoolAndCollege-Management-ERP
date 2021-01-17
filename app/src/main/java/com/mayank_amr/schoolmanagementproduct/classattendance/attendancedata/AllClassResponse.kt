package com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata

data class AllClassResponse(
    val `data`: List<Data>
) {
    data class Data(
        val created_at: String,
        val id: Int,
        val name: String,
        val numeric: Int,
        val updated_at: String
    )
}