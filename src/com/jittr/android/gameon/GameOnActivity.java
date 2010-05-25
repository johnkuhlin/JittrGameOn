package com.jittr.android.gameon;

import android.app.Activity;

public class GameOnActivity extends Activity {

	public static GameManagerApplication appObject;
	
	/*static {
		appObject = (GameManagerApplication) getApplication();
		
	}
	*/
	public GameOnActivity() {
		super();
	}

	protected GameManagerApplication getStuffApplication()
	{
		return (GameManagerApplication)getApplication();
	}

}