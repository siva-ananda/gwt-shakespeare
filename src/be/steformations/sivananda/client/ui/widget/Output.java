package be.steformations.sivananda.client.ui.widget;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.uibinder.client.UiConstructor;

import be.steformations.sivananda.client.event.EventManager;
import be.steformations.sivananda.client.event.reset.ResetEvent;
import be.steformations.sivananda.client.event.reset.ResetEventManager;
import gwt.material.design.client.ui.MaterialTextBox;

public class Output extends MaterialTextBox implements ResetEventManager{

	@UiConstructor
	public Output() {
		GWT.log("Output.Output()");
		
		EventManager.getInstance().addHandler(ResetEvent.type, this);
	}

	@Override
	public void onReset(ResetEvent event) {
		GWT.log("Output.onReset()");
		this.setText("");
	}
	
}
