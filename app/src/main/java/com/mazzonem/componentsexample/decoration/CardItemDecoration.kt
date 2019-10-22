package com.mazzonem.componentsexample.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class CardItemDecoration(
    private val horizontalSpacing: Int,
    private val verticalSpacing: Int
) : RecyclerView.ItemDecoration() {

    constructor(spacing: Int) : this(spacing, spacing)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val size = parent.adapter?.itemCount

        outRect.left = horizontalSpacing
        outRect.right = horizontalSpacing
        outRect.top = if (position == 0) verticalSpacing else verticalSpacing / 2
        outRect.bottom = if (position + 1 == size) verticalSpacing else verticalSpacing / 2
    }
}