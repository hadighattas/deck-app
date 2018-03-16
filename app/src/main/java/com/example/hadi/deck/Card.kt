package com.example.hadi.deck

import java.io.OutputStream


/**
 * Card class
 * @property suit is the suit of the card
 * @property rank is the rank(value) o this card
 * @constructor Creates a Card given a suit and a rank
 *
 */
class Card(private val suit: Suits,
           private val rank: Ranks) : Null() {

    /**
     * Overriding the toString method
     * @return String in the following format: "Card: rank of suit"
     */
    override fun toString(): String {
        return "Card: $rank of $suit"
    }

    /**
     * Prints the Card to a given OutputStream
     * @param outputStream
     */
    override fun print(outputStream: OutputStream) {
        outputStream.write((this.toString() + "\r\n").toByteArray())
    }
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
enum class Ranks {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN,
    EIGHT, NINE, TEN, JACK, QUEEN, KING
}
