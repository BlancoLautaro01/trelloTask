package app.service;

import com.sun.jersey.api.client.Client;

import app.inout.CardDTO;
import app.inout.CardRequest;
import app.model.Card;
import app.model.CardBug;
import app.model.CardIssue;
import app.model.CardTask;

public class CardService {
	
	//Generate base url.
	private String key = "5e2223e356ba6a646fd86e019f3b5cc0";
	private String token = "701f1023c3bcbf6d8bdf89836f5ca56de8d2127b427bf97a49f4364a6890fd12";
	private String baseUrl = "https://api.trello.com/1/cards?key=" + this.key + "&token=" + this.token;
	
	//Generate client to made http request to Trello API.
	private Client client = Client.create();
	
	public CardDTO createCard(CardRequest cardRequest) throws Exception {
		
		return this.getCardType(cardRequest).createCard(client, baseUrl);
	}

	//Switch function to choose card type.
	private Card getCardType(CardRequest cardRequest) throws Exception {

		switch(cardRequest.getType()) {
			case "bug": 
				return Type.BUG.getCardType(cardRequest);
				
			case "issue": 
				return Type.ISSUE.getCardType(cardRequest);
				
			case "task": 
				return Type.TASK.getCardType(cardRequest);
				
			default:
				throw new Exception("Invalid card type.");
				
		}
	}
	
}

enum Type {
	
	BUG {
		
		private Integer cardNumber = 0;
		
		@Override
		public CardBug getCardType(CardRequest cardRequest) {
			this.cardNumber += 1;
			return new CardBug(cardRequest.getType(), cardRequest.getDescription(), cardNumber);	
		}
	},
	ISSUE {
		
		@Override
		public CardIssue getCardType(CardRequest cardRequest) {
			return new CardIssue(cardRequest.getType(), cardRequest.getTitle() , cardRequest.getDescription());	
		}
	},
	TASK {
		
		@Override
		public CardTask getCardType(CardRequest cardRequest) {
			return new CardTask(cardRequest.getType(), cardRequest.getTitle() , cardRequest.getCategory());	
		}
	};
	
	abstract public Card getCardType(CardRequest cardRequest);

}
