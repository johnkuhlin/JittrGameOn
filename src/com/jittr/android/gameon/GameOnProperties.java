package com.jittr.android.gameon;

import static com.jittr.android.gameon.GameManagerApplication.appContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
public class GameOnProperties  {

	private Properties properties;
    private Resources resources; // = appContext.getResources();
    //private AssetManager assetManager = new AssetManager();
    
	public GameOnProperties() {
		// Read from the /res/raw directory
		try {
	//		assetManager.
			resources = appContext.getResources();
		    final InputStream rawResource =  resources.openRawResource(R.raw.gameonv1);
		    properties = new Properties();
		    properties.load(rawResource);
		    System.out.println("The properties are now loaded");
		    System.out.println("properties: " + properties);
		} catch (final NotFoundException e) {
		    System.err.println("Did not find raw resource: "+e);
		} catch (final IOException e) {
		    System.err.println("Failed to open microlog property file");
		}  //catch
	} //constructor

	public String getProperty(final String key) {
        String value = null;
        value = properties.getProperty(key);
		return value;
	}  //getProperty
}  //class	
