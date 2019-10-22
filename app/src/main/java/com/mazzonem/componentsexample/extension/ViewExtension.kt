package com.mazzonem.componentsexample.extension

import android.view.View

fun View.show(visible: Boolean) {
    if (visible) this.visibility = View.VISIBLE
    else this.visibility = View.GONE
}
