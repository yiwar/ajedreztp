/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;
import java.util.*;
import javax.swing.event.*;
import javax.swing.*;

public class JugadorHumano extends Jugador {

	// Constructor
	public JugadorHumano (int color, Tablero t) {
		
		super(color, t);
		System.out.println("JugadorHumano.JugadorHumano(): Me acaban de crear");
	}

	public void mover () {
		
		int fI, cI, fF, cF;
		String movimiento = JOptionPane.showInputDialog("Movimiento:\nEj: A2 A4");

		while (movimiento == null || movimiento.equals("")) {
			JOptionPane.showMessageDialog( null, "Introduce un movimiento" );
			movimiento = JOptionPane.showInputDialog("Movimiento:\nEj: A2 A4");
		}

		// validar formato del movimiento introducido
		movimiento = movimiento.toUpperCase();
		if (movimiento.length() != 5) {
			JOptionPane.showMessageDialog( null, "Formato de direccion invalido" );
		}
		if ((movimiento.charAt(0) < 'A' || movimiento.charAt(0) > 'H') || (!Character.isDigit(movimiento.charAt(1)))) {
			JOptionPane.showMessageDialog( null, "Formato de la direccion de inicio invalido" );
		}
		if (movimiento.charAt(2) != ' ') {
			JOptionPane.showMessageDialog( null, "Formato de direccion invalido" );
		}
		if ((movimiento.charAt(3) < 'A' || movimiento.charAt(3) > 'H') || (!Character.isDigit(movimiento.charAt(4)))) {
			JOptionPane.showMessageDialog( null, "Formato de la direccion de fin invalido" );
		}

		fI = Integer.parseInt(movimiento.charAt(1)+"") - 1;
	   	cI = movimiento.charAt(0) - 'A';//Integer.parseInt(movimiento.charAt(0)+"");
		fF = Integer.parseInt(movimiento.charAt(4)+"") - 1;
	   	cF = movimiento.charAt(3) - 'A';//Integer.parseInt(movimiento.charAt(3)+"");

		if (jugadaValida(fI, cI, fF, cF)) {
	
			realizarJugada(fI, cI, fF, cF);
		}
	}

	// TODO: codigo de verificacion de las jugadas
	public boolean jugadaValida (int fI, int cI, int fF, int cF) {

		return true;
	}
}

