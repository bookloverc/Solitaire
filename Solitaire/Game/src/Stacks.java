import java.io.PrintStream;
import java.util.Vector;

public class Stacks {
	public Vector<Card> dealStacks = new Vector<Card>();
	public int reverseNumbers = 0;
	public Stacks(Vector<Card> stacks, int cardNumberCaller) {
		dealStacks = stacks;
		reverseNumbers = cardNumberCaller;
		for(int i = dealStacks.size() - 1; i >= 0; i--) {
			if(i == stacks.size() - 1) {
				dealStacks.get(i).isTurnedOverBack = false;
			} 
			else {
				dealStacks.get(i).isTurnedOverBack = true;
			}
		}	
	}
	//prints stack and checks if cards are flipped over
	public void print() {
		System.out.println();
		System.out.println("Stack " + reverseNumbers);
		for(int i = 0; i <= dealStacks.size() - 1; i++) {
			if (dealStacks.get(i).isTurnedOverBack == false) {
				System.out.print((i + 1) + ": ");
				dealStacks.get(i).print();
				System.out.print(" ");
			}
			else {
				System.out.print((i + 1) + ": " + "??? ");
			}
		}
	}
	public void printToSolitsav(PrintStream printStacks) {

		printStacks.println();
		printStacks.println("Stack " + reverseNumbers);
		for(int i = 0; i <= dealStacks.size() - 1; i++) {
			if (dealStacks.get(i).isTurnedOverBack == false) {
				printStacks.print((i + 1) + ": ");
				dealStacks.get(i).printToFile(printStacks);
				printStacks.print(" @");
			}
			else {
				printStacks.print((i + 1) + ": ");
				dealStacks.get(i).printToFile(printStacks);
				printStacks.print("# @");
			}
		}
	
	}
	
	public Vector<Card> get (int nOC) {
		Vector<Card> take = new Vector<Card>();
		for(int i = 0; i < nOC; i++) {
			Card check = (dealStacks.get(dealStacks.size()- 1 - i));
			if (check.isTurnedOverBack == false){
				take.insertElementAt(check, 0);
			}
			else {
				return null;
			}
		}
		return take;
		
	}
	public boolean stackPermissions(Card below) {
		Card above = dealStacks.get(dealStacks.size() - 1);
		if (above.suit.equals("hearts") || above.suit.equals("diamonds")) {
			if (below.suit.equals("spades") || below.suit.equals("clubs")) {
				int aboveNum = above.valueNotPrintedOut;
				int belowNum = below.valueNotPrintedOut;
				if (aboveNum - 1 == belowNum) {
					return true;				}
				else {
					System.out.println("Sorry, this card cannot go here.");
					System.out.println("Card returned to past location.");
					return false;
				}
			}
			else {
				System.out.println("Sorry, this card cannot go here.");
				System.out.println("Card returned to past location.");
				return false;
			}
		}
		else {
			if (below.suit.equals("hearts") || below.suit.equals("diamonds")) {
				int aboveNum = above.valueNotPrintedOut;
				int belowNum = below.valueNotPrintedOut;
				if (aboveNum - 1 == belowNum) {
					return true;				}
				else {
					System.out.println("Sorry, this card cannot go here.");
					System.out.println("Card returned to past location.");
					return false;
				}
			}
			else {
				System.out.println("Sorry, this card cannot go here.");
				System.out.println("Card returned to past location.");
				return false;
			}
		
			
		}	
	}		
	public void turnOverTopCard() {
		if (dealStacks.size() != 0) {
			dealStacks.lastElement().isTurnedOverBack = false;
		}
	}
	public void deleteTopCards(Vector<Card> cardsMoved) {
		dealStacks.removeAll(cardsMoved);
	}
	public Stacks(int cardNumberCaller) {
		reverseNumbers = cardNumberCaller;
	}
}
