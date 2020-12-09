package model;

import java.util.Comparator;

public class CompareScoreMatch implements Comparator <Match>{


	
	public int compare(Match arg0, Match arg1) {
		return (int) (arg0.getScore()- arg1.getScore());	
	}

}
