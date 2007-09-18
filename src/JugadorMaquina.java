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
		// al inicio de la jugada tenemos un valor de tablero que intentaremos superar
		int valorActual = this.tablero.valorTablero(this.color);
		// mejores movimientos que se van a calcular
		//ArrayList mejores=new ArrayList();
		ArrayList movimientos = this.tablero.generarMovimientos(this.color);
		ArrayList mejores = new ArrayList();

		Iterator it = movimientos.iterator();
		while(it.hasNext()) {
			Tablero tNuevo = new Tablero(this.tablero);
			Movimiento mov = (Movimiento)(it.next());
			System.out.println("JugadorMaquina.mover(): "+mov.toString()+"; valor del nodo: "+tNuevo.valorTablero(this.color));
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

		// si el jugador no tiene posibilidad de moverse
		// se decreta la partida en tablas
		if (mejores.size() == 0)
			this.tablero.setTablas();
		else {
			// entre las mejores jugadas seleccionadas, prioriza aquellas que implican comer otra ficha
			ArrayList optimizacion = new ArrayList();
			it = mejores.iterator();
			Movimiento mov;
			while(it.hasNext()) {
				mov = (Movimiento)(it.next());
				// la jugada implica comer a otra ficha
				if (this.tablero.get(mov.getFilaFinal(), mov.getColumnaFinal()) != null)
					optimizacion.add(mov);
			}
			
			System.out.println("JugadorMaquina.mover(): hay "+optimizacion.size()+" jugadas optimizadas de "+mejores.size()+" posibles.");

			// hay jugadas que comen otras fichas
			if (optimizacion.size() != 0)
				mov = (Movimiento)(optimizacion.get((int) (Math.random() * optimizacion.size())));
			else
				mov = (Movimiento)(mejores.get((int) (Math.random() * mejores.size())));

			// sobre el tablero de la partida
			System.out.println("JugadorMaquina.mover(): movimiento elegido: "+mov.toString());
			realizarJugada((mov.getPieza()).getFila(), (mov.getPieza()).getColumna(), mov.getFilaFinal(), mov.getColumnaFinal());
		}
	}

	// Dada una situacion de tablero retorna la puntuacion maxima de las posibles jugadas que pueden 
	// realizarse.
	//
	public int buscar (Tablero t, int profundidad) {
	
		// valorActual es el maximo valor hallado a partir del nodo
		int valorActual = t.valorTablero(this.color);;
		// evaluador de los subarboles del nodo
		int valor = 0;

		// limite, devolvemos el valor del tablero
		if (profundidad == 0) {
			//int temp = t.valorTablero(this.color);
		       	System.out.println("JugadorMaquina.buscar(): Puntaje: "+valorActual+"  PROF: "+profundidad);	
			return valorActual;
		}
		
		ArrayList movimientos = t.generarMovimientos(this.color);

		// Evalua cada movimiento posible
		Iterator it = movimientos.iterator();
		while (it.hasNext()) {
			Tablero tNuevo = new Tablero(t);
			Movimiento mov = (Movimiento)(it.next());
			//System.out.println("JugadorMaquina.buscar(): "+mov.toString()+" PROF: "+profundidad);
            		realizarJugada(tNuevo, mov);
			valor = buscar(tNuevo, profundidad-1);
			if (valor > valorActual)
				valorActual = valor;
		}		
		System.out.println("JugadorMaquina.buscar(): Puntaje devuelto: "+valorActual+" PROF: "+profundidad);
		return valorActual;
	}
}

