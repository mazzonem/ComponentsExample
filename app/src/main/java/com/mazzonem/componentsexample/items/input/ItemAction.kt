package com.mazzonem.componentsexample.items.input

open class ItemAction(
    open val actionCallback: (() -> Unit)
) {
    override fun equals(other: Any?): Boolean {
        return other is ItemAction
    }

    override fun hashCode(): Int {
        return true.hashCode()
    }
}
