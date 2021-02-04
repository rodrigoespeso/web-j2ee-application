package org.respeso.webapp.item;

import java.util.ArrayList;
import java.util.List;

/**
 * The service class with implementation of the business of the WebApp.
 * 
 * @author Rodrigo Espeso
 *
 */
public class ItemService {
	
	private static List<Item> items = new ArrayList<>();
	
	static {
		items.add(new Item("Learn WebApplicacition Developmet", "Study"));
		items.add(new Item("Learn Spring MVC", "Study"));
		items.add(new Item("Learn Spring Rest Services", "Study"));
	}
	
	public List<Item> retrieveItems(){
		return items;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void deleteItem(Item item) {
		items.remove(item);
	}
	
	 
}
