package com.e17cn2.threetree.android.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.e17cn2.threetree.android.R
import com.e17cn2.threetree.android.domain.model.Suite
import com.e17cn2.threetree.android.utils.getEnum
import com.google.android.material.card.MaterialCardView

class PlayingCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    private var suite: Suite
    private var value: Int?

    init {
        inflate(context, R.layout.item_card, this)

        context.theme.obtainStyledAttributes(attrs, R.styleable.PlayingCardView, 0, 0).apply {
            try {
                suite = getEnum(R.styleable.PlayingCardView_suite, Suite.SPADES)
                value = getInt(R.styleable.PlayingCardView_value, 1)

                val suiteRes = when (suite) {
                    Suite.SPADES -> R.drawable.ic_spade
                    Suite.CLUBS -> R.drawable.ic_clubs
                    Suite.HEARTS -> R.drawable.ic_hearts
                    Suite.DIAMONDS -> R.drawable.ic_diamond
                }

                findViewById<ImageView>(R.id.image_suite).setImageResource(suiteRes)

                val valueString = when (value) {
                    1 -> "A"
                    else -> value.toString()
                }
                findViewById<TextView>(R.id.text_value).text = valueString
            } finally {
                recycle()
            }
        }
    }

    fun setSuite(suite: Suite) {
        this.suite = suite
        invalidate()
        requestLayout()
    }

    fun setValue(value: Int) {
        this.value = value
        invalidate()
        requestLayout()
    }
}