package app.model;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import app.inout.CardDTO;
import app.utilities.StringConverter;

public class CardTask extends Card {

	private String category;
	
	/* Constructors */
	public CardTask() {
		super();
	}
	
	public CardTask(String type, String title, String category) {
		super(type, title);
		this.category = category;
	}
	
	/* Getters and Setters */
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public CardDTO createCard(Client client, String baseUrl) {
		
		String url = this.makeUrlByCategory(baseUrl);
		
		WebResource webResource = client.resource(url);
		
		ClientResponse response = webResource.
				post(ClientResponse.class);
		
		return new CardDTO(this, response.getStatus());
	}
	
	private String makeUrlByCategory(String baseUrl) {
		//This function select the label from the chosen category.
		
		String label = "";
		switch(category) {
			case "Maintenance":
				label = "6056b47419ce7b72b1f04186";
				break;
			
			case "Test":
				label = "6056b454cd126d84d1d86522";
				break;
				
			case "Research":
				label = "6056b48403f27e4953bda400";
				break;
				
			default:
				label = "";
		}
		
		return baseUrl + 
				"&idList=6053f657f5be2a3b98048a48" +
				"&name=" + StringConverter.urlString(this.getTitle()) + 
				"&idLabels=" + label;
	}
}
