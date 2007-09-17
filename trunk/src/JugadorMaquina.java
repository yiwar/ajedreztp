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
		//System.out.println("JugadorMaquina.JugadorMaquina(): Me acaban de crear");
	}

	public void mover () {

		int max = 0;
		int valorActual = 0;
		// mejores movimientos que se van a calcular
		//ArrayList mejores=new ArrayList();
		ArrayList movimientos=this.tablero.generarMovimientos(this.color);
		ArrayList mejores = new ArrayList();

		Iterator it = movimientos.iterator();
		while(it.hasNext()) {
			Tablero tNuevo = new Tablero(this.tablero);
			Movimiento mov = (Movimiento)(it.next());
			realizarJugada(tNuevo, mov);
			max = buscar(tNuevo, 1);

			if (max > valorActual) {
				valorActual = max;
				mejores = new ArrayList();
				mejores.add(mov);
			}
			else if (max == valorActual)
				mejores.add(mov);
		}

		// elegir una jugada aleatoriamente de las mejores seleccionadas		
		Movimiento mov = (Movimiento)(mejores.get((int) (Math.random() * mejores.size())));
		
		// sobre el tablero de la partida
		realizarJugada((mov.getPieza()).getFila(), (mov.getPieza()).getColumna(), mov.getFilaFinal(), mov.getColumnaFinal());
	}

	// Dada una situacion de tablero retorna la puntuacion maxima de las posibles jugadas que pueden 
	// realizarse.
	//
	public int buscar (Tablero t, int profundidad) {

		int aux = 0;
		int valorActual = 0;

		// limite, devolvemos el valor del tablero
		if (profundidad == 0)
			return t.valorTablero(this.color);
		
		ArrayList movimientos = t.generarMovimientos(this.color);

		// Evalua cada movimiento posible
		Iterator it = movimientos.iterator();
		while (it.hasNext()) {
			Tablero tNuevo = new Tablero(t);
			Movimiento mov = (Movimiento)(it.next());
            		realizarJugada(tNuevo, mov);
			aux = buscar(tNuevo, profundidad-1);
			if (aux > valorActual)
				valorActual = aux;
		}		

		return valorActual;
	}
}

