/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;
import java.util.*;

public abstract class Jugador implements Constantes {
	
	// nombre del jugador
	String nombre;
	// color con el que juega el jugador
	int color;
	// piezas del jugador
	ArrayList piezas;
	// tablero de juego
	Tablero tablero;

	// constructor
	public Jugador (String nombre, int color, Tablero t) {

		this.nombre = nombre;
		this.color = color;
		piezas = new ArrayList();
		tablero = t;		

		int posicion;
		if (color == BLANCO)
			posicion = 1;
		else
			posicion = 0;

		// Crear las piezas y ponerlas en el tablero
		Pieza p;
		// crear peones
		for (int i=0; i<8; i++) {
			p = new Peon(color, 5*posicion+1, i);
			piezas.add(p);
			tablero.add(5*posicion+1, i, p);
		}
		// crear torres
		for (int i=0; i<2; i++) {
			p = new Torre(color, 7*posicion, 7*i);
			piezas.add(p);
			tablero.add(7*posicion, 7*i, p);			
		}
		// crear caballos
		for (int i=0; i<2; i++) {
			p = new Caballo(color, 7*posicion, 5*i+1);
			piezas.add(p);
			tablero.add(7*posicion, 5*i+1, p);
		}
		// crear alfiles
		for (int i=0; i<2; i++) {
			p = new Alfil(color, 7*posicion, 3*i+2);
			piezas.add(p);
			tablero.add(7*posicion, 3*i+2, p);
		}
		// crear reina
		p = new Reina(color, 7*posicion, 4);
		piezas.add(p);
		tablero.add(7*posicion, 4, p);
		// crear rey
		p = new Rey(color, 7*posicion, 3);
		piezas.add(p);
		tablero.add(7*posicion, 3, p);

		//System.out.println("Jugador.Jugador(): Me acaban de crear");
	}

	public abstract void mover ();

	public void realizarJugada (int fI, int cI, int fF, int cF) {
		
		Pieza pAMover, pAComer;
		boolean bResultado;
		
		//pieza a mover
		pAMover = tablero.get( fI, cI );
		System.out.println("Jugador.realizarJugada(): mover de <"+fI+","+cI+"> a <"+fF+","+cF+">");
		System.out.println("Jugador.realizarJugada(): la pieza a mover es " + pAMover.toString());
		
		//ficha a comer (si hay)
		pAComer = tablero.get( fF, cF );

		if ( pAComer != null ) //hay que comersela
		{
			//fAComer.dejarseComer();
			//fichasComidas.addElement( fAComer );
		}
		
		if ( pAMover != null ) 
		{
			tablero.add(fF, cF, pAMover);
			tablero.add(fI, cI, null);
			// nueva posicion de la pieza
			pAMover.setPosicion(fF, cF);

			//bResultado = tab.ubicarFicha( fAMover, iFilFin, iColFin );
			//return bResultado;
		}
		//return false; //algo anduvo mal!!
		tablero.mostrarGUI();
		tablero.mostrar();
	}

	public String getNombre () {
		
		return nombre;
	}
}	

