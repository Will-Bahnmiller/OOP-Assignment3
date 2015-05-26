// Assignment 3
// Bahnmiller, Will
// COP 3330-0R02
// DealOneHand.java
//    Draws five cards into a hand and
//    says if it is a special hand. Based
//    on Figures 7.9 - 7.11 in the textbook.

public class DealOneHand 
{
	private static Card[] myHand;
	
	// execute application
	public static void main( String[] args )
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		
		myHand = new Card[5]; // create a blank hand of five cards
		int score = 0; // used to decide if the hand is special
		
		// Begin printing the statement
		System.out.println( "Your hand is:\n" );
		
		// print the top five cards and store them
		for ( int i = 1; i <= 5; i++ )
		{
			// place the card in the hand
			myHand[i-1] = myDeckOfCards.dealCard();
			
			// print to the screen what this card is
			System.out.printf( "  %s\n", myHand[i-1]);

		} // end for
		
		// rearrange the cards to be in decreasing order
		myHand = Reorder( myHand );
		
		// look at the hand and score it
		score = ScoreHand( myHand );
		
		// print results
		PrintResults( score );
		
	} // end main
	
	public static int ScoreHand( Card[] myHand )
	{
		int num = 0;
		
		// Go through each test
		num = CardTesting.FullHouse( myHand );
		if (num == 0)
		{
			num = CardTesting.Straight( myHand );
			if (num == 0)
			{
				num = CardTesting.Flush( myHand );
				if (num == 0)
				{
					num = CardTesting.FourOfKind( myHand );
					if (num == 0)
					{
						num = CardTesting.ThreeOfKind( myHand );
						if (num == 0)
						{
							num = CardTesting.TwoPairs( myHand );
							if (num == 0)
							{
								num = CardTesting.OnePair( myHand );
							}
						}
					}
				}
			}
		} // end of testing
		
		return num;
	} // end ScoreHand
	
	public static Card[] Reorder( Card[] myHand )
	{
		Card[] tempHand;
		tempHand = new Card[5];
		int counter = 0;
		
		// Go through and find cards
		for (int j = 13; j > 0; j--)
		{
			for (int k = 0; k < 5; k++)
			{
				if (myHand[k].num == j)
				{
					tempHand[counter] = myHand[k];
					counter++;
				}
			} // end for k
		} // end for j
		
		// return the new hand that has the cards in order (Greatest-Least)
		return tempHand;
	}
	
	public static void PrintResults( int score )
	{
		if ( score == 0 )
			System.out.println("\nSorry. This hand is not special.\n");
		else if ( score == 1 )
			System.out.println("\nThis hand has a pair!\n");
		else if ( score == 2 )
			System.out.println("\nThis hand has two pairs!\n");
		else if ( score == 3 )
			System.out.println("\nThis hand has three of a kind!\n");
		else if ( score == 4 )
			System.out.println("\nThis hand has four of a kind!\n");
		else if ( score == 5 )
			System.out.println("\nThis hand is a flush!\n");
		else if ( score == 6 )
			System.out.println("\nThis hand is a straight!\n");
		else if ( score == 7 )
			System.out.println("\nThis hand is a full house!!!\n");
	}
} // end class DealOneHand
