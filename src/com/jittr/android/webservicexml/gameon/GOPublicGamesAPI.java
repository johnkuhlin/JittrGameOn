package com.jittr.android.webservicexml.gameon;

import com.jittr.android.gamemanager.games.Game;
import com.jittr.android.webservicexml.GameOnHandler;

/* Final Handler for the WebService API */
/* Each webservice API will have a class such as this that captures the xml elements and stores in the appropriate 
 * class object
 */
public final class GOPublicGamesAPI<LISTOBJECT> extends GameOnHandler {

	protected ArrayList games;
	protected Game currentGame;
	
	/*public ArrayList<Game> getGames() {
		return this.games;
	}
	*/
	public void GoPublicGamesAPI() {
	    	//super<LISTOBJECT>();
	}
	
	// JKL: temp method to return populated ArrayList
	public ArrayList<LISTOBJECT> getList() {
		return games;
	}

	@Override
	public void endElement(String uri, String localName, String name)
			throws SAXException {
		super.endElement(uri, localName, name);
		if (this.currentGame != null) {
			if (localName.equalsIgnoreCase("id")) {
			   //	
			   currentGame.setId(Long.valueOf( builder.toString()));
			} else if (localName.equalsIgnoreCase("title")){
				currentGame.setName(builder.toString());
			} else if (localName.equalsIgnoreCase("eventname")){
				currentGame.setEventName(builder.toString());
			} else if (localName.equalsIgnoreCase("eventdate")){
					currentGame.setEventDate(builder.toString());
			} else if (localName.equalsIgnoreCase("description")){
				currentGame.setDescription(builder.toString());
			} else if (localName.equalsIgnoreCase("type")) {
				currentGame.setType(builder.toString());
			} else if (localName.equalsIgnoreCase("sport")) {
			    currentGame.setSport(builder.toString());
			} else if (localName.equalsIgnoreCase("league")) {
				currentGame.setLeague(builder.toString());	    
			} else if (localName.equalsIgnoreCase("numbersubscribers")) {
			    currentGame.setNumberSubscribers(Integer.parseInt(builder.toString()));
			} else if (localName.equalsIgnoreCase("team1")) {
			    currentGame.setHomeTeam(builder.toString());
			}  else if (localName.equalsIgnoreCase("team2")) {
				    currentGame.setVisitingTeam(builder.toString());
    		} else if (localName.equalsIgnoreCase("publicgame")) {
				games.add(currentGame);
			}
			builder.setLength(0);	
		} //if
	} // endElement
	
	@Override
	public void startElement(String uri, String name, String localName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, name, localName, attributes);
		if (name.equalsIgnoreCase("publicgame")) {
			this.currentGame = new Game();
		}  //if
	}  //startElement
	
	@Override
	public void startDocument() throws SAXException {
		    super.startDocument();
			this.games = new ArrayList<LISTOBJECT>();
			this.setStringBuilder(new StringBuilder());
	}	  //startDocument
}  //class
