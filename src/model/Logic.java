package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import processing.core.PApplet;
import processing.core.PImage;
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
	SoundFile ost, coinSound;
	int screenNum;
	int sec, scores2;
	int timer = 0;
	int cont = 0;
	int cont1 = 0;
	

	int compareClick;
	

	int posX;
	int posY;
	
	public Match name;
	private LinkedList<Match> match;
	private CompareDateMatch date;
	private CompareScoreMatch score;
	private CompareTimeMatch time;
	private Arepa prota;


	//Crear las array de los enemigos y monedas
	private ArrayList<EnemyKnife> cuchillo;
	private ArrayList<EnemyRat> rata;
	private ArrayList<EnemyFire> fire;
	private ArrayList<Cheese> coin;


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
	Exceptions except;
	PImage timeField;
	PImage scoreField;
	
	public Logic(PApplet app) {
		this.app = app;
		ost = new SoundFile(app, "../music/ost.mp3");
		coinSound = new SoundFile(app,"../music/coin.mp3");
		match = new LinkedList<Match>();
		this.date = new CompareDateMatch();
		this.score = new CompareScoreMatch();
		this.time = new CompareTimeMatch();


		//Set de las array de los enemigos y monedas
		this.cuchillo = new ArrayList<>();
		this.rata = new ArrayList<>();
		this.fire = new ArrayList<>();
		this.coin = new ArrayList<>();
		

		screenNum = 1;

		
		

		splash = new ScreenSplash(app);
		login = new ScreenLog(app);
		register = new ScreenReg(app);
		home = new ScreenHome(app);
		map = new ScreenGame(app);
		scores = new ScreenScore(app);
		win = new ScreenWin(app);
		lose = new ScreenGameOver(app);
		except = new Exceptions();

		bx=1;
		backX = 0;

		
		posX = 1;
		posY = 4;
		
		//Agregar al protagonista en el lugar indicado.
		prota = new Arepa(0, posX, posY, app);

		//Agregar a las ratas en el lugar indicado.
		rata.add(new EnemyRat(backX, 5, 4, 1, 1, app));
		rata.add(new EnemyRat(0, 28, 4, 1, 1, app));

		
		//Agregar cuchillos salvajes
		cuchillo.add(new EnemyKnife(backX, 31, 2, app));
		cuchillo.add(new EnemyKnife(backX, 33, 2, app));
		cuchillo.add(new EnemyKnife(backX, 35, 2, app));
		
		//Agregar al fuego
		fire.add(new EnemyFire(backX, 46, 4, app));
		fire.add(new EnemyFire(backX, 50, 4, app));

		//46, 50
		
		//Agregar coin
		coin.add(new Cheese(backX, 4, 2,app));
		coin.add(new Cheese(backX, 8, 2,app));
		coin.add(new Cheese(backX, 11, 2,app));
		coin.add(new Cheese(backX, 17, 2,app));
		coin.add(new Cheese(backX, 21, 2,app));
		coin.add(new Cheese(backX, 24, 4,app));
		coin.add(new Cheese(backX, 27, 2,app));
		coin.add(new Cheese(backX, 32, 2,app));
		coin.add(new Cheese(backX, 34, 2,app));
		coin.add(new Cheese(backX, 37, 2,app));
		coin.add(new Cheese(backX, 40, 2,app));
		coin.add(new Cheese(backX, 44, 2,app));
		coin.add(new Cheese(backX, 47, 2,app));
		coin.add(new Cheese(backX, 49, 2,app));
		coin.add(new Cheese(backX, 55, 2,app));
		//int backX, int posX, int posY, int dirX, int vel,PApplet app
		
		int datesssss;
		//Agregar los pngs de los campos de tiempo y puntaje
		timeField = app.loadImage("pngs/characters/Time.png");
		scoreField = app.loadImage("pngs/characters/Score.png");
		

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
				{ 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1/**/, 1, 1, 1, 1, 1, 1, 1, 1, 1,1/**/, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1/**/, 1, 1, 1, 1, 1, 1, 1 },
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 3, 3, 4, 4, 4, 4, 3, 3, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4,4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 3, 3, 3, 3, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4 }, };
	}

	public String getDate(){
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = new Date();

	    return dateFormat.format(date);
	}
	
	public void draw() {

		switch (screenNum) {
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
	
			break;
		case 5:
			// SCORES
			scores.draw();
			break;
		case 6:
			// GAME SCREEN
			sec = PApplet.second();

			//Acá se pintan el mapa y el protagonista
			map.draw(backX);
			prota.draw();
			colicionRata();
			//Pintar el método de validar cuando se coge una moneda
			validarMoneda();

			//Aquí se pintan las cositas(enemigos y monedas)
			for (int i = 0; i < cuchillo.size(); i++) {
				cuchillo.get(i).draw(backX);
			}
			for (int i = 0; i < fire.size(); i++) {
				fire.get(i).draw(backX);
			}
			for (int i = 0; i < rata.size(); i++) {
				rata.get(i).draw(backX);
				
			}
			for (int i = 0; i < coin.size(); i++) {
				coin.get(i).draw(backX);
			}

			// Temporizador

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
			app.text(cont1 + ":" + cont, 65, 38);
			app.image(timeField, 80, 30,121,41);

			app.fill(238, 19, 19);
			app.textSize(25);
			app.image(scoreField, 250, 30,121,41);
			app.text(scores2, 235, 38);

			break;
		case 7:
			// WIN
			win.draw();
			app.text(cont1 + ":" + cont, 657, 556);
			app.text(scores2, 306, 556);
			break;
		case 8:
			// GAME OVER
			lose.draw();
			break;
		}

	}


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
				login.logU();
				if(!(except.isNullUser(login.getPassword()))&&!(except.isNullUser(login.getUser()))) {
					if(!except.notRegInSystem(register.getUser(), register.getPassword())) {
				login.hide();
				screenNum=4;
						}
					}
				}
				break;
		case 3:
			//DE REGISTER A LOGIN
			if((637>app.mouseX&&app.mouseX>363)&&(647>app.mouseY&&app.mouseY>583)) {
				register.regU();
				if(!(except.isNullUser(register.getPassword()))&&!(except.isNullUser(register.getUser()))) {
					if(except.minCharPassword(register.getPassword())
					 &&except.minCharUser(register.getUser())
				     &&except.numPassword(register.getPassword())) {
				register.hide();
				login.textFields();
				screenNum=2;
				}}
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
			ost.play();
			screenNum = 6;
			
			//hilo rata
			for (int i = 0; i < rata.size(); i++) {
				new Thread(rata.get(i)).start();
			}
			

			}
			break;
		case 5:
			// DE SCORES A HOME
			if ((125 > app.mouseX && app.mouseX > 39) && (92 > app.mouseY && app.mouseY > 24)) {
				screenNum = 4;
						restartGame();
			}
			// ORDENAMIENTO USUARIO
			if ((475 > app.mouseX && app.mouseX > 201) && (595 > app.mouseY && app.mouseY > 530)) {
				System.out.println("ordenamiento por usuario");
				compareClick = 0;
			}
			// ORDENAMIENTO TIEMPO
			if ((475 > app.mouseX && app.mouseX > 201) && (673 > app.mouseY && app.mouseY > 606)) {
				System.out.println("ordenamiento por tiempo");
				compareClick = 3;
			}
			// ORDENAMIENTO FECHA
			if ((796 > app.mouseX && app.mouseX > 519) && (673 > app.mouseY && app.mouseY > 606)) {
				System.out.println("ordenamiento por fecha");
				compareClick = 1;
			}
			// ORDENAMIENTO PUNTAJE
			if ((796 > app.mouseX && app.mouseX > 519) && (595 > app.mouseY && app.mouseY > 530)) {
				System.out.println("ordenamiento por puntaje");
				compareClick = 2;
			}
			for (int i = 0; i < match.size(); i++) {
				match.get(i).draw(30,30);
			}
			sortList(compareClick);
			break;
		case 7:

			//DE WIN A PUNTAJE
			if((620>app.mouseX&&app.mouseX>350)&&(672>app.mouseY&&app.mouseY>602)) {
				win.hide();
				screenNum=5;
				}
				break;

		case 8:
			// DE LOSE A HOME
			if ((816 > app.mouseX && app.mouseX > 539) && (560 > app.mouseY && app.mouseY > 493)) {
				;
				restartGame();
				screenNum=4;
			}
			// DE LOSE A GAME SCREEN
			if ((457 > app.mouseX && app.mouseX > 181) && (560 > app.mouseY && app.mouseY > 493)) {
				restartGame();
				screenNum=6;


				// Esto es para que se de play la música
				ost.play();
				//screenNum = 6;
//				if(loadingBoolean == true) {
//					ost.play();
//					screenNum=6;
//				}

				break;

			}

		}

	}

	public void move(int i) {
		if(screenNum==6) {
		
	if(bx>=58) {screenNum=7;
	win.textFields();}
	if(prota.getPosY()>4) {
		screenNum=8;
		ost.stop();
		}
	if(bx>=58) {
		
		//Validar ganar
		screenNum=7;
		win.metodo();
		String name = win.getName();
		match.add(new Match(name,getDate(),scores2,timer,app));	
		//String name,String date,int score,int time, PApplet app
		win.textFields();
		}
	
	if(prota.getPosY()>4) {
		screenNum=8;coin.removeAll(coin);
		}
	
	
	
		switch (i) {
		case 0:
			if (matrix[prota.getPosY()+1][bx+1] == 1) {
			prota.move(i);
			prota.move(i);
			prota.move(i);
			move(1);
			}
			break;
		case 1:
			if (matrix[prota.getPosY()+1][bx] != 1) {
			prota.move(i);
			posY = posY + 1;
			}
			break;
		case 2:
			if(bx>1) {
			if (matrix[prota.getPosY()][bx] != 1) {
		bx--;
		//Izquierda
		posX = posX - 1;
			backX++;
			
			move(1);
			
			}
			}
			break;
		
		case 3:
		if (matrix[prota.getPosY()][bx+2] != 1) {
			bx++;
		//Derecha
			posX = posX + 1;
			backX--;
			if (matrix[prota.getPosY()+1][bx+1] != 1) {
			move(1);
			}
			}
			
			break;

		}
		System.out.println();
		System.out.println(bx);
		}}

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
	
	
	public void validarMoneda() {
		
		for (int i = 0; i < coin.size(); i++) {
			float distance = PApplet.dist(posX,prota.getPosY(),coin.get(i).getPosX(),coin.get(i).getPosY());
			if(distance <= 1) {
				coinSound.play();
				scores2 = scores2 + 100;
				coin.remove(i);
			}
		}	
	}
