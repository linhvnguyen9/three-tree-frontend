package com.e17cn2.threetree.entity

import java.io.Serializable

data class Card(
    val suiteCard: SuiteCard,
    val value: Int
) : Serializable {
    companion object {
        val serialVersionUID = 1L
    }
}