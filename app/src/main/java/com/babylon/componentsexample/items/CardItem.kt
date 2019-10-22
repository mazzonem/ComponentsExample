package com.babylon.componentsexample.items

import com.babylon.componentsexample.R
import com.babylon.componentsexample.extension.show
import com.babylon.componentsexample.items.input.ImageValue
import com.babylon.componentsexample.items.input.ItemAction
import com.babylon.componentsexample.items.input.StringValue
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.item_card.view.*

data class CardItem(
    val title: StringValue,
    val subtitle: StringValue? = null,
    val icon: ImageValue? = null,
    val onClick: ItemAction? = null
) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.apply {
            title.applyTo(titleView)

            subtitleView.show(subtitle != null)
            subtitle?.applyTo(subtitleView)

            iconView.show(icon != null)
            icon?.applyTo(iconView)

            isClickable = onClick != null
            onClick?.let { action -> setOnClickListener { action.actionCallback() } }
        }
    }

    override fun getLayout() = R.layout.item_card

    override fun getId() = hashCode().toLong()
}
