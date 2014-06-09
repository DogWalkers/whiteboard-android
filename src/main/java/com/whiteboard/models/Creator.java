
package com.whiteboard.models;

import java.util.List;

public class Creator{

   	private String _id;
   	private List<String> skills;
   	private String timeCreated;

 	public String get_id(){
		return this._id;
	}
	public void set_id(String _id){
		this._id = _id;
	}
 	public List<String> getSkills(){
		return this.skills;
	}
	public void setSkills(List<String> skills){
		this.skills = skills;
	}
 	public String getTimeCreated(){
		return this.timeCreated;
	}
	public void setTimeCreated(String timeCreated){
		this.timeCreated = timeCreated;
	}
}
