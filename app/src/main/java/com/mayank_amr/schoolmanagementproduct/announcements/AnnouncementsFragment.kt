package com.mayank_amr.schoolmanagementproduct.announcements

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mayank_amr.schoolmanagementproduct.R

class AnnouncementsFragment : Fragment() {

    companion object {
        fun newInstance() = AnnouncementsFragment()
    }

    private lateinit var viewModel: AnnouncementsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.announcements_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnnouncementsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}