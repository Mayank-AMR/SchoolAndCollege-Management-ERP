package com.mayank_amr.schoolmanagementproduct.assignment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mayank_amr.schoolmanagementproduct.dumywork.MovieRepository
import com.mayank_amr.schoolmanagementproduct.dumywork.responce.Movie
import com.mayank_amr.schoolmanagementproduct.utils.Coroutines
import kotlinx.coroutines.Job

class AssignmentHomeViewModel(
    private val repository: MovieRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>>
        get() = _movies // Here we return live data outside bz it can't be changed.

    fun getMovies() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _movies.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }

}