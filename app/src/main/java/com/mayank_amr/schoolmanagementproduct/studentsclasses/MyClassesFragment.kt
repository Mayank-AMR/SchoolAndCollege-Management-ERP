package com.mayank_amr.schoolmanagementproduct.studentsclasses

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayank_amr.schoolmanagementproduct.R

class MyClassesFragment : Fragment() {

    companion object {
        fun newInstance() = MyClassesFragment()
    }

    private lateinit var viewModel: MyClassesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_classes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MyClassesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}