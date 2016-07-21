import java.io.PrintStream;
import java.util.*;
public class Aces {
	public String suitAssigner;
	public Vector<Card> dealAces = new Vector<Card>();
	public Aces(String aceSuit) {
		suitAssigner = aceSuit;
	}
	//doesn't let you move a card to the wrong ace stack
	public boolean cardChecker(Card check) {
		if(suitAssigner.compareToIgnoreCase(check.suit) == 0) {
			System.out.println("Sorry, this card cannot go here.");
			System.out.println("Card returned to past location.");
			return false;
		}
		else {
			if(dealAces.size() == (check.valueNotPrintedOut) - 1) {
				dealAces.addElement(check);
				return true;
			}
			else {
				System.out.println("Sorry, this card cannot go here.");
				System.out.println("Card returned to past location.");
				return false;
			}
		}
	}
	public void print() {
		if(dealAces.size() != 0) {
			dealAces.lastElement().print();
		}
	}
	public boolean youWin() {
		if(dealAces.size() == 13) {
			return true;
		}
		else {
			return false;
		}
	}
	public void printToSolitsav(PrintStream printAce) {
		if(dealAces.size() != 0) {
			dealAces.lastElement().printToFile(printAce);
		}
		else {
			printAce.println(suitAssigner + " ace stack is empty");
		}
	}
}
