package com.mayank_amr.schoolmanagementproduct.assignment.data.repository

import com.mayank_amr.schoolmanagementproduct.network.MyApi
import com.mayank_amr.schoolmanagementproduct.network.SafeApiRequest
import java.io.File

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 25-12-2020 12:55 PM
 */
const val accept_type = "application/json"

class AssignmentRepository(
    private val api: MyApi
) : SafeApiRequest() {

    suspend fun createNewAssignment(
        question: String,
        file: File,
        dueDate: String
    ): NewAssignmentResponse {
        return apiRequest {
            api.createNewAssignment(accept_type, question, file, dueDate)
        }
    }

}