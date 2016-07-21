import java.io.PrintStream;

public class Card {
	//this creates card stats
	public String suit;
	public String valuePrintedOut;
	public boolean isTurnedOverBack;
	public int valueNotPrintedOut;
	//this sets card stats
	public Card (String cardSuit, String valuePO, boolean isOnBack, int valueNPO) {
		suit = cardSuit;
		valuePrintedOut = valuePO;
		isTurnedOverBack = isOnBack;
		valueNotPrintedOut = valueNPO;
	}
	//prints "valuePrintedOut" and "suit"
	public void print(){
		System.out.print(valuePrintedOut + " of " + suit);
	}
	public void printToFile(PrintStream printToSolitsav) {
		printToSolitsav.print(valuePrintedOut + " of " + suit);
	}
}
