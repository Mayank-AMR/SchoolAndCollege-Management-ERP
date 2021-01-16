package com.mayank_amr.schoolmanagementproduct.profile

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.mayank_amr.schoolmanagementproduct.R
import kotlinx.android.synthetic.main.student_profile_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance


class StudentProfileFragment : Fragment(), KodeinAware {

    companion object {
        fun newInstance() = StudentProfileFragment()
    }

    override val kodein by kodein()
    private val factory: ProfileViewModelFactory by instance()


    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.student_profile_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this, factory).get(ProfileViewModel::class.java)
        // TODO: Use the ViewModel

        textViewStudentProfileEmail.setOnClickListener(View.OnClickListener {

            sendEmail("mayankkumarrawat69@gmail.com")
        })




        materialCardViewProfileAttendance.setOnClickListener{
            val extras = FragmentNavigatorExtras(
                materialCardViewProfileAttendance to "attendancePercentageTransition"
            )
            findNavController().navigate(R.id.action_studentProfileFragment_to_attendanceDetailFragment, null, null, extras)
        }


    }


    private fun sendEmail(email: String) {
        Log.i("Send email", "")

        val TO = arrayOf(email)
        // val CC = arrayOf("")
        val emailIntent = Intent(Intent.ACTION_SEND)
        val subject = "From ABCD School: "

        emailIntent.data = Uri.parse("mailto:")
        emailIntent.type ="message/rfc822" // "text/plain"
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO)
        // emailIntent.putExtra(Intent.EXTRA_CC, CC)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
        //emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here")
        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."))
            Log.i("Finish Sending email..", "")
        } catch (ex: ActivityNotFoundException) {
            Toast.makeText(activity, "There is no email client installed.", Toast.LENGTH_SHORT)
                .show()
        }
    }

}