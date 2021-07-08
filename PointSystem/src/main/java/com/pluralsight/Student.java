package com.pluralsight;

public class Student {
	private String firstName;
	private String lastName;
	private String track;
	private int score;
	
	public Student(String firstName, String lastName, String track, int score) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.track = track;
		this.score = score;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() { 
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getTrack() {
		return track;
	}
	
	public void setTrack(String track) {
		this.track = track;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	

}


