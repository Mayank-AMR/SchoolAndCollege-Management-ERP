package com.mayank_amr.schoolmanagementproduct.classattendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.classattendance.attendancerecyclerview.AttendanceAdapter
import kotlinx.android.synthetic.main.take_attendance_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class TakesAttendanceFragment : Fragment(), KodeinAware, AdapterView.OnItemSelectedListener {

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
                it.adapter = AttendanceAdapter(students)
            }
        })

        /*------------------** Spinner **---------------------------------------------------------*/
        val languages = arrayOf("One", "Two", "Three", "Four", "Five", "Six")

        // Create an ArrayAdapter using a simple spinner layout and array
        val aa = activity?.let {
            ArrayAdapter(
                it?.applicationContext,
                android.R.layout.simple_spinner_item,
                languages
            )
        }

        // Set layout to use when the list of choices appear
        aa?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Set Adapter to Spinner
        classes_spinner!!.adapter = aa




        /*---------------------*** Second Spinner ***---------------------------------------------*/

        val personNames = arrayOf("A", "B", "C", "D", "E", "F", "G")
        val spinner = sections_spinner
        if (spinner != null) {
            val arrayAdapter = activity?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_spinner_item,
                    personNames
                )
            }
            arrayAdapter?.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            spinner.adapter = arrayAdapter

            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        activity,
                        "Selected Item: " + " " + personNames[position],
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // Code to perform some action when nothing is selected
                    Toast.makeText(activity, "Please select section: ", Toast.LENGTH_SHORT).show()

                }
            }
        }


        /*----------------------------------------------------------------------------------------*/
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(activity, "position: " + position, Toast.LENGTH_SHORT).show();
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        Toast.makeText(activity, "Nothing Selected ", Toast.LENGTH_SHORT).show();
    }


}