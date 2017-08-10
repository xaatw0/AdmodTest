package com.ibuki101.admob;


public interface IAdViewService {
	/**
	 * Googleが用意したテスト広告のユニットID
	 * https://developers.google.com/admob/android/test-ads#sample_ad_units
	 */
	String TEST_UNIT_ID = "ca-app-pub-3940256099942544/6300978111";

	/**
	 * 広告を表示する
	 * @param test テストモードか
	 */
	void displayAdUnit(boolean test);

	void resume();

	void pause();

	void showAd();

	void hideAd();
}
