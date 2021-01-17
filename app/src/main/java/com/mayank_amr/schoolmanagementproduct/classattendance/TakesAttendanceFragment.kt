package com.mayank_amr.schoolmanagementproduct.classattendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancerecyclerview.AttendanceAdapter
import kotlinx.android.synthetic.main.take_attendance_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class TakesAttendanceFragment : Fragment(), KodeinAware {

    override val kodein by kodein()
    private val factory: TakeAttendanceViewModelFactory by instance()


    companion object {
        fun newInstance() = TakesAttendanceFragment()
    }


    private lateinit var viewModel: TakeAttendanceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.take_attendance_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(TakeAttendanceViewModel::class.java)
        // TODO: Use the ViewModel

        //viewModel.getStudents()
        viewModel.students.observe(viewLifecycleOwner, Observer { students ->
            recycler_view_take_attendance.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = AttendanceAdapter(students.data)
            }
        })


        /*---------------------*** Class Spinner ***---------------------------------------------*/
        viewModel.classes.observe(viewLifecycleOwner, Observer { classesList ->
            val classesName = ArrayList<String>(classesList.size + 1)
            classesName.add("select")

            for (element in classesList)
                classesName.add(element.name)

            val classSpinner = classes_spinner
            if (classSpinner != null) {
                val classesArrayAdapter = activity?.let {
                    ArrayAdapter(
                        it,
                        android.R.layout.simple_spinner_item,
                        classesName
                    )
                }
                classesArrayAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                classSpinner.adapter = classesArrayAdapter
                classSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(
                        parent: AdapterView<*>,
                        view: View,
                        position: Int,
                        id: Long
                    ) {
                        if (position > 0) {
//                            Toast.makeText(
//                                activity,
//                                "Selected Item id: " + classesList[position - 1].id,
//                                Toast.LENGTH_SHORT
//                            ).show()
                            viewModel.fetchSection(classesList[position - 1].id)
                        }
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // Code to perform some action when nothing is selected
                        // Toast.makeText(activity, "Please select section: ", Toast.LENGTH_SHORT).show()

                    }
                }
            }

        })
        /*----------------------------------------------------------------------------------------*/


        /*---------------------*** Section Spinner ***--------------------------------------------*/
        viewModel.sections.observe(viewLifecycleOwner, Observer { section ->

            val sectionName = ArrayList<String>(section.data.size+1)
            sectionName.add("select")

            for (item in section.data)
                sectionName.add(item.name)

            val sectionSpinner = sections_spinner
            if (sectionSpinner != null) {
                val classesArrayAdapter = activity?.let {
                    ArrayAdapter(
                        it,
                        android.R.layout.simple_spinner_item,
                        sectionName
                    )
                }
                classesArrayAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                sectionSpinner.adapter = classesArrayAdapter
                sectionSpinner.onItemSelectedListener =
                    object : AdapterView.OnItemSelectedListener {
                        override fun onItemSelected(
                            parent: AdapterView<*>,
                            view: View,
                            position: Int,
                            id: Long
                        ) {
                            if (position > 0) {
                                viewModel.fetchStudentsOfSection(section.data[position - 1].id, 2)
                            }
                        }

                        override fun onNothingSelected(parent: AdapterView<*>) {
                            // Code to perform some action when nothing is selected
                        }
                    }
            }
        })

    }

    fun studentDetail(){
        findNavController().navigate(
            R.id.action_homeFragment_to_takeAttendanceFragment,
            null,
            null,
            null
        )
    }

}