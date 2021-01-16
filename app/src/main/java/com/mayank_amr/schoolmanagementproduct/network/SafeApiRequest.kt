package com.mayank_amr.schoolmanagementproduct.network

import com.mayank_amr.schoolmanagementproduct.utils.ApiException
import org.json.JSONException
import retrofit2.Response
import java.lang.StringBuilder

/**
 * @Project FriendsFeed
 * @Created_by Mayank Kumar on 14-09-2020 10:47 AM
 */
abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()

        if (response.isSuccessful) {
            return response.body()!!
        } else {
            val error = response.errorBody()?.toString()
            // error response is in JSON Object that is
            // Response{protocol=http/1.1, code=404, message=Not Found, url=https://friendsfeed.herokuapp.com.../../..}

            val message = StringBuilder()
            error?.let {
                try {
                    if (response.code() == 404)
                        message.append(" ${response.code()}")
                } catch (e: JSONException) {
                }
                message.append("\n")
            }
            message.append(" ${response.message()} ")
            throw ApiException(message.toString())
        }
    }
}