public void colicionRata(){
	//medir toque de las ratas
	for (int i = 0; i < rata.size(); i++) {
		
	float	d=app.dist(bx, prota.getPosY(), rata.get(i).getPosX(), rata.get(i).getPosY());
		if(d<1) {
			screenNum=8;
			ost.stop();
			}
	}
	
	//medir toque de los cuchillos
	for (int i = 0; i < cuchillo.size(); i++) {
		float	d1=app.dist(bx, prota.getPosY(), (cuchillo.get(i).getPosX()), cuchillo.get(i).getPosY());
		if(d1<1) {
			screenNum=8;
			ost.stop();	
		}
	}
	
	// medir toque del fuego
	for (int i = 0; i < fire.size(); i++) {
		float	d2=app.dist(bx, prota.getPosY(), fire.get(i).getPosX(), fire.get(i).getPosY());
		if(d2<1) {
			screenNum=8;
			ost.stop();	
		}
	}
	
}
public void restartGame() {
	
	
	
	backX= 0;
	for (int i = 0; i < rata.size(); i++) {
		
	}
	
    prota.setY(4);

	coin.add(new Cheese(backX, 4, 2,app));
	coin.add(new Cheese(backX, 8, 2,app));
	coin.add(new Cheese(backX, 11, 2,app));
	coin.add(new Cheese(backX, 17, 2,app));
	coin.add(new Cheese(backX, 21, 2,app));
	coin.add(new Cheese(backX, 24, 4,app));
	coin.add(new Cheese(backX, 27, 2,app));
	coin.add(new Cheese(backX, 32, 2,app));
	coin.add(new Cheese(backX, 34, 2,app));
	coin.add(new Cheese(backX, 37, 2,app));
	coin.add(new Cheese(backX, 40, 2,app));
	coin.add(new Cheese(backX, 44, 2,app));
	coin.add(new Cheese(backX, 47, 2,app));
	coin.add(new Cheese(backX, 49, 2,app));
	coin.add(new Cheese(backX, 55, 2,app));

	
		scores2=0;
	
	
	bx=1;
	sec=0;
	timer=0;
	cont=0;
	cont1=0;
	
}
	
	public LinkedList<Match> getList() {
		return match;

	}

	public void setMatch(LinkedList<Match> match) {
		this.match = match;

	}
}
