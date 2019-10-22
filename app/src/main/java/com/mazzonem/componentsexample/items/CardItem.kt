package com.mazzonem.componentsexample.items

import com.mazzonem.componentsexample.R
import com.mazzonem.componentsexample.extension.show
import com.mazzonem.componentsexample.items.input.ImageValue
import com.mazzonem.componentsexample.items.input.ItemAction
import com.mazzonem.componentsexample.items.input.StringValue
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
