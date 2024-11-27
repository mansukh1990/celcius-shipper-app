package com.example.mvvmroomdatabasedaggerhiltpractice.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

abstract class EndlessRecyclerViewScrollListener(
    private val layoutManager: RecyclerView.LayoutManager?,
    private val swipeRefreshLayout: SwipeRefreshLayout? = null,
    private val onRefreshAction: () -> Unit = {}
) :
    RecyclerView.OnScrollListener(), SwipeRefreshLayout.OnRefreshListener {

    private var visibleThreshold = 5
    private var currentPage = 0
    private var previousTotalItemCount = 0
    private var loading = true
    private var startingPageIndex = 0

    init {
        if (layoutManager is GridLayoutManager) {
            visibleThreshold *= layoutManager.spanCount
        } else if (layoutManager is StaggeredGridLayoutManager) {
            visibleThreshold *= layoutManager.spanCount
        }
        swipeRefreshLayout?.setOnRefreshListener(this)

        onRefreshAction.invoke()
    }

    override fun onRefresh() {
        onRefreshAction.invoke()
        resetState()
    }

    override fun onScrolled(view: RecyclerView, dx: Int, dy: Int) {
        var lastVisibleItemPosition = 0
        val totalItemCount = layoutManager?.itemCount

        /* if (currentPage == startingPageIndex) {
             resetState()
         }*/

        when (layoutManager) {
            is StaggeredGridLayoutManager -> {
                val lastVisibleItemPositions =
                    (layoutManager as StaggeredGridLayoutManager).findLastVisibleItemPositions(null)
                lastVisibleItemPosition = getLastVisibleItem(lastVisibleItemPositions)
            }

            is GridLayoutManager -> {
                lastVisibleItemPosition =
                    (layoutManager as GridLayoutManager).findLastVisibleItemPosition()
            }

            is LinearLayoutManager -> {
                lastVisibleItemPosition =
                    (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            }
        }

        if (totalItemCount != null) {
            if (totalItemCount < previousTotalItemCount) {
                currentPage = startingPageIndex
                previousTotalItemCount = totalItemCount
                if (totalItemCount == 0) {
                    loading = true
                }
            }
        }

        if (totalItemCount != null) {
            if (loading && totalItemCount > previousTotalItemCount) {
                loading = false
                previousTotalItemCount = totalItemCount
            }
        }

        if (!loading && (lastVisibleItemPosition + visibleThreshold) > totalItemCount!!) {
            currentPage++
            Logger.e("loadmore")
            onLoadMore(currentPage, totalItemCount, view)
            loading = true
        }

        val topRowVerticalPosition =
            if (view.childCount == 0) 0 else view.getChildAt(0).top
        swipeRefreshLayout?.isEnabled = topRowVerticalPosition >= 0


    }

    fun resetState() {
        currentPage = startingPageIndex
        previousTotalItemCount = 0
        loading = true
    }

    abstract fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView)

    private fun getLastVisibleItem(lastVisibleItemPositions: IntArray): Int {
        var maxSize = 0
        for (i in lastVisibleItemPositions.indices) {
            if (i == 0 || lastVisibleItemPositions[i] > maxSize) {
                maxSize = lastVisibleItemPositions[i]
            }
        }
        return maxSize
    }
}
