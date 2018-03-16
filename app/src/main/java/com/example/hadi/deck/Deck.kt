package com.example.hadi.deck

import java.io.OutputStream

/**
 * Deck class
 * @property cards Mutable List of Card
 * @constructor Populates Cards with all 52 cards in a regular deck
 */


class Deck {

    var cards: MutableList<Card> = mutableListOf()

    init {
        for (suit in Suits.values())
            for (rank in Ranks.values())
                cards.add(Card(suit, rank))
    }

    /**
     * Shuffles the cards list
     */
    fun shuffle() = cards.shuffle()

    /**
     * Removes the first card form the cards list
     * @return Card if deck is not empty
     * @note use with ?. as the return type is nullable
     */
    fun dealOneCard(): Null {
        if (cards.isNotEmpty())
            return cards.removeAt(0)
        else
            return Null()
    }

    /**
     *@return Size of the deck
     */
    fun getSize(): Int = cards.size

    /**
     * Prints all the deck to a given OutputStream
     * @param outputStream
     */
    fun print(outputStream: OutputStream) = cards.forEach { card -> card.print(outputStream) }


}