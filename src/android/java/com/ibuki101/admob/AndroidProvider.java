package com.ibuki101.admob;


/**
 * Android用の広告を表示する
 * アプリ ID: ca-app-pub-2831580726446381~3105883333
 *
 * 広告ユニット名: admobのテスト(Android)
 * 広告ユニット ID: ca-app-pub-2831580726446381/5811937726
 */
public class AndroidProvider implements IPlatformProvider{

	private static final String UNIT_ID = "ca-app-pub-2831580726446381/5811937726";

	@Override
	public IAdViewService getAdviewService() {
		return new AndroidAdViewService(UNIT_ID);
	}
}
