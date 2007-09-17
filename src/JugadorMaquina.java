/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;

public class JugadorMaquina extends Jugador {

	// Constructor
	public JugadorMaquina (String nombre, int color, Tablero t) {
		
		super(nombre, color, t);
		System.out.println("JugadorMaquina.JugadorMaquina(): Me acaban de crear");
	}

	public void mover () {

		// mejores movimientos que se van a calcular
		ArrayList mejores=new ArrayList();
		ArrayList movimientos=this.tablero.generarMovimientos();
		
	}
}

