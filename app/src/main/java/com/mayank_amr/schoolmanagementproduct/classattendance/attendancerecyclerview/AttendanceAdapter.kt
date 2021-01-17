package com.mayank_amr.schoolmanagementproduct.classattendance.attendancerecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancedata.StudentsOfClassAndSection
import com.mayank_amr.schoolmanagementproduct.databinding.TakeAttendanceViewBinding

/**
 * @Project SchoolManagementProduct
 * @Created_by Mayank Kumar on 08-01-2021 12:57 PM
 */
class AttendanceAdapter(
    private val students: List<StudentsOfClassAndSection.Data>
) : RecyclerView.Adapter<AttendanceAdapter.AttendanceViewHolder>() {

    override fun getItemCount() = students.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AttendanceViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.take_attendance_view,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AttendanceViewHolder, position: Int) {
        holder.takeAttendanceViewBinding.students = students[position]

//        holder.itemView.setOnClickListener { view ->
//            view.findNavController()
//                .navigate(R.id.action_assignmentHomeFragment_to_assignmentDetailFragment)
//        }
    }

    inner class AttendanceViewHolder(
        val takeAttendanceViewBinding: TakeAttendanceViewBinding
    ) : RecyclerView.ViewHolder(takeAttendanceViewBinding.root)

}
