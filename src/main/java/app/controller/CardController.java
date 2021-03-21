package app.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import app.inout.CardDTO;
import app.inout.CardRequest;
import app.service.CardService;

@Path("/trello")
public class CardController {
	
	public CardService getCardService() {
		//return CardService instance to use its methods.
		//Autowired workarround.
		return new CardService();
	}

	@POST
	@Path("/createCard")
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public CardDTO createCard(CardRequest cardRequest) throws Exception {
		return this.getCardService().createCard(cardRequest);
	}
	
}
