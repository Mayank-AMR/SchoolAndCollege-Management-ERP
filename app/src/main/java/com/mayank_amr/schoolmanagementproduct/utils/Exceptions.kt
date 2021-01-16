package com.mayank_amr.schoolmanagementproduct.utils

import java.io.IOException

/**
 * @Project FriendsFeed
 * @Created_by Mayank Kumar on 14-09-2020 11:02 AM
 */
class ApiException(message: String): IOException(message)

class NoInternetException(message: String) : IOException(message)