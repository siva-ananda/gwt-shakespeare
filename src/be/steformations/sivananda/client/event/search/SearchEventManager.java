package be.steformations.sivananda.client.event.search;

import com.google.gwt.event.shared.EventHandler;

public interface SearchEventManager extends EventHandler {
	
	public void onSearch(SearchEvent searchEvent);
	
}
