package view;

import controller.Controller;
import processing.core.PApplet;


public class Main extends PApplet {
	
	private Controller control;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main(Main.class.getName());
	}
	int screenNum;
	ScreenSplash splash;
	ScreenLog login;
	ScreenReg register;
	ScreenHome home;
	ScreenGame map;
	ScreenScore scores;
	ScreenWin win;
	ScreenGameOver lose;
	
	
	
	public void settings() {
		size(1000,700);

	}

	public void setup() {
		this.control = new Controller(this);
		screenNum=8;
		splash = new ScreenSplash(this);
		login = new ScreenLog(this);
		register = new ScreenReg(this);
		home = new ScreenHome(this);
		map = new ScreenGame(this);
		scores = new ScreenScore(this);
		win = new ScreenWin(this);
		lose = new ScreenGameOver(this);
	}

	public void draw() {
		System.out.println(mouseX);
		System.out.println(mouseY);
		switch(screenNum) {
		case 1:
			//SPLASH SCREEN
			splash.draw();
			break;
		case 2:
		//LOGIN
			login.draw();
			break;
		case 3:
		//REGISTER
			register.draw();
			break;
		case 4:
			//HOME
				home.draw();
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

	public void keyPressed() {

	}

	public void keyReleased() {
		
	}
	
	public void mouseClicked() {
		switch(screenNum) {
		case 1:
			//DE SPLASH A LOGIN
			screenNum=2;
			break;
		case 2:
			//DE LOGIN A REGISTER
			if((613>mouseX&&mouseX>387)&&(675>mouseY&&mouseY>654)) {
				screenNum=3;
			}
			//DE LOGIN A HOME
			if((637>mouseX&&mouseX>363)&&(582>mouseY&&mouseY>512)) {
				screenNum=4;
				}
				break;
		case 3:
			//DE REGISTER A LOGIN
			if((637>mouseX&&mouseX>363)&&(647>mouseY&&mouseY>583)) {
				screenNum=2;
				}
				break;
		case 4:
			//DE HOME A SCORES
			if((637>mouseX&&mouseX>363)&&(569>mouseY&&mouseY>503)) {
				screenNum=5;
			}
			//DE HOME A GAME SCREEN
			if((637>mouseX&&mouseX>363)&&(456>mouseY&&mouseY>389)) {
				this.control.mouseClick();
				screenNum=6;
				}
				break;
		case 5:
			//DE SCORES A HOME
			if((125>mouseX&&mouseX>39)&&(92>mouseY&&mouseY>24)) {
				screenNum=4;
				}
			//ORDENAMIENTO USUARIO
			if((475>mouseX&&mouseX>201)&&(595>mouseY&&mouseY>530)) {
				System.out.println("ordenamiento por usuario");
				}
			//ORDENAMIENTO TIEMPO
			if((475>mouseX&&mouseX>201)&&(673>mouseY&&mouseY>606)) {
				System.out.println("ordenamiento por tiempo");
				}
			//ORDENAMIENTO FECHA
			if((796>mouseX&&mouseX>519)&&(673>mouseY&&mouseY>606)) {
				System.out.println("ordenamiento por fecha");
				}
			//ORDENAMIENTO PUNTAJE
			if((796>mouseX&&mouseX>519)&&(595>mouseY&&mouseY>530)) {
				System.out.println("ordenamiento por puntaje");
				}
				break;
		case 7:
			//DE WIN A HOME
			if((620>mouseX&&mouseX>350)&&(672>mouseY&&mouseY>602)) {
				screenNum=4;
				}
				break;
		case 8:
			//DE LOSE A HOME
			if((816>mouseX&&mouseX>539)&&(560>mouseY&&mouseY>493)) {
				screenNum=4;
				}
			//DE LOSE A GAME SCREEN
			if((457>mouseX&&mouseX>181)&&(560>mouseY&&mouseY>493)) {
				this.control.mouseClick();
				screenNum=6;
				}
				break;
			
			}
		}

	public void setScreenNum(int screenNum) {
		this.screenNum = screenNum;
	}

	public int getScreenNum() {
		return screenNum;
	}
		
	}

