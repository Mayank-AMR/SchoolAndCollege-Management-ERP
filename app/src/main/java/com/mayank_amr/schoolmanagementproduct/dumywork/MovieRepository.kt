package com.mayank_amr.schoolmanagementproduct.dumywork

import com.mayank_amr.schoolmanagementproduct.network.MyApi
import com.mayank_amr.schoolmanagementproduct.network.SafeApiRequest

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 08-01-2021 11:40 AM
 */
class MovieRepository(
    private val api: MyApi
) : SafeApiRequest() {
    suspend fun getMovies() = apiRequest { api.getMovies() }
}