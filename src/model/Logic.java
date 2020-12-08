package model;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	int[][] matrix;
	
	

	public Logic(PApplet app) {
		this.app = app;

		matrix = new int[][] {

				/*
				 0 = zonas vac�as
				  1 = piso
				   2 = zonas de da�o
				    3 = cuadros de muerte
				     4 = bloqueos
				    /** esto esta puesto cada 10 casillas para usarlo como gu�a para orgnizar el arreglo
				     
				     
				 */
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4}, 
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0/**/, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/,0, 1, 0, 0, 0, 0, 1, 1, 0, 0/**/,0, 0, 2, 0, 2, 0, 2, 0, 0, 0/**/,1, 0, 0, 0, 1, 0, 2, 0, 0, 0/**/,2, 0, 0, 0, 0, 0, 0, 0, 0, 0/**/, 0, 0, 0, 0, 0, 0, 0},
				{ 4, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0/**/, 1, 0, 0, 1, 1, 1, 1, 2, 2, 1/**/,1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/,1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/,1, 1, 1, 1, 1, 1, 1, 1, 1, 1/**/,1, 1, 1, 0, 0, 1, 0, 1, 1, 1/**/, 1, 1, 1, 1, 1, 1, 1},
				{ 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/, 4, 3, 3, 4, 4, 4, 4, 3, 3, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 4, 4, 4, 4, 4, 4, 4/**/,4, 4, 4, 3, 3, 3, 3, 4, 4, 4/**/, 4, 4, 4, 4, 4, 4, 4}, };
	}
	
	

	
}
