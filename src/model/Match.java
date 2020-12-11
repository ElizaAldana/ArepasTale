package model;

import processing.core.PApplet;

public class Match implements Comparable <Match>{

	PApplet app;
	String name, date;
	private int score, time;
	
	public Match(String name,String date,int score,int time, PApplet app) {
		this.name=name;
		this.date=date;
		this.score=score;
		this.time=time;
	}
	
	public int compareTo(Match c) {
		return this.getName().compareTo(c.getName()); 
	}

	public void draw(int x, int y) {
		app.fill(0);
		app.text(this.name, x, y);
		y+=70;
		app.text(this.date, x, y);
		y+=70;
		app.text(this.score, x, y);
		y+=70;
		app.text(this.time, x, y);
		y+=70;
	}
	
	public void drawName(int x, int y) {
		app.text(this.name, x, y);
	}
	
	public void drawDate(int x, int y) {
		app.text(this.date, x, y);
	}
	
	public void drawScore(int x, int y) {
		app.text(this.score, x, y);
	}
	
	public void drawTime(int x, int y) {
		app.text(this.time, x, y);
	}
	
	
	//Getters & Setters
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return this.date;
	}

	public String setDate() {
		return this.date;
	}
	
	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	

	
	

}
