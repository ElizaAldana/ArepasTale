package model;

import java.util.Comparator;

public class CompareDateMatch implements Comparator <Match>{

	
	public int compare(Match o1, Match o2) {
		return o1.getDate().compareTo(o2.getDate());
	}

	
	

}
