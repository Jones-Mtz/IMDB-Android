package com.lol.imdb.ui.feed

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lol.imdb.R
import com.lol.imdb.ui.base.BaseFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named

private const val OPERATION_MODE = "mode"


class MovieFeedFragment : BaseFragment(), IMovieFeedView {

    @Named("lol")
    @Inject
    lateinit var message: String

    @Inject
    lateinit var presenter: IMovieFeedPresenter<IMovieFeedView>

    private var operationMode: Int? = null
    private var listener: IMovieItemClicked? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            operationMode = it.getInt(OPERATION_MODE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onAttach(this)
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface IMovieItemClicked {
        fun itemClicked(id: Int)
    }

    companion object {
        @JvmStatic
        fun newInstance(operationMode: Int) =
            MovieFeedFragment().apply {
                arguments = Bundle().apply {
                    putInt(OPERATION_MODE, operationMode)
                }
            }
    }
}
