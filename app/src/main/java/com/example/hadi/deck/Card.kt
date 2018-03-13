package com.example.hadi.deck

import java.io.OutputStream

/**
 * Card data class
 * @property suit is the suit of the card
 * @property rank is the rank(value) o this card
 * @constructor Creates a Card given a suit and a rank
 *
 */
class Card(private val suit: Suits,
           private val rank: Ranks) : Null() {

    /**
     * Overriding the toString of the card data class
     * @return String in the following format: Card: rank of suit
     */
    override fun toString(): String {
        return "Card: $rank of $suit"
    }

    /**
     * Prints the Card
     */
    override fun print(outputStream: OutputStream) = outputStream.write((this.toString() + "\r\n").toByteArray())

}

/**
 * Enumerate the different possibilities of Suits
 */
enum class Suits {
    CLUBS, DIAMONDS, HEARTS, SPADES
}

/**
 * Enumerate the different possibilities of Ranks
 */
enum class Ranks(val value: Int) {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
    EIGHT(8), NINE(9), TEN(10), JACK(11), QUEEN(12), KING(13)
}
