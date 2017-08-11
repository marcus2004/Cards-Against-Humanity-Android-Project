package com.example.cardsagainsthumanity;

import java.util.ArrayList;

/**
 * Created by rossmelville on 11/08/2017.
 */

public class Deck {

    private ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();
    }

    public ArrayList<Card> getDeck() {
        return new ArrayList<Card>(deck);
    }


    public void addCard(Card card) {
        deck.add(card);
    }
}