package com.ibuki101.admob;

/**
 * iOS用の広告を表示する
 */
public class IosProvider implements IPlatformProvider{

	/** 広告ユニット ID	*/
	private static final String UNIT_ID = "ca-app-pub-2831580726446381/2387698038";

	@Override
	public IAdViewService getAdviewService() {
		return new IosAdViewService(UNIT_ID);
	}

}
