package com.jittr.android.gameon.games;

//import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;

import com.jittr.android.gameon.baseTablePojo;

/* Standardize field names throughout including from XML dtd */
/* id = id,
 * name = title
 * type = type
 * complete = complete 
 * 
 */
public class Game extends baseTablePojo implements Parcelable {
	
	/**
	 * Generated by Eclipse
	 */
   // public static final Creator<Game> CREATOR;
	//private static final long serialVersionUID = 5527258407135652423L;
	
	private long id;  //unique
	private String title;
	private String description;
	private String eventName;
	private String eventDate;
	private int numberSubscribers;
	private String type;
	private String sport;
	private String league;
	private String homeTeam;
	private String visitingTeam;
	/* Will contain network identifiers where game is syndicated to */
	private String facebookNetwork;
	private String twitterNetwork;
	private String foursquareNetwork;
	private boolean complete;
    private int visibility;
	private String createdByUserName;
	private int createdByUserID;
	private int wagerType;
	private int wagerUnits;
	private String subscribeCloseDate;
  
   
    public Game() {
    	super();
    }
    
    public static final Parcelable.Creator<Game> CREATOR
    = new Parcelable.Creator<Game>() {

   	
    public Game createFromParcel(Parcel in) {
        return new Game(in);
     } //createFromParcel

	public Game[] newArray(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
    
     };

     private Game(Parcel in) {
    	 readFromParcel(in);
     	//name = "this is a test";
     }
	public void readFromParcel(Parcel in) {
	   id = in.readLong();
	   title = in.readString();
	   description = in.readString();
	   eventName = in.readString();
	   eventDate = in.readString();
	   numberSubscribers = in.readInt();
	   type = in.readString();
	   sport = in.readString();
	   league = in.readString();
	   homeTeam = in.readString();
	   visitingTeam = in.readString();
	   facebookNetwork = in.readString();
	   twitterNetwork = in.readString();
	   foursquareNetwork = in.readString();
	   createdByUserName=in.readString();
	   createdByUserID=in.readInt();
	   wagerType=in.readInt();
	   wagerUnits=in.readInt();
	   // in.read
	   //complete=in.readBooleanArray(null);
	   visibility=in.readInt();
	   this.setCreatedDate(in.readString());
	}  //readFromParcel
	
    public void writeToParcel(Parcel in, int arg1) {
		in.writeLong(id);
	    in.writeString(title);
	    in.writeString(description);
	    in.writeString(eventName);
	    in.writeString(eventDate);
	    in.writeInt(numberSubscribers);
	    in.writeString(type);
	    in.writeString(sport);
	    in.writeString(league);
	    in.writeString(homeTeam);
	    in.writeString(visitingTeam);
	    in.writeString(facebookNetwork);
	    in.writeString(twitterNetwork);
        in.writeString(foursquareNetwork);
        in.writeString(createdByUserName);
        in.writeInt(createdByUserID);
        in.writeInt(wagerType);
        in.writeInt(wagerUnits);
	}
	public Game(String taskName) {
		title = taskName;
	}
	public int getCreatedByUserID() {
		return this.createdByUserID;
	}
	public String getCreatedByUserName() {
		return this.createdByUserName;
	}
	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}
	
	public int getWagerUnits() {
		return wagerUnits;
	}
	public void setWagerUnits(int wagerUnits) {
		this.wagerUnits = wagerUnits;
	}
	public String getSubscribeCloseDate() {
		return subscribeCloseDate;
	}
	public void setSubscribeCloseDate(String subscribeCloseDate) {
		this.subscribeCloseDate = subscribeCloseDate;
	}
	public int getWagerType() {
		return wagerType;
	}
	public void setCreatedByID(int createdByUserID) {
		this.createdByUserID = createdByUserID;
	}
	public void setCreatedByUserName(String createdByUserName) {
		this.createdByUserName = createdByUserName;
	}
	public String getFacebookNetwork() {
		return facebookNetwork;
	}
	public String getTwitterNetwork() {
		return twitterNetwork;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setTwitterNetwork(String twitterNetwork) {
		this.twitterNetwork = twitterNetwork;
	}
	public String getFoursquareNetwork() {
		return foursquareNetwork;
	}
	public void setFoursquareNetwork(String foursquareNetwork) {
		this.foursquareNetwork = foursquareNetwork;
	}
	public void setFacebookNetwork(String facebookNetwork) {
		this.facebookNetwork = facebookNetwork;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
	public String getHomeTeam() {
		return homeTeam;
	}
	public String getVisitingTeam() {
		return visitingTeam;
	}
	public void setVisitingTeam(String visitingTeam) {
		this.visitingTeam = visitingTeam;
	}
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public int getNumberSubscribers() {
		return numberSubscribers;
	}
	public void setNumberSubscribers(int numberSubscribers) {
		this.numberSubscribers = numberSubscribers;
	}
	public void setId(long id) {
		this.id = id;
	}

	public void setWagerType(int in) {
		wagerType = in;
	}
	
	public long getId() {
		return id;
	}

	public void setName(String name) {
		this.title = name;
	}

	public String getName() {
		return title;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setComplete(boolean complete) {
		this.complete = complete;
	}

	public boolean isComplete() {
		return complete;
	}

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}
	public void toggleComplete() {
		complete = !complete;
	}

	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	

	
	@Override
	public String toString() {
		return "Game [complete=" + complete + ", description=" + description
				+ ", eventDate=" + eventDate + ", id=" + id
				+ ", numberSubscribers=" + numberSubscribers + ", title="
				+ title + ", type=" + type + ", visibility=" + visibility
				+ ", getCreatedDate()=" + getCreatedDate()
				+ ", getModifiedDate()=" + getModifiedDate() + "]";
	}



}