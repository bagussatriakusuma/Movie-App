package com.example.challengechapter5.UI

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.challengechapter5.MovieDetails
import com.example.challengechapter5.Repository.NetworkState
import io.reactivex.disposables.CompositeDisposable

class MovieViewModel(
    private val movieRepository: MovieDetailsRepository,
    movieId: Int
) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val movieDetails: LiveData<MovieDetails> by lazy {
        movieRepository.fetchMovieDetails(compositeDisposable, movieId)
    }

    val networkState: LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()

        compositeDisposable.dispose()
    }
}