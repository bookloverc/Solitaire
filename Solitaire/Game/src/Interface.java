import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

import javax.accessibility.Accessible;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
public class Interface extends JComponent implements Accessible{
	public Scanner userInput = new Scanner(System.in);
	//declares deck
	public Deck solitaire = new Deck();
	public Vector<Card> workPile = new Vector<Card>();
	public Stacks stack1;
	public Stacks stack2;
	public Stacks stack3;
	public Stacks stack4;
	public Stacks stack5;
	public Stacks stack6;
	public Stacks stack7;
	public Aces aceHearts;
	public Aces aceClubs;
	public Aces aceDiamonds;
	public Aces aceSpades;
	public int noMoves = 0;
	public boolean drawCount = true;
	public void beginInput() throws InterruptedException, FileNotFoundException {
		boolean onOff = false;
		while(onOff == false) { 
		
			System.out.println("Welcome to Solitaire. Type 'New' to start, type 'Continue' to upload a save file.");
			String input = userInput.nextLine();
			if (input.equalsIgnoreCase("New")) {
				onOff = true;
				transferStacks();
			}
			else if (input.equalsIgnoreCase("Continue")) {
				readIn();
			}
			else {
				System.out.println("Sorry, I can't understand '" + input + "'. Please try again.");
			}
		}
	}
	public void transferStacks() throws InterruptedException, FileNotFoundException {
				//shuffles the deck
				solitaire.shuffle();
				//draws three cards off the top of the deck
				Vector<Card> drawThree = new Vector<Card>();
				drawThree = solitaire.draw(3);
				Vector<Card> draw7 = new Vector<Card>();
				draw7 = solitaire.draw(7);
				stack1 = new Stacks(draw7, 1);
				Vector<Card> draw6 = new Vector<Card>();
				draw6 = solitaire.draw(6);
				stack2 = new Stacks(draw6, 2);
				Vector<Card> draw5 = new Vector<Card>();
				draw5 = solitaire.draw(5);
				stack3 = new Stacks(draw5, 3);
				Vector<Card> draw4 = new Vector<Card>();
				draw4 = solitaire.draw(4);
				stack4 = new Stacks(draw4, 4);
				Vector<Card> draw3 = new Vector<Card>();
				draw3 = solitaire.draw(3);
				stack5 = new Stacks(draw3, 5);
				Vector<Card> draw2 = new Vector<Card>();
				draw2 = solitaire.draw(2);
				stack6 = new Stacks(draw2, 6);
				Vector<Card> draw1 = new Vector<Card>();
				draw1 = solitaire.draw(1);
				stack7 = new Stacks(draw1, 7);
				aceHearts = new Aces("hearts");
				aceClubs = new Aces("clubs");
				aceDiamonds = new Aces("diamonds");
				aceSpades = new Aces("spades");
				printAll();
				System.out.println();
				System.out.println("Commands: move, undo, redo, save, draw");
				System.out.println("Move command: Type 'move', hit 'enter', then stack # found in README, hit Enter again, then # of cards you want to move, then stack you want to move them to.");
				System.out.println("Undo command: Type 'undo' and hit Enter.");
				System.out.println("Redo command: Type 'redo' and hit Enter.");
				System.out.println("Save command: Type 'save' and hit Enter. ***WARNING: Don't try to mess with the save files.***");
				System.out.println("Draw command: Type 'draw' and hit Enter. This will draw three cards.");
				System.out.println("Deck is shuffled and dealt. Please input.");
				while(true){
					if ((solitaire.returnDeckValue() / 3) + 1 <= noMoves) {
						System.out.println("You Lose, Sorry!!!!!!!!!");
						Thread.sleep(1000);
						System.exit(0);
					}
					gameRules();
					
				}
				
		}
	
