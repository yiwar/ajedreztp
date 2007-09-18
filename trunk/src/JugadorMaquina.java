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

		int aux = 0;
		int valorActual = 0;
		// mejores movimientos que se van a calcular
		//ArrayList mejores=new ArrayList();
		ArrayList movimientos=this.tablero.generarMovimientos(this.color);
		ArrayList mejores = new ArrayList();

		Iterator it = movimientos.iterator();
		while(it.hasNext()) {
			Tablero tNuevo = new Tablero(this.tablero);
			Movimiento mov = (Movimiento)(it.next());
			System.out.println("JugadorMaquina.mover(): "+mov.toString());
			realizarJugada(tNuevo, mov);
			aux = buscar(tNuevo, 1);

			if (aux > valorActual) {
				valorActual = aux;
				mejores = new ArrayList();
				mejores.add(mov);
			}
			else if (aux == valorActual)
				mejores.add(mov);
		}

		// elegir una jugada aleatoriamente de las mejores seleccionadas		
		Movimiento mov = (Movimiento)(mejores.get((int) (Math.random() * mejores.size())));
		
		// sobre el tablero de la partida
		System.out.println("JugadorMaquina.mover(): movimiento elegido: "+mov.toString());
		realizarJugada((mov.getPieza()).getFila(), (mov.getPieza()).getColumna(), mov.getFilaFinal(), mov.getColumnaFinal());
	}

	// Dada una situacion de tablero retorna la puntuacion maxima de las posibles jugadas que pueden 
	// realizarse.
	//
	public int buscar (Tablero t, int profundidad) {

		int aux = 0;
		int valorActual = 0;

		// limite, devolvemos el valor del tablero
		if (profundidad == 0) {
			int temp = t.valorTablero(this.color);
		       	System.out.println("JugadorMaquina.buscar(): Puntaje: "+temp+"  PROF: "+profundidad);	
			return temp;
		}
		
		ArrayList movimientos = t.generarMovimientos(this.color);

		// Evalua cada movimiento posible
		Iterator it = movimientos.iterator();
		while (it.hasNext()) {
			Tablero tNuevo = new Tablero(t);
			Movimiento mov = (Movimiento)(it.next());
			System.out.println("JugadorMaquina.buscar(): "+mov.toString()+" PROF: "+profundidad);
            		realizarJugada(tNuevo, mov);
			aux = buscar(tNuevo, profundidad-1);
			if (aux > valorActual)
				valorActual = aux;
		}		
		System.out.println("JugadorMaquina.buscar(): Puntaje devuelto: "+valorActual+" PROF: "+profundidad);
		return valorActual;
	}
}

