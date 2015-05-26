// Assignment 3
// Bahnmiller, Will
// COP 3330-0R02
// DealTwoHands.java
//    Draws five cards into two hands and
//    decides who has the better hand. Based
//    on Figures 7.9 - 7.11 in the textbook.

public class DealTwoHands 
{
	private static Card[] myHand;
	private static Card[] myHand2;
	
	// execute application
	public static void main( String[] args )
	{
		DeckOfCards myDeckOfCards = new DeckOfCards();
		myDeckOfCards.shuffle(); // place Cards in random order
		
		myHand = new Card[5]; // create a blank hand of five cards
		myHand2 = new Card[5];
		int score = 0; // used to decide if the hand is special
		int score2 = 0;
		
		// Begin printing the statement
		System.out.println( "Player 1's hand is:\n" );
		
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
		
		// Begin printing the second statement
		System.out.println( "\nPlayer 2's hand is:\n" );
		
		// print the next five cards and store them
		for ( int i = 1; i <= 5; i++ )
		{
			// place the card in the hand
			myHand2[i-1] = myDeckOfCards.dealCard();
			
			// print to the screen what this card is
			System.out.printf( "  %s\n", myHand2[i-1]);

		} // end for
		
		// rearrange the cards to be in decreasing order
		myHand2 = Reorder( myHand2 );
		
		// look at the hand and score it
		score2 = ScoreHand( myHand2 );
		
		// print results
		PrintResults( score2 );
		
		// compare both player's results and decide who won
		if (score > score2)
			System.out.println("* * * Player 1 won! * * *");
		else if (score2 > score)
			System.out.println("* * * Player 2 won! * * *");
		else
		{
			// If both players got the same score (ex: both got three of a kind),
			// then the tiebreaker is who has the highest card. Ace is LOW.
			if (myHand[0].num > myHand2[0].num)
				System.out.println("* * * Player 1 won! * * *");
			else if (myHand2[0].num > myHand[0].num)
				System.out.println("* * * Player 2 won! * * *");
			else
				System.out.println("* * * This game is a tie. * * *"); // same result AND same high card number
		}
		
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
