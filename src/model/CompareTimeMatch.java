package model;

import java.util.Comparator;

public class CompareTimeMatch implements Comparator <Match>{

	
	public int compare(Match c1, Match c2) {
		return (int) (c1.getTime()- c2.getTime());	
	
	}

	
}
