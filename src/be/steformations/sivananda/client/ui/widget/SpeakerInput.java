package be.steformations.sivananda.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiConstructor;

import be.steformations.sivananda.client.event.EventManager;
import be.steformations.sivananda.client.event.reset.ResetEvent;
import be.steformations.sivananda.client.event.reset.ResetEventManager;
import gwt.material.design.client.ui.MaterialTextBox;

public class SpeakerInput extends MaterialTextBox implements ResetEventManager{

	@UiConstructor
	public SpeakerInput(String label) {
		GWT.log("SpeakerInput.SpeakerInput()");
		this.setText("hamlet");
		this.setLabel(label);
		
		EventManager.getInstance().addHandler(ResetEvent.type, this);
	}

	@Override
	public void onReset(ResetEvent event) {
		GWT.log("SpeakerInput.onReset()");
		this.setText("hamlet");
	}

}
