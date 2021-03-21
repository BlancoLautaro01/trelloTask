package app.inout;

import app.model.Card;

public class CardDTO {
	
	private Card card;
	private Integer statusCode;
	
	public CardDTO() {
		super();
	}
	
	public CardDTO(Card card, Integer statusCode) {
		super();
		this.card = card;
		this.statusCode = statusCode;
	}
	
	public Card getCard() {
		return card;
	}
	
	public Integer getStatusCode() {
		return statusCode;
	}
	
}
