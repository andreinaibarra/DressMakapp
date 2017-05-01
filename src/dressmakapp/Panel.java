package dressmakapp;

import java.awt.Graphics;
import javax.swing.JPanel;


public class Panel extends JPanel {
	
	private static final long serialVersionUID = 2L;
	
	private Cliente Cl = new Cliente();
	
	public Cliente verCliente()
	{
		return Cl;
	}
	
	public void asignarCliente(Cliente cliente){
		Cl = cliente;
	}

	public void paint(Graphics g) {

		Cliente cliente = verCliente();
		System.out.println("Introduzca LTD y luego AC ");
		double  LTD = cliente.med.getLTD();
		double AC = cliente.med.getAC();
		System.out.println("Linea vertical: " + cliente.med.LVertical(LTD, AC));
		System.out.println("Introduzca CC ");
		double CC = cliente.med.getCC();
		System.out.println("Introduzca Cc ");
		System.out.println("Introduzca CB ");
		System.out.println("Linea horizontal: " + cliente.med.LHorizontal(CC));
		g.drawRect(0, 0, (int) cliente.med.LHorizontal(CC), (int) cliente.med.LVertical(LTD, AC));
		//Med.getMedidas();
		g.drawLine(0,(int) cliente.med.PosLcintura(), (int) cliente.med.LHorizontal(CC), (int) cliente.med.PosLcintura());
		//System.out.println("Linea citura: " + Med.PosLcintura());
		// g.drawRect(45, 20, 300, 100);
		g.drawLine(0,(int) cliente.med.PosLbusto(), (int) cliente.med.LHorizontal(CC), (int) cliente.med.PosLbusto());
		g.drawLine(0,(int) cliente.med.PosLespalda(), (int) cliente.med.LHorizontal(CC), (int) cliente.med.PosLespalda());
		g.drawRect(0, 0, (int) cliente.med.getEHE(), (int) cliente.med.getEVE());
		g.drawRect((int)( cliente.med.LHorizontal(CC)-cliente.med.getEHD()), 0, (int) cliente.med.getEHD(),(int) cliente.med.getEVD());
		g.drawLine((int)((cliente.med.getPxCc()/4)+cliente.med.Escala1(cliente.med.ConvertirCmToPx(3))),(int) cliente.med.PosLcintura(), (int)cliente.med.getCB()/4, (int) cliente.med.PosLbusto());
		g.drawLine((int)((cliente.med.LHorizontal(CC)-((cliente.med.getPxCc()/4)+cliente.med.Escala1(cliente.med.ConvertirCmToPx(3))))),(int) cliente.med.PosLcintura(), (int)(cliente.med.LHorizontal(CC)-((cliente.med.getPxCB()/4)+cliente.med.Escala1(cliente.med.ConvertirCmToPx(1)))), (int)cliente.med.PosLbusto());
		double[] line2cm= cliente.med.PosLine2cm((float)(cliente.med.getPxCB()/4),(float) ((cliente.med.getPxCc()/4)+cliente.med.Escala1(cliente.med.ConvertirCmToPx(3))), cliente.med.PosLbusto(), cliente.med.PosLcintura());
		
		g.drawLine((int)cliente.med.getPxCB()/4, (int) cliente.med.PosLbusto(),(int) ((cliente.med.getPxCB()/4)+(line2cm[0])) ,(int) ((cliente.med.PosLbusto())-(line2cm[1])));
		
		//g.drawArc(HEIGHT, WIDTH, FRAMEBITS, ERROR, ALLBITS, ABORT);
	}
}
