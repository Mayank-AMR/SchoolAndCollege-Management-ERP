package com.mayank_amr.schoolmanagementproduct.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 08-01-2021 12:27 PM
 */
object Coroutines {

    /* ***************** Here the data fetched in IO thread and send to main thread ***************/
    fun <T : Any> ioThenMain(work: suspend (() -> T?), callback: ((T?) -> Unit)) =
        CoroutineScope(Dispatchers.Main).launch {
            val data = CoroutineScope(Dispatchers.IO).async rt@{
                return@rt work()
            }.await()
            callback(data)
        }
}