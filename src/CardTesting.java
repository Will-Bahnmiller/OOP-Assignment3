// Assignment 3
// Bahnmiller, Will
// COP 3330-0R02
// CardTesting.java
//    Tests an *ordered* hand of five cards for each outcome.

public class CardTesting
{
	// Two cards of one face value and three cards of another face value
	public static int FullHouse (Card[] myHand)
	{
		int n = 0;
		
		// Case 1: The first three cards have the same face,
		//   and the last two numbers have the same face.
		if ( (myHand[0].num == myHand[1].num) && (myHand[1].num == myHand[2].num)
			&& (myHand[3].num == myHand[4].num) )
		{
			n = 7;
		}
		
		// Case 2: The first two cards have the same face,
		//   and the last three numbers have the same face.
		else if ( (myHand[0].num == myHand[1].num)
			&& (myHand[2].num == myHand[3].num) && (myHand[3].num == myHand[4].num) )
		{
			n = 7;
		}
		
		return n; // 7 if true, 0 if false
	}
	
	// Five cards of consecutive face values
	public static int Straight (Card[] myHand)
	{
		int n = 0;
		
		// Only case: Each card is one face value more than
		//   the next.
		if ( (myHand[0].num == myHand[1].num - 1) && (myHand[1].num == myHand[2].num - 1)
				&& (myHand[2].num == myHand[3].num - 1) && (myHand[3].num == myHand[4].num - 1) )
		{
			n = 6;
		}
		
		return n; // 6 if true, 0 if false
	}
	
	// All five cards of the same suit
	public static int Flush (Card[] myHand)
	{
		int n = 0;
		
		// Only case: All five cards should have the same suit by
		//   string comparison.
		if ( (myHand[0].suit.compareTo(myHand[1].suit) == 0) && (myHand[1].suit.compareTo(myHand[2].suit) == 0)
			&& (myHand[2].suit.compareTo(myHand[3].suit) == 0) && (myHand[3].suit.compareTo(myHand[4].suit) == 0) )
		{
				n = 5;
		}
		
		return n; // 5 if true, 0 if false
	}
	
	// Four of the five cards are the same face
	public static int FourOfKind (Card[] myHand)
	{
		int n = 0;
		int check = 0;
		
		// Two cases: The first four cards have the same face,
		//   or the last four cards have the same face.
		for (check = 0; check < 2; check++)
		{
			if ( (myHand[check].num == myHand[check+1].num) 
				&& (myHand[check].num == myHand[check+2].num) && (myHand[check].num == myHand[check+3].num) )
			{
				n = 4;
			}
		}
		
		return n; // 4 if true, 0 if false
	}
	
	// Three of the five cards are the same face
	public static int ThreeOfKind (Card[] myHand)
	{
		int n = 0;
		int check = 0;
		
		// Three cases: The first three cards have the same face, or the
		//   middle three cards have the same face, or the last three cards
		//   have the same face.
		for (check = 0; check < 3; check++)
		{
			if ( (myHand[check].num == myHand[check+1].num) && (myHand[check].num == myHand[check+2].num) )
			{
				n = 3;
			}
		}
		
		return n; // 3 if true, 0 if false
	}
	
	// Two pairs of cards each have the same face
	public static int TwoPairs (Card[] myHand)
	{
		int n = 0;
		int check = 0;
		
		// Four cases: The first two cards have the same face, and/or cards 2 and 3 have
		//   the same face, and/or cards 3 and 4 have the same face, and/or the last two cards
		//   have the same face.
		for (check = 0; check < 4; check++)
		{
			if (myHand[check].num == myHand[check+1].num)
			{
				n += 1;
				check++; // without this, the code will consider three of a kind to be two pairs
			}
		}
		
		if (n == 1) // Only detected one pair
			return 0;
		else
			return n; // 2 if true, 0 if false 
	}
	
	// Two cards of the five have the same face
	public static int OnePair (Card[] myHand)
	{
		int n = 0;
		int check = 0;
		
		// Four cases: Either the first two cards have the same face, or cards 2 and 3 have
		//   the same face, or cards 3 and 4 have the same face, or the last two cards
		//   have the same face.
		for (check = 0; check < 4; check++)
		{
			if (myHand[check].num == myHand[check+1].num)
				n = 1;
		}
		
		return n; // 1 if true, 0 if false
	}
	
} // end of Card Testing
