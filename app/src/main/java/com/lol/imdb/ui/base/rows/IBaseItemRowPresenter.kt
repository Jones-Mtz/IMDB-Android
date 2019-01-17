package com.lol.imdb.ui.base.rows

/**
 * Created by Jones on 17/01/19.
 */
interface IBaseItemRowPresenter<IRowView : IBaseRowView> {
    fun onBindRowViewAtPosition(iView: IRowView, position: Int)
    fun getRowsCount(): Int
}