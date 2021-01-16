package com.mayank_amr.schoolmanagementproduct.app

import android.app.Application
import com.mayank_amr.schoolmanagementproduct.assignment.AssignmentHomeViewModelFactory
import com.mayank_amr.schoolmanagementproduct.assignment.data.NewAssignmentViewModelFactory
import com.mayank_amr.schoolmanagementproduct.assignment.data.repository.AssignmentRepository
import com.mayank_amr.schoolmanagementproduct.classattendance.TakeAttendanceViewModelFactory
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.TakeAttendanceRepository
import com.mayank_amr.schoolmanagementproduct.dumywork.MovieRepository
import com.mayank_amr.schoolmanagementproduct.network.MyApi
import com.mayank_amr.schoolmanagementproduct.network.NetworkConnectionInterceptor
import com.mayank_amr.schoolmanagementproduct.profile.ProfileViewModelFactory
import com.mayank_amr.schoolmanagementproduct.profile.profiledata.ProfileRepository
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 02-12-2020 04:06 PM
 */
class SchoolApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@SchoolApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }

        bind() from singleton { MovieRepository(instance()) }
        bind() from singleton { AssignmentRepository(instance()) }
        bind() from singleton { ProfileRepository(instance()) }
        bind() from singleton { TakeAttendanceRepository(instance()) }

        bind() from provider { AssignmentHomeViewModelFactory(instance()) }
        bind() from provider { NewAssignmentViewModelFactory(instance()) }
        bind() from provider { TakeAttendanceViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }


    }
}