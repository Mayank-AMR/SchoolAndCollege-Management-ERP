package com.mayank_amr.schoolmanagementproduct.profile.profiledata

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 11-01-2021 02:44 PM
 */
class User(
    val id: Int,
    val totalOpenDays: Int,
    val totalAttendedDays: Int

) {

    fun getAttendancePercentage(): String =
        ((totalAttendedDays / totalOpenDays) * 100).toString() + " %"

}