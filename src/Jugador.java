/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;
import java.util.*;

public abstract class Jugador implements Constantes {
	
	// color con el que juega el jugador
	int color;
	// piezas del jugador
	ArrayList piezas;

	// constructor
	public Jugador (int color) {
		piezas = new ArrayList();
		
		// crear peones
		for (int i=0; i<8; i++)
			piezas.add(new Peon(color, 0, 0));
		// crear torres
		for (int i=0; i<2; i++)
			piezas.add(new Torre(color, 0, 0));
		// crear caballos
		for (int i=0; i<2; i++)
			piezas.add(new Caballo(color, 0, 0));
		// crear alfiles
		for (int i=0; i<2; i++)
			piezas.add(new Alfil(color, 0, 0));
		// crear reina
		piezas.add(new Reina(color, 0, 0));
		// crear rey
		piezas.add(new Rey(color, 0, 0));

		//System.out.println("Jugador.Jugador(): Me acaban de crear");
	}
}	

