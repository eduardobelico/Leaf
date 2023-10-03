package com.example.leaf.data.remote.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.leaf.data.remote.model.TrendingWorkDto

class TrendingBooksPagingSource(
    private val services: BookSearchServices
): PagingSource<Int, TrendingWorkDto>() {
    
    override fun getRefreshKey(state: PagingState<Int, TrendingWorkDto>): Int? =
        state.anchorPosition
    
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, TrendingWorkDto> {
        val currentPage = params.key ?: 1
        val limit = 20
        val offset = currentPage * limit
        return try {
            val response = services.getTrendingBooks(
                limit = limit,
                offset = offset
            )
            val trendingWorkList = response.works
            LoadResult.Page(
                data = trendingWorkList,
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (trendingWorkList.isEmpty()) null else currentPage + 1
            )
        } catch (e: Exception) {
            Log.e("Error fetching works", "${e.message}")
            LoadResult.Error(e)
        }
    }
}