package model;

import javax.swing.JOptionPane;


public class Exceptions {
	

	
	public Exceptions () {
		
	}
public boolean isNullUser(String e) {
if(e.trim().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Woops", JOptionPane.ERROR_MESSAGE);
	return true;
}else {
	return false;
}
}
public boolean isNullLog(String e) {
if(e.trim().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos", "Woops", JOptionPane.ERROR_MESSAGE);
	return true;
}else {
	return false;
}
}
}
