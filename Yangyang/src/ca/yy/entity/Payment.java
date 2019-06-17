package ca.yy.entity;

public class Payment {
	
	public String typeOfCard;
	private int cardNumber;
	public Payment(String typeOfCard, int i) {
		super();
		this.typeOfCard = typeOfCard;
		this.cardNumber = i;
	}
	public String getTypeOfCard() {
		return typeOfCard;
	}
	public void setTypeOfCard(String typeOfCard) {
		this.typeOfCard = typeOfCard;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
}
