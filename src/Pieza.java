/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import javax.swing.*;
import java.io.*;

public abstract class Pieza implements Constantes {

	// color de la pieza
	int color;
	// posicion de la pieza en el tablero de juego	
	int x, y;
	ImageIcon icono;

	// constructor
	// string contiene la ruta parcial al icono que se completa en funcion de su color
	//
	public Pieza (int color, int x, int y, String ruta) {

		this.color = color;
		this.x = x;
		this.y = y;
		if (color == BLANCO)
			icono = new ImageIcon(ruta+"b.gif");
		else
			icono = new ImageIcon(ruta+"n.gif");

		//System.out.println("Pieza.Pieza(): Me acaban de crear");
	}

	public ImageIcon getImagen () {
		
		return icono;	
	}	

	public abstract String toString ();

	//public abstract boolean movimientoValido ();
}	
