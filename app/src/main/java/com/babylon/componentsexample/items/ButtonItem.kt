package com.babylon.componentsexample.items

import com.babylon.componentsexample.R
import com.babylon.componentsexample.items.input.ItemAction
import com.babylon.componentsexample.items.input.StringValue
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_button.view.*

data class ButtonItem(
    val title: StringValue,
    val onClick: ItemAction
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            title.applyTo(buttonView)
            setOnClickListener { onClick.actionCallback() }
        }
    }

    override fun getLayout() = R.layout.item_button

    override fun getId() = hashCode().toLong()
}
