package model;

import java.util.Collections;
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
	int sec, scores2;
	int timer = 0;
	int cont = 0;
	int cont1 = 0;
	public Match name;
	private LinkedList<Match> match;
	private CompareDateMatch date;
	private CompareScoreMatch score;
	private CompareTimeMatch time;
	private Arepa prota;
	private int backX ;
	int bx;
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
		// ost = new SoundFile(app, "../music/ost.mp3");
		match = new LinkedList<Match>();
		this.date = new CompareDateMatch();
		this.score = new CompareScoreMatch();
		this.time = new CompareTimeMatch();

		// ----------NO FUNCIONA---------- (hilo para que cargue más rápido la música,
		// no sirve por falta de memoria)
		// loadingBoolean = false;

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

		screenNum = 0;
		splash = new ScreenSplash(app);
		login = new ScreenLog(app);
		register = new ScreenReg(app);
		home = new ScreenHome(app);
		map = new ScreenGame(app);
		scores = new ScreenScore(app);
		win = new ScreenWin(app);
		lose = new ScreenGameOver(app);

		bx=1;
		backX = 0;
		prota = new Arepa(0, 1, 4, app);
		matrix = new int[][] {

				/*
				 * 0 = zonas vacías 1 = piso 2 = zonas de daño 3 = cuadros de muerte 4 =
				 * bloqueos /** esto esta puesto cada 10 casillas para usarlo como guía para
				 * orgnizar el arreglo
				 * 
				 * 
				 */
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4,4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4 },
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0,0/**/, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0 },
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0,0/**/, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0 },
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0,0/**/, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0 },
				{ 4, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 1, 0, 0, 0, 0, 1, 1, 0,0/**/, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/, 1, 0, 0, 0, 1, 0, 2, 0, 0, 0/**/, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0 },
				{ 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1/**/, 1, 1, 1, 1, 1, 1, 1, 1, 1,1/**/, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1/**/, 1, 1, 1, 1, 1, 1, 1 },
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 3, 3, 4, 4, 4, 4, 3, 3, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4,4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 3, 3, 3, 3, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4 }, };
	}

	public void draw() {

		switch (screenNum) {
		case 0:
			// no se pinta por alguna razón pero permite que cargue el splash page
			app.background(255);
			app.fill(0, 120, 255);
			app.textSize(50);
			app.text("loading...", app.width / 2 - 90, app.height / 2);
			// validarLoading();
			break;
		case 1:
			// SPLASH SCREEN
			splash.draw();
			break;
		case 2:
			// LOGIN
			login.draw();
			// splash.draw();
			break;
		case 3:
			// REGISTER
			register.draw();
			break;
		case 4:
			// HOME
			home.draw();
			// System.out.println(loadingBoolean);
			// System.out.println(loadingBoolean);
			break;
		case 5:
			// SCORES
			scores.draw();
			break;
		case 6:

			// GAME SCREEN
			sec = PApplet.second();

		
			map.draw(backX);
			prota.draw();
			// temporizador
			if (sec > timer) {
				timer = sec;
				cont++;
			}
			if (sec > 60) {
				sec = 0;
			}
			if (cont >= 60) {
				cont1++;
			}

			app.fill(238, 19, 19);
			app.textSize(25);
			app.text(cont1 + ":" + cont, 150, 30);
			app.text("Timer:", 60, 30);

			app.fill(238, 19, 19);
			app.textSize(25);
			app.text("Score:", 230, 30);
			app.text(scores2, 315, 30);

			break;
		case 7:
			// WIN
			win.draw();
			break;
		case 8:
			// GAME OVER
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
		// SWITCH DE CAMBIO DE PANTALLAS
		switch (screenNum) {
		case 0:
			screenNum = 1;
			break;
		case 1:

			//DE SPLASH A LOGIN
			login.textFields();
			 screenNum=2;
			break;
		case 2:
			//DE LOGIN A REGISTER
			if((613>app.mouseX&&app.mouseX>387)&&(675>app.mouseY&&app.mouseY>654)) {
				login.hide();
				register.textFields();
				screenNum=3;
			}
			//DE LOGIN A HOME
			if((637>app.mouseX&&app.mouseX>363)&&(582>app.mouseY&&app.mouseY>512)) {
				login.hide();
				screenNum=4;
				}
				break;
		case 3:
			//DE REGISTER A LOGIN
			if((637>app.mouseX&&app.mouseX>363)&&(647>app.mouseY&&app.mouseY>583)) {
				register.hide();
				login.textFields();
				screenNum=2;
				}
				break;

		case 4:
			// DE HOME A SCORES
			if ((637 > app.mouseX && app.mouseX > 363) && (569 > app.mouseY && app.mouseY > 503)) {
				screenNum = 5;
			}
			// DE HOME A GAME SCREEN
			if ((637 > app.mouseX && app.mouseX > 363) && (456 > app.mouseY && app.mouseY > 389)) {
				// Esto es para que se de play la música
//				ost.play();
//				screenNum=6;
				// if(loadingBoolean == true) {
				// ost.play();
				screenNum = 6;
				// }

			}
			break;
		case 5:
			// DE SCORES A HOME
			if ((125 > app.mouseX && app.mouseX > 39) && (92 > app.mouseY && app.mouseY > 24)) {
				screenNum = 4;
			}
			// ORDENAMIENTO USUARIO
			if ((475 > app.mouseX && app.mouseX > 201) && (595 > app.mouseY && app.mouseY > 530)) {
				System.out.println("ordenamiento por usuario");
			}
			// ORDENAMIENTO TIEMPO
			if ((475 > app.mouseX && app.mouseX > 201) && (673 > app.mouseY && app.mouseY > 606)) {
				System.out.println("ordenamiento por tiempo");
			}
			// ORDENAMIENTO FECHA
			if ((796 > app.mouseX && app.mouseX > 519) && (673 > app.mouseY && app.mouseY > 606)) {
				System.out.println("ordenamiento por fecha");
			}
			// ORDENAMIENTO PUNTAJE
			if ((796 > app.mouseX && app.mouseX > 519) && (595 > app.mouseY && app.mouseY > 530)) {
				System.out.println("ordenamiento por puntaje");
			}
			break;
		case 7:

			//DE WIN A HOME
			if((620>app.mouseX&&app.mouseX>350)&&(672>app.mouseY&&app.mouseY>602)) {
				win.hide();
				screenNum=4;
				}
				break;

		case 8:
			// DE LOSE A HOME
			if ((816 > app.mouseX && app.mouseX > 539) && (560 > app.mouseY && app.mouseY > 493)) {
				screenNum = 4;
			}
			// DE LOSE A GAME SCREEN
			if ((457 > app.mouseX && app.mouseX > 181) && (560 > app.mouseY && app.mouseY > 493)) {
				// Esto es para que se de play la música

				ost.play();
				screenNum = 6;
//				if(loadingBoolean == true) {
//					ost.play();
//					screenNum=6;
//				}
				break;

			}

		}

	}

	public void move(int i) {
	if(bx>=58) {screenNum=7;}
		switch (i) {
		case 0:
			if (matrix[prota.getPosY()+1][bx] == 1) {
			prota.move(i);
			prota.move(i);
			prota.move(i);
			move(1);
			}
			break;
		case 1:
			if (matrix[prota.getPosY()+1][bx] != 1) {
			prota.move(i);
			}
			break;
		case 2:
			if (matrix[prota.getPosY()][bx] != 1) {
		bx--;
				backX++;
				move(1);
				
			}
			break;
		
		case 3:
			if (matrix[prota.getPosY()][bx+2] != 1) {
				bx++;
			backX--;
			move(1);
			}
			
			break;

		}
		
		System.out.println(bx);
		}

	public void sortList(int s) {
		switch (s) {
		case 0:
			Collections.sort(match);
			break;
		case 1:
			Collections.sort(match, date);
			break;
		case 2:
			Collections.sort(match, score);
			break;
		case 3:
			Collections.sort(match, time);
			break;
		}
	}

	public LinkedList<Match> getList() {
		return match;

	}

	public void setMatch(LinkedList<Match> match) {
		this.match = match;

	}
}
