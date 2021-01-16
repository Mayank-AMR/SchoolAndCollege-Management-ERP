package com.mayank_amr.schoolmanagementproduct.profile.profiledata

import com.mayank_amr.schoolmanagementproduct.network.MyApi
import com.mayank_amr.schoolmanagementproduct.network.SafeApiRequest

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 11-01-2021 02:25 PM
 */
class ProfileRepository(
    private val api: MyApi

) : SafeApiRequest() {

    suspend fun getProfile() = apiRequest { api.getProfile() }

}