
package com.whiteboard.models;

import java.util.List;

public class Project{

   	private String _id;
   	private Creator creator;
   	private String dateCreated;
   	private String description;
   	private Number numPositions;
   	private Number numViews;
   	private String positionName;
   	private List<String> preferredSkills;
   	private String startDate;
   	private String timeRequired;
   	private String title;

 	public String get_id(){
		return this._id;
	}
	public void set_id(String _id){
		this._id = _id;
	}
 	public Creator getCreator(){
		return this.creator;
	}
	public void setCreator(Creator creator){
		this.creator = creator;
	}
 	public String getDateCreated(){
		return this.dateCreated;
	}
	public void setDateCreated(String dateCreated){
		this.dateCreated = dateCreated;
	}
 	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
 	public Number getNumPositions(){
		return this.numPositions;
	}
	public void setNumPositions(Number numPositions){
		this.numPositions = numPositions;
	}
 	public Number getNumViews(){
		return this.numViews;
	}
	public void setNumViews(Number numViews){
		this.numViews = numViews;
	}
 	public String getPositionName(){
		return this.positionName;
	}
	public void setPositionName(String positionName){
		this.positionName = positionName;
	}
 	public List<String> getPreferredSkills(){
		return this.preferredSkills;
	}
	public void setPreferredSkills(List<String> preferredSkills){
		this.preferredSkills = preferredSkills;
	}
 	public String getStartDate(){
		return this.startDate;
	}
	public void setStartDate(String startDate){
		this.startDate = startDate;
	}
 	public String getTimeRequired(){
		return this.timeRequired;
	}
	public void setTimeRequired(String timeRequired){
		this.timeRequired = timeRequired;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
}
