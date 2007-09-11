/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;
import java.util.*;

public abstract class Jugador {
	
	ArrayList piezas;

	// constructor
	public Jugador () {
		piezas = new ArrayList();
		
		// crear peones
		for (int i=0; i<8; i++)
			piezas.add(new Peon());
		// crear torres
		for (int i=0; i<2; i++)
			piezas.add(new Torre());
		// crear caballos
		for (int i=0; i<2; i++)
			piezas.add(new Caballo());
		// crear alfiles
		for (int i=0; i<2; i++)
			piezas.add(new Alfil());
		// crear reina
		piezas.add(new Reina());
		// crear rey
		piezas.add(new Rey());

		System.out.println("Jugador.Jugador(): Me acaban de crear");
	}
}	

