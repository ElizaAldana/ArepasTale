package model;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import processing.core.PApplet;
import processing.sound.SoundFile;
import view.ScreenGame;
import view.ScreenGameOver;
import view.ScreenHome;
import view.ScreenLog;
import view.ScreenReg;
import view.ScreenScore;
import view.ScreenSplash;
import view.ScreenWin;

public class Logic {
	
	boolean loadingBoolean;

	private PApplet app;
	int[][] matrix;
	SoundFile ost; 	
	int screenNum;
	private LinkedList<Nombre> name;



	    ScreenSplash splash;
		ScreenLog login;
		ScreenReg register;
		ScreenHome home;
		ScreenGame map;
		ScreenScore scores;
		ScreenWin win;
		ScreenGameOver lose;
		

	public Logic(PApplet app) {
		this.app = app;		
		ost = new SoundFile(app, "../music/ost.mp3");
		
		//----------NO FUNCIONA---------- (hilo para que cargue más rápido la música, no sirve por falta de memoria)
		//loadingBoolean = false;
		
//		if(loadingBoolean == false) {
//			new Thread(
//				() -> {
//					try {
//						while(!loadingBoolean) {
//							System.out.println("Esta cargando el archivo de arepasTaleOst en un hilo aparte...");
//							
//							System.out.println("Si funciono");
//							loadingBoolean = true;
//							Thread.sleep(1);
//							//TimeUnit.MILLISECONDS.sleep(100);
//							System.out.println(loadingBoolean);
//						}
//						//loadingBoolean = true;
//						//System.out.println(loadingBoolean);
//						Thread.sleep(1);
//						TimeUnit.MILLISECONDS.sleep(1);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				).start();
//		}
//		if(loadingBoolean = true) {
//			ost = new SoundFile(app, "../music/ost.mp3");
//		}

		
		screenNum=1;
		splash = new ScreenSplash(app);
		login = new ScreenLog(app);
		register = new ScreenReg(app);
		home = new ScreenHome(app);
		map = new ScreenGame(app);
		scores = new ScreenScore(app);
		win = new ScreenWin(app);
		lose = new ScreenGameOver(app);
		
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
	
	
	public void draw() {
		switch(screenNum) {
		case 0:
			//no se pinta por alguna razón pero permite que cargue el splash page
			app.background(255);
			app.fill(0,120,255);
			app.textSize(50);
			app.text("loading...", app.width/2-50, app.height/2);
			//validarLoading();
			break;
		case 1:
			//SPLASH SCREEN
			splash.draw();
			break;
		case 2:
		//LOGIN
			login.draw();
			//splash.draw();
			break;
		case 3:
		//REGISTER
			register.draw();
			break;
		case 4:
			//HOME
			home.draw();
			//System.out.println(loadingBoolean);
			//System.out.println(loadingBoolean);
			break;
		case 5:
			//SCORES
			scores.draw();
			break;
		case 6:
			//GAME SCREEN
			map.draw();
			break;
		case 7:
			//WIN
			win.draw();
			break;
		case 8:
			//GAME OVER
			lose.draw();
			break;
		}
		
	}
	
//	public void validarLoading() {
//		if(loadingBoolean == true) {
//			ost.play();
//			screenNum=6;
//		}
//	}
	
	public void mouseClicked() {
		//SWITCH DE CAMBIO DE PANTALLAS
		switch(screenNum) {
		case 0:
			screenNum=1;
			break;
		case 1:
			//DE SPLASH A LOGIN
			 screenNum=2;
			break;
		case 2:
			//DE LOGIN A REGISTER
			if((613>app.mouseX&&app.mouseX>387)&&(675>app.mouseY&&app.mouseY>654)) {
				screenNum=3;
			}
			//DE LOGIN A HOME
			if((637>app.mouseX&&app.mouseX>363)&&(582>app.mouseY&&app.mouseY>512)) {
				screenNum=4;
				}
				break;
		case 3:
			//DE REGISTER A LOGIN
			if((637>app.mouseX&&app.mouseX>363)&&(647>app.mouseY&&app.mouseY>583)) {
				screenNum=2;
				}
				break;
		case 4:
			//DE HOME A SCORES
			if((637>app.mouseX&&app.mouseX>363)&&(569>app.mouseY&&app.mouseY>503)) {
				screenNum=5;			}
			//DE HOME A GAME SCREEN
			if((637>app.mouseX&&app.mouseX>363)&&(456>app.mouseY&&app.mouseY>389)) {
				//Esto es para que se de play la música
//				ost.play();
//				screenNum=6;
				//if(loadingBoolean == true) {
					ost.play();
					screenNum=6;
				//}
				
				}
			break;
		case 5:
			//DE SCORES A HOME
			if((125>app.mouseX&&app.mouseX>39)&&(92>app.mouseY&&app.mouseY>24)) {
				screenNum=4;
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
				screenNum=4;
				}
				break;
		case 8:
			//DE LOSE A HOME
			if((816>app.mouseX&&app.mouseX>539)&&(560>app.mouseY&&app.mouseY>493)) {
				screenNum=4;
				}
			//DE LOSE A GAME SCREEN
			if((457>app.mouseX&&app.mouseX>181)&&(560>app.mouseY&&app.mouseY>493)) {
				//Esto es para que se de play la música

				
				ost.play();
				screenNum=6;
//				if(loadingBoolean == true) {
//					ost.play();
//					screenNum=6;
//				}
				break;
			
			}
		
	}

	
 }
}
