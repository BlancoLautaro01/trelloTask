package app.model;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import app.inout.CardDTO;
import app.utilities.StringConverter;

public class CardIssue extends Card {
	
	private String description;

	/* Constructors */
	public CardIssue() {
		super();
	}

	public CardIssue(String type, String title, String description) {
		super(type, title);
		this.description = description;
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
				"&name=" + StringConverter.urlString(this.getTitle()) +
				"&desc=" + StringConverter.urlString(this.getDescription()));
		
		ClientResponse response = webResource.
				post(ClientResponse.class);
		
		return new CardDTO(this, response.getStatus());
	}
	
}
