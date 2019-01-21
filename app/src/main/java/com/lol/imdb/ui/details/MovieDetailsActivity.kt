package com.lol.imdb.ui.details

import android.os.Bundle
import com.lol.imdb.R
import com.lol.imdb.ui.base.BaseActivity

class MovieDetailsActivity : BaseActivity(), MovieDetailsContract.IMovieDetailsView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
    }


}
