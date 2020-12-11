package model;

import javax.swing.JOptionPane;


public class Exceptions {
	

	
	public Exceptions () {
		
	}
public boolean isNullUser(String e) {
if(e.trim().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos de registro", "Woops", JOptionPane.ERROR_MESSAGE);
	return true;
}else {
	return false;
}
}
public boolean isNullLog(String e) {
if(e.trim().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos de ingreso", "Woops", JOptionPane.ERROR_MESSAGE);
	return true;
}else {
	return false;
}
}
public boolean minCharPassword(String e) {
	if(e.length()<8) {
		JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos 8 caracteres", "Woops", JOptionPane.ERROR_MESSAGE);
		return false;
	}else {
		return true;
	}
}
public boolean minCharUser(String e) {
	if(e.length()<3) {
		JOptionPane.showMessageDialog(null, "El usuario debe tener al menos 3 caracteres", "Woops", JOptionPane.ERROR_MESSAGE);
		return false;
	}else {
		return true;
	}
	}
	public boolean numPassword(String e) {
		
		for (int i = 0; i < e.length(); i++) {
			   
			if((e.charAt(i)=='0')||(e.charAt(i)=='1')||(e.charAt(i)=='2')||(e.charAt(i)=='3')||(e.charAt(i)=='4')||
			   (e.charAt(i)=='5')||(e.charAt(i)=='6')||(e.charAt(i)=='7')||(e.charAt(i)=='8')||(e.charAt(i)=='9')) {
				return true;
			}
			
		}JOptionPane.showMessageDialog(null, "La contraseña debe tener al menos un número", "Woops", JOptionPane.ERROR_MESSAGE);
		return false;
	}
	public boolean notRegInSystem(String e, String d) {
		if(e==null||d==null) {
			JOptionPane.showMessageDialog(null, "El usuario no se encuentra registrado en el sistema", "Woops", JOptionPane.ERROR_MESSAGE);
			return true;
		}else {
			return false;
		}
		}
	public boolean isNullMatch(int e) {
		if(e==0) {
			return true;
		}else {return false;
		}
		
	}

}
