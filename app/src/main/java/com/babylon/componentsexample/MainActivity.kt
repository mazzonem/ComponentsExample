package com.babylon.componentsexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.babylon.componentsexample.decoration.CardItemDecoration
import com.babylon.componentsexample.items.ButtonItem
import com.babylon.componentsexample.items.CardItem
import com.babylon.componentsexample.items.input.DrawableId
import com.babylon.componentsexample.items.input.ItemAction
import com.babylon.componentsexample.items.input.StringId
import com.babylon.componentsexample.items.input.Text
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val shuffleSection = Section()
    private val updateSection = Section()

    private var state = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        content.apply {
            adapter = GroupAdapter<GroupieViewHolder>().apply {
                add(shuffleSection)
                add(updateSection)
            }
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(
                CardItemDecoration(
                    resources.getDimensionPixelSize(
                        R.dimen.padding_normal
                    )
                )
            )
        }

        renderShuffled()
        renderCount()
    }

    private fun renderShuffled() {
        shuffleSection.update(
            listOf(
                CardItem(title = StringId(R.string.app_name)),
                CardItem(
                    title = StringId(R.string.app_name),
                    subtitle = Text("This is a subtitle")
                ),
                CardItem(
                    title = StringId(R.string.app_name),
                    icon = DrawableId(R.drawable.ic_android_24dp)
                ),
                CardItem(
                    title = StringId(R.string.app_name),
                    subtitle = Text("This is a subtitle"),
                    icon = DrawableId(R.drawable.ic_android_24dp)
                ),
                ButtonItem(
                    title = Text("Tap to shuffle content"),
                    onClick = ItemAction { renderShuffled() })
            ).shuffled()
        )
    }

    private fun renderCount() {
        updateSection.update(
            listOf(
                CardItem(title = Text("Value: $state")),
                ButtonItem(
                    title = Text("Tap to increment"),
                    onClick = ItemAction { updateValueState() })
            )
        )
    }

    private fun updateValueState() {
        state += 1
        renderCount()
    }
}
