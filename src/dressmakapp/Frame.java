package dressmakapp;
import javax.swing.JFrame;

public class Frame  extends JFrame{

	/**
	 * Básicamente esta variable sirve para decirle a nuestro proyecto en que versión 
	 * se encuentra en estos momentos y esto se debe a que todo objeto que sea susceptible
	 *  a implementar un "Serializable" y se ejecute desde un entorno como Swing o Applet
	 *   puede sufrir modificaciones. Pongamos que hemos creado un Applet que nos ayuda a
	 *    cargar y visualizar un fichero, el programa serializara una serie de objetos al
	 *     cerrarse y los lee en la siguiente ejecución para mantener los valores que tenia 
	 *     antes. Cuando evoluciones tu programa si no modificas el serialVersionUID e 
	 *     intentas leer los objetos que fueron serializados te los devolverá como erróneos
	 * , eso pasa por que los objetos locales no saben que el programa a sido modificado.
	 */
	private static final long serialVersionUID = 1L;
		Panel panel;
		public Frame (){
			panel= new Panel();
			add(panel);
			setSize(600,600);
			setDefaultCloseOperation(3);
			setLocationRelativeTo(null);
		}
		
}

