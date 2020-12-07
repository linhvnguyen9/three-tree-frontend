package com.e17cn2.threetree.android.view

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.e17cn2.threetree.android.R
import com.e17cn2.threetree.entity.SuiteCard
import com.e17cn2.threetree.android.utils.getEnum

class PlayingCardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
    private var suiteCard: SuiteCard
    private var value: Int?

    init {
        inflate(context, R.layout.item_card, this)

        context.theme.obtainStyledAttributes(attrs, R.styleable.PlayingCardView, 0, 0).apply {
            try {
                suiteCard = getEnum(R.styleable.PlayingCardView_suite, SuiteCard.SPADE)
                value = getInt(R.styleable.PlayingCardView_value, 1)

                val suiteRes = when (suiteCard) {
                    SuiteCard.SPADE -> R.drawable.ic_spade
                    SuiteCard.CLUBS -> R.drawable.ic_clubs
                    SuiteCard.HEARTS -> R.drawable.ic_hearts
                    SuiteCard.DIAMONDS -> R.drawable.ic_diamond
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

    fun setSuite(suiteCard: SuiteCard) {
        this.suiteCard = suiteCard
        val suiteRes = when (suiteCard) {
            SuiteCard.SPADE -> R.drawable.ic_spade
            SuiteCard.CLUBS -> R.drawable.ic_clubs
            SuiteCard.HEARTS -> R.drawable.ic_hearts
            SuiteCard.DIAMONDS -> R.drawable.ic_diamond
        }
        findViewById<ImageView>(R.id.image_suite).setImageResource(suiteRes)
//        requestLayout()
    }

    fun setValue(value: Int) {
        this.value = value
        val valueString = when (value) {
            1 -> "A"
            else -> value.toString()
        }
        findViewById<TextView>(R.id.text_value).text = valueString
//        requestLayout()
    }
}