package app.inout;

public class CardRequest {

	private String type;	
	private String title;
	private String description;
	private String category;
	
	public CardRequest() {
		super();
	}
	
	public CardRequest(String type, String title, String description, String category) {
		super();
		this.type = type;
		this.title = title;
		this.description = description;
		this.category = category;
	}
	
	public String getType() {
		return type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getCategory() {
		return category;
	}
	
}
