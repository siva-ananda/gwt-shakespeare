package be.steformations.sivananda.client.http;

import com.google.gwt.core.client.GWT;

import be.steformations.sivananda.client.event.EventManager;
import be.steformations.sivananda.client.event.search.SearchEvent;
import be.steformations.sivananda.client.event.search.SearchEventManager;
import be.steformations.sivananda.client.event.search.SearchParams;

public class Searcher implements SearchEventManager {

	public Searcher() {
		super();
		EventManager.getInstance().addHandler(SearchEvent.type, this);
	}

	@Override
	public void onSearch(SearchEvent event) {
		SearchParams params = event.getParams();
		GWT.log("Searcher.onSearch() => " + params);
	}

}
