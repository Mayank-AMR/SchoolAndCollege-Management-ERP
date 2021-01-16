package com.mayank_amr.schoolmanagementproduct.fees

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayank_amr.schoolmanagementproduct.R

class FeesFragment : Fragment() {

    companion object {
        fun newInstance() = FeesFragment()
    }

    private lateinit var viewModel: FeesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fees_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FeesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}