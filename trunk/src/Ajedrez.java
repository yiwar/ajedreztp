/*
 *$LastChangedDate$
 *$LastChangedRevision$
 * Ligia Tatiana Gonzalez Leyva <calvinahobbes@gmail.com>
 */

import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class Ajedrez extends JFrame implements Constantes{

	Tablero t;
	Jugador jH;
	Jugador jM;

	public Ajedrez () {
		
        	this.setSize(500,500);
        	this.setTitle("Ajedrez 1.0");
		//this.setVisible(true);
		this.addWindowListener( new WindowAdapter() 
			{
				public void windowClosing(WindowEvent e)
				{
					dispose();
					System.exit(0);
				}
			}
		);

		// crear tablero y jugadores
		t = new Tablero(this);
		jH = new JugadorHumano(BLANCO, t);
		jM = new JugadorMaquina(NEGRO, t);

		Container cp = getContentPane();
        	cp.setLayout(new FlowLayout());

		t.crearTableroGUI(this);

		t.mostrar();
		show();
	}
	
	public static void main(String[] args) {
	
		System.out.println("Ajedrez.main(): He empezado");

		System.out.println("Ajedrez.main(): Arrancando GUI");
		new Ajedrez();
	}
}
