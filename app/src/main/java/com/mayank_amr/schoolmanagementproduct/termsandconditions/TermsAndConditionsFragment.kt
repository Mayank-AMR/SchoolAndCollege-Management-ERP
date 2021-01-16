package com.mayank_amr.schoolmanagementproduct.termsandconditions

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayank_amr.schoolmanagementproduct.R

class TermsAndConditionsFragment : Fragment() {

    companion object {
        fun newInstance() = TermsAndConditionsFragment()
    }

    private lateinit var viewModel: TermsAndConditionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.terms_and_conditions_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(TermsAndConditionsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}