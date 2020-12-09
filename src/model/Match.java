package model;


public class Match implements Comparable <Match>{

	String name, date;
	private int score, time;
	
	public Match(String name,String date,int score,int time) {
		this.name=name;
		this.date=date;
		this.score=score;
		this.time=time;
	}
	
	public int compareTo(Match c) {
		return this.getName().compareTo(c.getName()); 
	}

	
	
	
	//Getters & Setters
	public String getName() {
		return this.name;
	}
	
	public String getDate() {
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
