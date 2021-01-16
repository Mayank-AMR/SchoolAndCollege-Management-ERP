package com.mayank_amr.schoolmanagementproduct.notification

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayank_amr.schoolmanagementproduct.R

class NotificatioMenuFragment : Fragment() {

    companion object {
        fun newInstance() = NotificatioMenuFragment()
    }

    private lateinit var viewModel: NotificatioMenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.notificatio_menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NotificatioMenuViewModel::class.java)
        // TODO: Use the ViewModel
    }

}