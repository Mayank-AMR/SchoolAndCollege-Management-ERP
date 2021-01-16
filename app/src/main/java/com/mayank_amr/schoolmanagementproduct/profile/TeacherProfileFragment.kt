package com.mayank_amr.schoolmanagementproduct.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.mayank_amr.schoolmanagementproduct.R


class TeacherProfileFragment : Fragment()/*, KodeinAware*/ {

//    override val kodein by kodein()
//    private val factory: ProfileViewModelFactory by instance()

    companion object {
        fun newInstance() = TeacherProfileFragment()
    }

    private lateinit var factory: ProfileViewModelFactory
    private lateinit var viewModel: ProfileViewModel
    // Common viewModel for Teacher and Student

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.teacher_profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Common viewModel for Teacher and Student
        viewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}