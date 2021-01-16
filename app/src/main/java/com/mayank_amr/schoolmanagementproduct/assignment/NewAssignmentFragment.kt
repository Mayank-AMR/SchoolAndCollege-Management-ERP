package com.mayank_amr.schoolmanagementproduct.assignment

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.assignment.data.NewAssignmentViewModel
import com.mayank_amr.schoolmanagementproduct.assignment.data.NewAssignmentViewModelFactory
import kotlinx.android.synthetic.main.new_assignment_fragment.*
import kotlinx.coroutines.launch
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance
import java.io.File

class NewAssignmentFragment : Fragment(), KodeinAware {

    companion object {
        fun newInstance() = NewAssignmentFragment()
    }

    override val kodein by kodein()
    private val factory: NewAssignmentViewModelFactory by instance()

    private lateinit var viewModel: NewAssignmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.new_assignment_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(NewAssignmentViewModel::class.java)
        // TODO: Use the ViewModel

//        button_create_assignment.setOnClickListener(View.OnClickListener {
//            if (edit_text_assignment_detail.text.isNullOrEmpty()) {
//                Log.i(TAG, "onActivityCreated: Enter valid detail.")
//            } else {
//                lifecycleScope.launch {
//                    var f: File? = null
//                    viewModel.createNewAssignment(" ", f!!, " ")
//
//                }
//            }
//        })
    }
}