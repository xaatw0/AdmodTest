package com.ibuki101.admob;

import javafx.beans.property.StringProperty;

public class DesktopProvider implements IPlatformProvider {

	@Override
	public IAdViewService getAdviewService() {
		return new IAdViewService(){

			@Override
			public void displayAdUnit(boolean test, StringProperty property) {
				property.set("No admob for desktop");
			}

			@Override
			public void resume() {
			}

			@Override
			public void pause() {
			}

			@Override
			public void showAd() {
			}

			@Override
			public void hideAd() {
			}};
	}
}
