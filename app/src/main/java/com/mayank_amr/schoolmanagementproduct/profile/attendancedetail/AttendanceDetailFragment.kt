package com.mayank_amr.schoolmanagementproduct.profile.attendancedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.profile.ProfileViewModel
import com.mayank_amr.schoolmanagementproduct.profile.ProfileViewModelFactory

class AttendanceDetailFragment : Fragment() {

    companion object {
        fun newInstance() = AttendanceDetailFragment()
    }

    private lateinit var factory: ProfileViewModelFactory
    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.attendance_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }




}