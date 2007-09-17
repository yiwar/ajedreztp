/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.util.*;
import java.io.*;

public class JugadorMaquina extends Jugador {

	// Constructor
	public JugadorMaquina (String nombre, int color, Tablero t) {
		
		super(nombre, color, t);
		System.out.println("JugadorMaquina.JugadorMaquina(): Me acaban de crear");
	}

	public void mover () {

		int max;
		// mejores movimientos que se van a calcular
		//ArrayList mejores=new ArrayList();
		ArrayList movimientos=this.tablero.generarMovimientos(this.color);

		Iterator it=movimientos.iterator();
		while(it.hasNext()) {
			Tablero tNuevo = new Tablero(this.tablero);
			Movimiento mov = (Movimiento)(it.next());
			max = buscar(tNuevo, 1);
		}		
		
	}

	public int buscar (Tablero t, int profundidad) {

		// limite, devolvemos el valor del tablero
		if (profundidad == 0)
			return t.valorTablero(this.color);
		return 0;
	}
}

