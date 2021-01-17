package com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata

data class ClassSections(
    val `data`: List<Data>
) {
    data class Data(
        val class_id: Int,
        val created_at: String,
        val head_teacher_id: Int,
        val id: Int,
        val name: String,
        val strength: Int,
        val updated_at: String
    )
}