package app.model;

import com.sun.jersey.api.client.Client;
import app.inout.CardDTO;

public abstract class Card {
	
	/* All new card type must extend this class.
	 * For each new subclass, devs should add the Type and switch case in CardService. 
	 */
	
	private String type;
	private String title;

	/* Constructors */
	public Card() {
		super();
	}

	public Card(String type) {
		super();
		this.type = type;
	}
	
	public Card(String type, String title) {
		super();
		this.type = type;
		this.title = title;
	}
	
	/* Getters and Setters */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	abstract public CardDTO createCard(Client client, String baseUrl);
	
}
