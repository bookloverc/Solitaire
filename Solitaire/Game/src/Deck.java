import java.util.*;

public class Deck {
	//holds all cards
	public Vector<Card> deck = new Vector<Card> ();
	
	public Deck() {
		int j = 1;
		//j sets suit
		String suits = null;
		while(j < 5) {
			if (j == 1) {
				suits = "spades";
			}
			if (j == 2) {
				suits = "clubs";
			}
			if (j == 3) {
				suits = "hearts";
			}
			if (j == 4) {
				suits = "diamonds";
			}
			for(int i = 1; i < 14; i++){
				//this puts all cards into vector
				if (i == 1){
					deck.add(new Card(suits, "Ace", false, i));
				}
				else if (i == 11){
					deck.add(new Card(suits, "Jack", false, i));
				}
				else if(i == 12) {
					deck.add(new Card(suits, "Queen", false, i));
				}
				else if(i == 13) {
					deck.add(new Card(suits, "King", false, i));
				}
				else {
					deck.add(new Card(suits, Integer.toString(i), false, i));
				}
				
			}
			j++;
		}
	}
	public void print() {
		//this prints the cards, or rather, all the stuff that's in the vector
		for(int i = 0; i < deck.size(); i++){
				deck.get(i).print();
		}	
	}
	//shuffles deck
	public void shuffle() {
		Collections.shuffle(deck);
	}
	//draws a given number of cards off the deck
	public Vector<Card> draw(int cardsDrawn) {
		Vector<Card> drawIt = new Vector<Card>();
		for(int i = 0; i < cardsDrawn; i++) {
			drawIt.addElement(deck.get(i));
			deck.remove(i);
		}
		return drawIt;
	}
	public void returnCards(Vector<Card> returnToDeck) {
		deck.addAll(returnToDeck);
	}
	//returns the deck size at the moment
	public int returnDeckValue() {
		return deck.size();
	}
	public void add(Vector<Card> workPile) {
		deck.addAll(workPile);
		return;
	}
}		