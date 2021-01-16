package com.mayank_amr.schoolmanagementproduct.assignment.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.databinding.AssignmentHomeViewBinding
import com.mayank_amr.schoolmanagementproduct.dumywork.responce.Movie

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 08-01-2021 12:57 PM
 */
class AssignmentsAdapter(
    private val movies: List<Movie>
) : RecyclerView.Adapter<AssignmentsAdapter.AssignmentViewHolder>() {

    override fun getItemCount() = movies.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AssignmentViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.assignment_home_view,
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: AssignmentViewHolder, position: Int) {
        holder.assignmentHomeViewBinding.assignments = movies[position]

        holder.itemView.setOnClickListener{ view ->
            view.findNavController().navigate(R.id.action_assignmentHomeFragment_to_assignmentDetailFragment)
        }
    }


    inner class AssignmentViewHolder(
        val assignmentHomeViewBinding: AssignmentHomeViewBinding
    ) : RecyclerView.ViewHolder(assignmentHomeViewBinding.root)
}