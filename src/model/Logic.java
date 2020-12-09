package model;

import processing.core.PApplet;
import processing.sound.SoundFile;
import view.Main;

public class Logic {

	private PApplet app;
	int[][] matrix;
	SoundFile ost; 	
	  private final Main main; 
	  int screenNumL;
	

	public Logic(PApplet app) {
		this.main = new Main();
		this.app = app;		
		ost = new SoundFile(app, "../music/ost.mp3");
		 screenNumL=1;

		matrix = new int[][] {

				/*
				 0 = zonas vacías
				  1 = piso
				   2 = zonas de daño
				    3 = cuadros de muerte
				     4 = bloqueos
				    /** esto esta puesto cada 10 casillas para usarlo como guía para orgnizar el arreglo
				     
				     
				 */
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4}, 
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 1, 0, 0, 0, 0, 1, 1, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,1, 0, 0, 0, 1, 0, 2, 0, 0, 0/**/,2, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0/**/, 1, 0, 0, 1, 1, 1, 1, 2, 2, 1/**/,1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/,1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/,1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/,1, 1, 1, 0, 0, 1, 0, 1, 1, 1/**/, 1, 1, 1, 1, 1, 1, 1},
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 3, 3, 4, 4, 4, 4, 3, 3, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 3, 3, 3, 3, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4}, };
	}
	
	
	public void mouseclicked() {
		//SWITCH DE CAMBIO DE PANTALLAS
		switch(screenNumL) {
		case 1:
			//DE SPLASH A LOGIN
			 screenNumL=2;
			main.setScreenNum(2);
			break;
		case 2:
			//DE LOGIN A REGISTER
			if((613>app.mouseX&&app.mouseX>387)&&(675>app.mouseY&&app.mouseY>654)) {
				main.setScreenNum(3);
			}
			//DE LOGIN A HOME
			if((637>app.mouseX&&app.mouseX>363)&&(582>app.mouseY&&app.mouseY>512)) {
				main.setScreenNum(4);
				}
				break;
		case 3:
			//DE REGISTER A LOGIN
			if((637>app.mouseX&&app.mouseX>363)&&(647>app.mouseY&&app.mouseY>583)) {
				main.setScreenNum(2);
				}
				break;
		case 4:
			//DE HOME A SCORES
			if((637>app.mouseX&&app.mouseX>363)&&(569>app.mouseY&&app.mouseY>503)) {
				main.setScreenNum(5);			}
			//DE HOME A GAME SCREEN
			if((637>app.mouseX&&app.mouseX>363)&&(456>app.mouseY&&app.mouseY>389)) {
				//Esto es para que se de play la música
				ost.play();
				main.setScreenNum(6);
				}
				break;
		case 5:
			//DE SCORES A HOME
			if((125>app.mouseX&&app.mouseX>39)&&(92>app.mouseY&&app.mouseY>24)) {
				main.setScreenNum(4);
				}
			//ORDENAMIENTO USUARIO
			if((475>app.mouseX&&app.mouseX>201)&&(595>app.mouseY&&app.mouseY>530)) {
				System.out.println("ordenamiento por usuario");
				}
			//ORDENAMIENTO TIEMPO
			if((475>app.mouseX&&app.mouseX>201)&&(673>app.mouseY&&app.mouseY>606)) {
				System.out.println("ordenamiento por tiempo");
				}
			//ORDENAMIENTO FECHA
			if((796>app.mouseX&&app.mouseX>519)&&(673>app.mouseY&&app.mouseY>606)) {
				System.out.println("ordenamiento por fecha");
				}
			//ORDENAMIENTO PUNTAJE
			if((796>app.mouseX&&app.mouseX>519)&&(595>app.mouseY&&app.mouseY>530)) {
				System.out.println("ordenamiento por puntaje");
				}
				break;
		case 7:
			//DE WIN A HOME
			if((620>app.mouseX&&app.mouseX>350)&&(672>app.mouseY&&app.mouseY>602)) {
				main.setScreenNum(4);
				}
				break;
		case 8:
			//DE LOSE A HOME
			if((816>app.mouseX&&app.mouseX>539)&&(560>app.mouseY&&app.mouseY>493)) {
				main.setScreenNum(4);
				}
			//DE LOSE A GAME SCREEN
			if((457>app.mouseX&&app.mouseX>181)&&(560>app.mouseY&&app.mouseY>493)) {
				//Esto es para que se de play la música
				ost.play();
				main.setScreenNum(6);				}
				break;
			
			}
		
	}

	
}
