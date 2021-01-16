package com.mayank_amr.schoolmanagementproduct.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.mayank_amr.schoolmanagementproduct.R
import kotlinx.android.synthetic.main.assignment_detail_fragment.*

class AssignmentDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.assignment_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        buttonAssignmentDetailFragmentAttempt.setOnClickListener { view ->
            view.findNavController()
                .navigate(R.id.action_assignmentDetailFragment_to_submitAssignmentFragment)
        }

    }
}