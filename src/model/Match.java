package model;


public class Match implements Comparable <Match>{

	String name, date;
	private int score, time;
	
	
	
	public int compareTo(Match o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

	
	//Getters & Setters
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
