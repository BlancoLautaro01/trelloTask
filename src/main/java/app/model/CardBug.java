package app.model;

import com.sun.jersey.api.client.WebResource;

import app.inout.CardDTO;
import app.utilities.StringConverter;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;

public class CardBug extends Card {
	
	private String description;
	
	/* Constructors */
	public CardBug() {
		super();
	}

	public CardBug(String type, String description, Integer cardNumber) {
		super(type);
		this.description = description;
		this.setTitle("bug-TeamName-" + cardNumber);
	}

	/* Getters and Setters */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public CardDTO createCard(Client client, String baseUrl) {
		
		WebResource webResource = client.resource(
				baseUrl + 
				"&idList=6053f657f5be2a3b98048a48" +
				"&name=" + this.getTitle() + 
				"&desc=" + StringConverter.urlString(this.getDescription()) +
				"&idLabels=6056b1bbcb9742492e3cc645");
		
		ClientResponse response = webResource.
				post(ClientResponse.class);
		
		return new CardDTO(this, response.getStatus());
	}
	
}
