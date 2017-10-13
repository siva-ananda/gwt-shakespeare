package be.steformations.sivananda.client.ui;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import be.steformations.sivananda.client.event.EventManager;
import be.steformations.sivananda.client.event.search.SearchEvent;
import be.steformations.sivananda.client.event.search.SearchParams;
import be.steformations.sivananda.client.ui.widget.PlayInput;
import be.steformations.sivananda.client.ui.widget.SearchButton;
import be.steformations.sivananda.client.ui.widget.SpeakerInput;
import be.steformations.sivananda.client.ui.widget.StartInput;

public class UiPanel extends Composite implements ClickHandler {

	private static UiPanelUiBinder uiBinder = GWT.create(UiPanelUiBinder.class);

	interface UiPanelUiBinder extends UiBinder<Widget, UiPanel> {
	}

	@UiField
	PlayInput playInput;
	@UiField
	SpeakerInput speakerInput;
	@UiField
	StartInput startInput;
	@UiField
	SearchButton searchButton;

	public UiPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		this.searchButton.addClickHandler(this);
	}

	@Override
	public void onClick(ClickEvent event) {
		GWT.log("UiPanel.onClick()");
		
		SearchParams params = new SearchParams();
		params.setPlay(this.playInput.getValue());
		params.setSpeaker(this.speakerInput.getValue());
		params.setStart(this.startInput.getValue());

		SearchEvent searchEvent = new SearchEvent(params);

		EventManager.getInstance().fireEvent(searchEvent);
	}

}
