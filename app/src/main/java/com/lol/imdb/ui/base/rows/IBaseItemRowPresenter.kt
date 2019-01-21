package com.lol.imdb.ui.base.rows

/**
 * Created by Jones on 17/01/19.
 * I´ve replaced IBaseRow by Any cause base interface is empty,
 * if I could imagine some methods to add I will return to it belongs.
 * Therefore final kind of view interface is defined by presenter that extends IBaseItemRowPresenter
 */
//                              IRowView : IBaseRowView
interface IBaseItemRowPresenter<IRowView : Any> {
    fun onBindRowViewAtPosition(iView: IRowView, position: Int)
    fun getRowsCount(): Int
}