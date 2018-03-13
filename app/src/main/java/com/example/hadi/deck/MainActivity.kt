package com.example.hadi.deck

import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.io.ByteArrayOutputStream
import android.support.design.widget.Snackbar


class MainActivity : AppCompatActivity() {

    private var mDeck = Deck()
    private val mByteArrayOutputStream = ByteArrayOutputStream()

    val ranksMap: Map<String, String> = mapOf("ACE" to "A", "TWO" to "2", "THREE" to "3", "FOUR" to "4", "FIVE" to "5", "SIX" to "6",
            "SEVEN" to "7", "EIGHT" to "8", "NINE" to "9", "TEN" to "10", "JACK" to "J", "QUEEN" to "Q", "KING" to "K")

    val suitsMap: Map<String, Int> = mapOf("CLUBS" to R.drawable.ic_card_clubs, "DIAMONDS" to R.drawable.ic_card_diamonds, "HEARTS" to R.drawable.ic_card_hearts, "SPADES" to R.drawable.ic_card_spades)

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun shuffleDeck(view: View) {
        mDeck.shuffle()
        Snackbar.make(view, "Deck shuffled", Snackbar.LENGTH_SHORT).show()
        iv_card.setImageDrawable(getDrawable(R.drawable.ic_card_back))
    }

    fun dealCard(view: View) {
        mDeck.dealOneCard().print(mByteArrayOutputStream)
        val cardName = mByteArrayOutputStream.toString().trim()
        mByteArrayOutputStream.reset()
        val cardParameters = cardName.split(" ")

        if (cardParameters[0] == "Null") {
            iv_card.setImageDrawable(getDrawable(R.drawable.ic_card_back))
            Snackbar.make(view, "New deck dealt", Snackbar.LENGTH_SHORT).show()
            mDeck = Deck()
            return
        }

        print(cardParameters)
        val suit = cardParameters[3]
        val rank = cardParameters[1]
        iv_card.setImageDrawable(getDrawable(suitsMap[suit]!!))

        tv_rank_1.text = ranksMap[rank]
        tv_rank_2.text = ranksMap[rank]

    }

    fun refreshDeck (view: View) {
        mDeck = Deck()
        iv_card.setImageDrawable(getDrawable(R.drawable.ic_card_back))
        Snackbar.make(view, "New deck dealt", Snackbar.LENGTH_SHORT).show()
    }


/*
//    fun stringToDrawable(suit: String): Drawable {
//        when (suit) {
//            "CLUBS" -> return getDrawable(R.drawable.ic_card_clubs)
//            "DIAMONDS" -> return getDrawable(R.drawable.ic_card_diamonds)
//            "HEARTS" -> return getDrawable(R.drawable.ic_card_hearts)
//            "SPADES" -> return getDrawable(R.drawable.ic_card_spades)
//        }
//        return getDrawable(R.drawable.ic_card_back)
//    }

//    fun rankToString(rank: String): String {
//        when (rank) {
//            "ACE" -> return "A"
//            "TWO" -> return "2"
//            "THREE" -> return "3"
//            "FOUR" -> return "4"
//            "FIVE" -> return "5"
//            "SIX" -> return "6"
//            "SEVEN" -> return "7"
//            "EIGHT" -> return "8"
//            "NINE" -> return "9"
//            "TEN" -> return "10"
//            "JACK" -> return "J"
//            "QUEEN" -> return "Q"
//            "KING" -> return "K"
//        }
//        return ""
//    }*/

}
