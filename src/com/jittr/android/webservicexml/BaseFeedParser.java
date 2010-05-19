package com.jittr.android.webservicexml;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/* base class for xml over http parser class that will make executing and processing the return of
 * webservices template based.
 * TODO: consider using apache's httpclient libraries instead of native java net libraries 
 */
public abstract class BaseFeedParser implements FeedParser {
	private final URL feedUrl;  //url to Webservice
	private static final String TAG = "BaseFeedParser";  //unique tag for class
	// JKL: change from InputStreamReader to InputStream
    // private InputStreamReader inputStream;
    private InputStream inputStream;
    
	/* instantiate a URL object and open it to the Webservice URL */
	protected BaseFeedParser(String feedUrl) throws GOWebServiceAPIException{
		try {
			this.feedUrl = new URL(feedUrl);
			this.feedUrl.openConnection();
		} catch (MalformedURLException e) {
			throw new GOWebServiceAPIException(BaseFeedParser.TAG,e.getMessage());
		} catch (IOException e) {
			throw new GOWebServiceAPIException(BaseFeedParser.TAG,e.getMessage());
		}
	}  //BaseFeedParser

	/* open connection to the Webservice and instantiate an InputStream to capture return from WebService*/
	// JKL: change from InputStreamReader to InputStream
	// protected InputStreamReader getInputStream() throws GOWebServiceAPIException {
	protected InputStream getInputStream() throws GOWebServiceAPIException {
		try {
			// JKL: change from InputStreamReader to InputStream
			// inputStream = new InputStreamReader( feedUrl.openStream());
			inputStream = feedUrl.openStream();
			return inputStream;
			//return feedUrl.openConnection().getInputStream();
		} catch (IOException e) {
			throw new GOWebServiceAPIException(BaseFeedParser.TAG,e.getMessage());
		}  //catch
	}  //getInputStream
} //class