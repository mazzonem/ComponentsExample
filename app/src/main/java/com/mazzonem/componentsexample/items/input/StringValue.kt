package com.mazzonem.componentsexample.items.input

import android.widget.TextView
import androidx.annotation.StringRes

interface StringValue {
    fun applyTo(textView: TextView)
}

data class StringId(
    @StringRes val id: Int
) : StringValue {
    override fun applyTo(textView: TextView) {
        textView.setText(id)
    }
}

data class Text(
    val text: CharSequence?
) : StringValue {
    override fun applyTo(textView: TextView) {
        textView.text = text
    }
}
