package com.ibuki101.admob;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import javafx.application.Platform;
import javafx.beans.property.StringProperty;
import javafxports.android.FXActivity;


/**
 * Android用の広告を表示する
 * アプリ ID: ca-app-pub-2831580726446381~3105883333
 * 広告ユニット名: admobのテスト(Android)
 * 広告ユニット ID: ca-app-pub-2831580726446381/5811937726
 */
public class AndroidAdViewService implements IAdViewService {

	private String unitId;

	private AdView adView;

	private StringProperty property;

	public AndroidAdViewService(String unitId) {
		this.unitId = unitId;
	}

	@Override
	public void displayAdUnit(boolean test, StringProperty property) {

		this.property = property;

		FXActivity.getInstance().runOnUiThread(() -> {

			try{
				LinearLayout layout = new LinearLayout(FXActivity.getInstance());
		    	layout.setVerticalGravity(Gravity.TOP);
		    	layout.setOrientation(LinearLayout.VERTICAL);
		    	adView = new AdView(FXActivity.getInstance());
				adView.setAdSize(AdSize.SMART_BANNER);
				adView.setAdUnitId(test ? TEST_UNIT_ID :unitId);

				AdRequest adRequest;
				if (test) {
					adRequest = new AdRequest.Builder()
							.addTestDevice(AdRequest.DEVICE_ID_EMULATOR) // Allemulators
							.build();
				} else {
					adRequest = new AdRequest.Builder().build();
				}


				adView.loadAd(adRequest);
				adView.setAdListener(new AdListener() {
					@Override
					public void onAdLoaded() {
						super.onAdLoaded();
						Platform.runLater(() -> property.set("onAdLoaded was called."));
					}

					@Override
					public void onAdLeftApplication(){

						super.onAdLeftApplication();
						Platform.runLater(() -> property.set("onAdLeftApplication was called."));
					}

					@Override
					public void onAdOpened(){
						super.onAdOpened();
						Platform.runLater(() -> property.set("oonAdOpened was called."));
					}
				});


				layout.addView(adView);
		    	FXActivity.getViewGroup().addView(layout);
		    	Platform.runLater(() -> property.set("admob was loading."));

			} catch(Exception ex){
				Platform.runLater(() -> property.set("Exception when loading admob: "+ ex.getMessage()));
			}
		});
	}

	@Override
	public void resume() {
		adView.resume();
	}

	@Override
	public void pause() {
		adView.pause();
	}

	@Override
	public void showAd() {

		adView.setVisibility(View.VISIBLE);
		adView.resume();
	}

	@Override
	public void hideAd() {
		if (adView != null){
		    adView.setVisibility(View.GONE);
		    adView.pause();
		}
	}

}
