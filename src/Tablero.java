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

public class Tablero {

	private JPanel tableroJP;
	private Pieza[][] tablero;
	private JPanel[][] casillasJP;

	// Constructor
	public Tablero () {
		
		tablero = new Pieza[8][8];
		casillasJP = new JPanel[8][8];
		System.out.println("Tablero.Tablero(): Me acaban de crear");
	}

	// version con GUI
	public Tablero (JFrame f) {

		this();
		Container c = f.getContentPane();
		tableroJP = new JPanel();
		c.add(tableroJP, "Center");
	}

	public void add (int x, int y, Pieza p) {
		
		tablero[x][y] = p;
	}

	public void mostrar () {
		
		System.out.println("Tablero.show():");
		for (int f=0; f<8; f++) {
			//System.out.print("F");
			for (int c=0; c<8; c++) {
				if (tablero[f][c] != null)
					System.out.print((tablero[f][c]).toString() + " "); //getClass().getName());
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}

	public void crearTableroGUI (JFrame f) {

        	tableroJP.setLayout(new GridLayout(10, 10));
        	filaLetras(tableroJP);
        	for (int i = 0; i < 8; i++) {
            		tableroJP.add(new BLabel((new Integer(i+1)).toString()));
            		for (int j = 0; j < 8; j++) {
				JPanel jp = new JPanel();
				if (((i + j) % 2) == 0) jp.setBackground(Color.white);
       				else jp.setBackground(Color.gray);
				jp.setPreferredSize(new Dimension(42, 42));
                		JLabel jl = new JLabel();
        			jl.setPreferredSize(new Dimension(32, 32));
        			jp.add(jl);
				casillasJP[i][j] = jp;

                		//int color = b.getColor(i, j);
                		//if (color != Board.EMPTY) {
                    		//	int piece = b.getPiece(i, j);
                    		//	square[i][j].setIcon(new ImageIcon(pieceImage[color][piece]));
                		//}
                		tableroJP.add(casillasJP[i][j]);
            		}
            		tableroJP.add(new BLabel((new Integer(i+1)).toString()));
        	}
        	filaLetras(tableroJP);
	}

	
	// Añade una fila de letras al tablero
	private void filaLetras(JPanel p) {
        	p.add(new JPanel());
        	for (int i = 0; i < 8; i++)
            		p.add(new BLabel((new Character((char) ('a' + i))).toString()));
        	p.add(new JPanel());
    	}

    	class BLabel extends JLabel {
        	BLabel(String s) {
            		super(s);
            		setHorizontalAlignment(CENTER);
            		setVerticalAlignment(CENTER);
		}
        }
}

