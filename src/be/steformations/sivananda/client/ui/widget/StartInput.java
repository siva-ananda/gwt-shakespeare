package be.steformations.sivananda.client.ui.widget;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiConstructor;

import be.steformations.sivananda.client.event.EventManager;
import be.steformations.sivananda.client.event.reset.ResetEvent;
import be.steformations.sivananda.client.event.reset.ResetEventManager;
import gwt.material.design.client.ui.MaterialTextBox;

public class StartInput extends MaterialTextBox implements ResetEventManager{

	@UiConstructor
	public StartInput(String label) {
		GWT.log("StartInput.StartInput()");
		this.setLabel(label);
		this.setText("To be, or not to be");
		EventManager.getInstance().addHandler(ResetEvent.type, this);
	}

	@Override
	public void onReset(ResetEvent event) {
		GWT.log("StartInput.onReset()");
		this.setText("To be, or not to be");
	}

}
