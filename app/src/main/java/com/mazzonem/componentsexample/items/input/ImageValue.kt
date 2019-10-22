package com.mazzonem.componentsexample.items.input

import android.widget.ImageView
import androidx.annotation.DrawableRes

interface ImageValue {
    fun applyTo(imageView: ImageView)
}

data class DrawableId(
    @DrawableRes val id: Int
) : ImageValue {
    override fun applyTo(imageView: ImageView) {
        imageView.setImageResource(id)
    }
}
