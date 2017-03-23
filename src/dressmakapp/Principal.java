package dressmakapp;
import java.awt.print.Printable;
import java.util.Scanner;

public class Principal {
	private static Scanner in;//entrada

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		Medidas Med = new Medidas();
		System.out.println("Introduzca LTD y luego AC ");
		float LTD= in.nextFloat();
		float AC= in.nextFloat();
		System.out.println("Linea vertical: " + Med.LVertical(LTD, AC)); 
		new Frame().setVisible(true);

	}

}
