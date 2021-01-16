package com.mayank_amr.schoolmanagementproduct.assignment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mayank_amr.schoolmanagementproduct.R
import com.mayank_amr.schoolmanagementproduct.assignment.recyclerview.AssignmentsAdapter
import com.mayank_amr.schoolmanagementproduct.dumywork.MovieRepository
import com.mayank_amr.schoolmanagementproduct.network.MyApi
import com.mayank_amr.schoolmanagementproduct.network.NetworkConnectionInterceptor
import kotlinx.android.synthetic.main.assignment_home_fragment.*
import org.kodein.di.KodeinAware

class AssignmentHomeFragment : Fragment()/*, KodeinAware*/ {

    companion object {
        fun newInstance() = AssignmentHomeFragment()
    }

    //override val kodein by kodein()

    //    private lateinit var factory: AssignmentHomeViewModelFactory
    //private val factory: AssignmentHomeViewModelFactory by instance()
    private lateinit var factory: AssignmentHomeViewModelFactory

    // private val viewModel: AssignmentHomeViewModel by viewModels()
    private lateinit var viewModel: AssignmentHomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.assignment_home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        //ToDo: Remove dummy data and dependency
        val interceptor = this.context?.let { NetworkConnectionInterceptor(it?.applicationContext) }
        val api = interceptor?.let { MyApi(it) }
        val repository = api?.let { MovieRepository(it) }
        factory = repository?.let { AssignmentHomeViewModelFactory(it) }!!
        viewModel = ViewModelProvider(this, factory).get(AssignmentHomeViewModel::class.java)


        viewModel.getMovies()
        viewModel.movies.observe(viewLifecycleOwner, Observer { movies ->
            recycler_view_assignments.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = AssignmentsAdapter(movies)
            }
        })
    }
}