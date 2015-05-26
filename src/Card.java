// Fig. 7.9: Card.java (Modified)
// Card class represents a playing card.

public class Card
{
	public String face; // face of card ("Ace", "Deuce", ...)
	public String suit; // suit of card ("Hearts", "Diamonds", ...)
	public int num; // number of card (1, 2, 3, ...)
	
	// three-arrangement constructor initializes card's face and suit
	public Card( String cardFace, String cardSuit, int cardNum)
	{
		face = cardFace; // initialize face of card
		suit = cardSuit; // initialize suit of card
		num = cardNum; // initialize number of card
	} // end three-argument Card constructor

	// return String representation of Card
	public String toString()
	{
		return face + " of " + suit;
	} // end method toString
} // end class Card