	public Stacks giveMeStack (String commands) {
		if (commands.equalsIgnoreCase("stack1")) {
			return stack1;
		}
		if (commands.equalsIgnoreCase("stack2")) {
			return stack2;
		}
		if (commands.equalsIgnoreCase("stack3")) {
			return stack3;
		}
		if (commands.equalsIgnoreCase("stack4")) {
			return stack4;
		}
		if (commands.equalsIgnoreCase("stack5")) {
			return stack5;
		}
		if (commands.equalsIgnoreCase("stack6")) {
			return stack6;
		}
		if (commands.equalsIgnoreCase("stack7")) {
			return stack7;
		}
		return null;
	}
	public Aces giveMeAce (String commands) {
		if (commands.equalsIgnoreCase("aceHearts")) {
			return aceHearts;
		}
		if (commands.equalsIgnoreCase("aceClubs")) {
			return aceClubs;
		}
		if (commands.equalsIgnoreCase("aceDiamonds")) {
			return aceDiamonds;
		}
		if (commands.equalsIgnoreCase("aceSpades")) {
			return aceSpades;
		}
		return null;
	}
	public void stackWeigher(Stacks stack, String stackEnterer) {
		switch(stackEnterer) {
			case "stack1":
				stack1 = stack;
				return;
			case "stack2":
				stack2 = stack;
				return;
			case "stack3":
				stack3 = stack;
				return;
			case "stack4":
				stack4 = stack;
				return;
			case "stack5":
				stack5 = stack;
				return;
			case "stack6":
				stack6 = stack;
				return;
			case "stack7":
				stack7 = stack;
				return;
		}
	}
	public void gameRules() throws FileNotFoundException {
		String commands = userInput.nextLine();
		if(commands.equalsIgnoreCase("save")) {
			saveGame();
		}
		if (commands.equalsIgnoreCase("move")) {
			System.out.println("Please enter stack code you are taking from.");
			String stack1Enterer = userInput.nextLine();
			Stacks firstStack;
			String stack2Enterer;
			Stacks secondStack;
			Aces secondAce;
			if(stack1Enterer.equalsIgnoreCase("workpile")) {
				System.out.print("Work pile: ");
				for(int i = 0; i <= workPile.size() - 1; i++) {	
					System.out.print((i + 1) + ": ");
					workPile.get(i).print();
					System.out.print(" ");
					
				}
				System.out.println();
				System.out.println("Please enter card number you are taking from the work pile.");
				int workPileNum = userInput.nextInt();
				Card workCard = workPile.get(workPileNum - 1);
				System.out.println();
				System.out.println("Please enter stack code you are giving to.");
				Scanner userInput2 = new Scanner(System.in);
				stack2Enterer = userInput2.nextLine();
				if (stack2Enterer.contains("stack")) {
					secondStack = giveMeStack(stack2Enterer);
					boolean shouldItMove = secondStack.stackPermissions(workCard);
					if (shouldItMove == true) {
						secondStack.dealStacks.add(workCard);
						stackWeigher(secondStack, stack2Enterer);
						workPile.remove(workCard);
						noMoves = 0;
					}
				}
				if (stack2Enterer.contains("ace")) {
					secondAce = giveMeAce(stack2Enterer);
					if (secondAce.cardChecker(workCard)) {
						workPile.removeElementAt(workPileNum - 1);
						aceWeigher(secondAce, stack2Enterer);
						noMoves = 0;
					}
				}
			}
			if(stack1Enterer.contains("stack")) {
				firstStack = giveMeStack(stack1Enterer);
				firstStack.print();
				System.out.println();
				System.out.println("Please enter number of cards you are taking from this stack.");
				int nOC = userInput.nextInt();
				Vector<Card> cardsMoved = new Vector<Card>();
				cardsMoved = firstStack.get(nOC);
				if (cardsMoved == null) {
					System.exit(0);
				}
				for (int i = 0; i < cardsMoved.size(); i++) {
					cardsMoved.get(i).print();
				}
				System.out.println();
				System.out.println("Please enter stack code you are giving to.");
				Scanner userInput2 = new Scanner(System.in);
				stack2Enterer = userInput2.nextLine();
				if (stack2Enterer.contains("stack")) {
					secondStack = giveMeStack(stack2Enterer);
					boolean shouldItMove = secondStack.stackPermissions(cardsMoved.firstElement());
					if (shouldItMove == true) {
						secondStack.dealStacks.addAll(cardsMoved);
						firstStack.deleteTopCards(cardsMoved);
						firstStack.turnOverTopCard();
						stackWeigher(firstStack, stack1Enterer);
						stackWeigher(secondStack, stack2Enterer);
						noMoves = 0;
					}
				}
				else if (stack2Enterer.contains("ace")) {
					secondAce = giveMeAce(stack2Enterer);
					if (secondAce.cardChecker(cardsMoved.firstElement())) {
						firstStack.deleteTopCards(cardsMoved);
						firstStack.turnOverTopCard();
						stackWeigher(firstStack, stack1Enterer);
						aceWeigher(secondAce, stack2Enterer);
						noMoves = 0;
					}
				}
				else {
					System.out.println("I can't understand you when you said '" + stack2Enterer + "'. Please input again.");
				}
				
					}
					else if(stack1Enterer.contains("stack") == false || stack1Enterer.contains("wo") == false){
							System.out.println("I can't understand you when you said '" + stack1Enterer + "'. Please input again.");
				}
			}
				else if (commands.equalsIgnoreCase("draw")) {
					if (workPile.isEmpty()) {
						workPile = solitaire.draw(3);
					}
					else
					{
						solitaire.add(workPile);
						workPile = solitaire.draw(3);
					}
					if(drawCount) {
						drawCount = false;
					}
					else {
						noMoves++;
					}
					printAll();
		}
		printAll();

	}
	public void printAll() {

		System.out.print("Work pile: ");
		for(int i = 0; i <= workPile.size() - 1; i++) {	
			System.out.print((i + 1) + ": ");
			workPile.get(i).print();
			System.out.print(" ");
				
		}
		aceHearts.print();
		aceClubs.print();
		aceDiamonds.print();
		aceSpades.print();
		stack1.print();
		stack2.print();
		stack3.print();
		stack4.print();
		stack5.print();
		stack6.print();	
		stack7.print();
		System.out.println();
		System.out.println("--------------------------------------------");
	}
	public void aceWeigher(Aces ace, String aceEnterer) {
	switch(aceEnterer) {
		case "aceHearts":
			aceHearts = ace;
			return;
		case "aceClubs":
			aceClubs = ace;
			return;
		case "aceDiamonds":
			aceDiamonds = ace;
			return;
		case "aceSpades":
			aceSpades = ace;
			return;
		}
	
	}
	public void winOrLose() throws InterruptedException {
		if(aceHearts.youWin() && aceClubs.youWin() && aceDiamonds.youWin() && aceSpades.youWin()) {
			System.out.println("You Win!!!!!!");
			Thread.sleep(1000);
			System.exit(0);
		}
		
	}
	public void saveGame() throws FileNotFoundException {
		System.out.println("File name?");
		Scanner userInput2 = new Scanner(System.in);
		String fileName = userInput2.nextLine();
		PrintStream game = new PrintStream(new File(fileName + ".solitsave"));
		game.println("Game saved.");
		stack1.printToSolitsav(game);
		stack2.printToSolitsav(game);
		stack3.printToSolitsav(game);
		stack4.printToSolitsav(game);
		stack5.printToSolitsav(game);
		stack6.printToSolitsav(game);
		stack7.printToSolitsav(game);
		game.println();
		game.println("Losing Variable: " + noMoves);
		game.println("Work Pile: ");
		for(int i = 0; i <= workPile.size() - 1; i++) {	
			game.print((i + 1) + ": ");
			workPile.get(i).printToFile(game);
			game.print(" ");
		}
		game.println(" ");
		game.println("Aces: ");
		aceHearts.printToSolitsav(game);
		aceClubs.printToSolitsav(game);
		aceDiamonds.printToSolitsav(game);
		aceSpades.printToSolitsav(game);
		game.println("Deck: ");
		for(int i = 0; i < solitaire.deck.size(); i++){
				solitaire.deck.get(i).printToFile(game);
				game.print(",");
		}	
		
	}
	public void readIn() throws FileNotFoundException {
		Save saveDummy = new Save();
		File alreadyIn = saveDummy.openNewFile();
		Scanner readInFile = new Scanner(alreadyIn);
		readInFile.nextLine();
		readInFile.nextLine();
		readInFile.nextLine();
		String stack1Cards = readInFile.nextLine();
		String[] array1 = stack1Cards.split("@");
		stack1 = new Stacks(1);
		stack2 = new Stacks(2);
		stack3 = new Stacks(3);
		stack4 = new Stacks(4);
		stack5 = new Stacks(5);
		stack6 = new Stacks(6);
		stack7 = new Stacks(7);
		stackPrinter(array1, stack1);
		readInFile.nextLine();
		String stack2Cards = readInFile.nextLine();
		stackPrinter(stack2Cards.split("@"), stack2);
		readInFile.nextLine();
		String stack3Cards = readInFile.nextLine();
		stackPrinter(stack3Cards.split("@"), stack3);
		readInFile.nextLine();
		String stack4Cards = readInFile.nextLine();
		stackPrinter(stack4Cards.split("@"), stack4);
		readInFile.nextLine();
		String stack5Cards = readInFile.nextLine();
		stackPrinter(stack5Cards.split("@"), stack5);
		readInFile.nextLine();
		String stack6Cards = readInFile.nextLine();
		stackPrinter(stack6Cards.split("@"), stack6);
		readInFile.nextLine();
		String stack7Cards = readInFile.nextLine();
		stackPrinter(stack7Cards.split("@"), stack7);
		String noMovesFromFile = readInFile.nextLine();
		noMovesFromFile = noMovesFromFile.replaceAll("Losing Variable: ", "");
		noMovesFromFile = noMovesFromFile.trim();
		noMoves = Integer.parseInt(noMovesFromFile);
		readInFile.nextLine();
		String workPileUntrimmed = readInFile.nextLine();
		if(workPileUntrimmed.length() > 2) {
			String[] workPileString = workPileUntrimmed.split(":");
			for(int i = 1; i < workPileString.length; i++) {
				workPileString[i] = workPileString[i].trim();
				if(i == 1 || i == 2) {
					workPileString[i] = workPileString[i].substring(workPileString[i].length() - 1, workPileString[i].length());
					workPileString[i] = workPileString[i].trim();
				
				}
			}
			for(int i = 1; i < workPileString.length; i++ ) {
				workPile.add(jxcvnjchsgt(workPileString[i]));
			}
		}
		readInFile.nextLine();
		String hi = readInFile.nextLine();
		String cry = readInFile.nextLine();
		String die = readInFile.nextLine();
		String sigh = readInFile.nextLine();
		if(hi.contains("is empty") == false) {
			aceHearts = new Aces("hearts");
			aceHearts.dealAces.addElement(stringToCard(hi));
		}
		if(cry.contains("is empty") == false) {
			aceClubs = new Aces("clubs");
			aceClubs.dealAces.addElement(stringToCard(cry));
		}
		if(die.contains("is empty") == false) {
			aceDiamonds = new Aces("diamonds");
			aceDiamonds.dealAces.addElement(stringToCard(die));
		}
		if(sigh.contains("is empty") == false) {
			aceSpades = new Aces("spades");
			aceSpades.dealAces.addElement(stringToCard(sigh));
		}
		readInFile.nextLine();
		String deckUntrimmed = readInFile.nextLine();
		String[] deck = deckUntrimmed.split(",");
		for(int i = 0; i < deck.length; i++) {
			solitaire.deck.add(stringToCard(deck[i]));	
		}
		readInFile.close();
	}
	public Card stringToCard(String stackCards) {
		String cardSuit; String valuePO = null; boolean isOnBack; int valueNPO = 0;
		String[] array = stackCards.split(" of ");
		if(array[0].length() < 3) {
			valuePO = array[0];
			valueNPO = Integer.valueOf(valuePO);
		}
		else {
			switch(array[0].trim()) {
				case "Jack" :
					valueNPO = 11;
					valuePO = "Jack";
					break;
				case "Queen" :
					valueNPO = 12;
					valuePO = "Queen";
					break;
				case "King" :
					valueNPO = 13;
					valuePO = "King";
					break;
				case "Ace" :
					valueNPO = 1;
					valuePO = "Ace";
					break;
			}
				 
		}
		if(array[1].contains("#")) {
			isOnBack = true;
		}
		else {
			isOnBack = false;
		}
		array[1] = array[1].replaceAll("#", "");
		array[1] = array[1].trim();
		cardSuit = array[1];
		return new Card(cardSuit, valuePO, isOnBack, valueNPO);
	}
	public void stackPrinter(String[] array1, Stacks stack) {
		for(int i = 0; i < array1.length; i++){
			array1[i] = array1[i].substring(2, array1[i].length());
			array1[i] = array1[i].trim();
			stack.dealStacks.addElement(stringToCard(array1[i]));
			
		}
		stack.print();
	}
	public void newGame() throws FileNotFoundException, InterruptedException {
		transferStacks();
	}
	public Card jxcvnjchsgt(String stackCards) {
		String cardSuit; String valuePO = null; boolean isOnBack = false; int valueNPO = 0;
		String[] array = stackCards.split(" of ");
		if(array[0].length() < 3) {
			valuePO = array[0];
			valueNPO = Integer.valueOf(valuePO);
		}
		else {
			switch(array[0].trim()) {
				case "Jack" :
					valueNPO = 11;
					valuePO = "Jack";
					break;
				case "Queen" :
					valueNPO = 12;
					valuePO = "Queen";
					break;
				case "King" :
					valueNPO = 13;
					valuePO = "King";
					break;
				case "Ace" :
					valueNPO = 1;
					valuePO = "Ace";
					break;
			}
			isOnBack = true;
		}
		array[1] = array[1].trim();
		cardSuit = array[1];
		return new Card(cardSuit, valuePO, isOnBack, valueNPO);
	}
}
