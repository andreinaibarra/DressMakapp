package dressmakapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;


public class Interfaz {

	private 
		PruebaConexion conexion;
		Cliente cliente;
		JFrame frame;
		JFrame Wdatos;
		JTabbedPane panel;
		JPanel subFrame;
		JButton consultar;
		JButton generar;
		JButton insertar;
		int c_cedula;
	/**
	 * Create the application.
	 */
	public Interfaz() {
		conexion = new PruebaConexion();
		cliente = new Cliente();
		Wdatos = new JFrame();
		panel = new JTabbedPane();
		consultar = new JButton("Consultar Cliente");
		generar= new JButton("Generar Patron");
		insertar= new JButton("Guardar Cliente");
		c_cedula = 0;
		initialize();
	}
    
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 500, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel.add("Insertar", inserta());
		panel.add("Consultar", consulta());

		frame.add(panel);
		
	}
	
	private JPanel consulta()
	{
		JPanel consulta = new JPanel();
		
		JLabel etiqueta = new JLabel("Cedula");
		
		JTextField cedula = new JTextField();
		cedula.setBounds(120,10,150,20);
		
		GroupLayout layout = new GroupLayout(consulta);
		
		consulta.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		generar.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) { try {
				onGenerarButtonActionPerformed(e);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}}
		  });
		
		GroupLayout.Group hp1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		GroupLayout.Group hp2 = layout.createParallelGroup(GroupLayout.Alignment.TRAILING);
		GroupLayout.Group vp1 = layout.createParallelGroup(GroupLayout.Alignment.LEADING);
		GroupLayout.Group vp2 = layout.createParallelGroup();
		GroupLayout.Group vp3 = layout.createParallelGroup(GroupLayout.Alignment.BASELINE);
		
		
		GroupLayout.SequentialGroup hs = layout.createSequentialGroup();
		GroupLayout.SequentialGroup vs = layout.createSequentialGroup();
		
		hp1.addComponent(etiqueta);
		vp1.addComponent(etiqueta);
		hp2.addComponent(cedula);
		vp1.addComponent(cedula);
		
	    hp1.addComponent(consultar);
		hp2.addComponent(generar);
		vp2.addComponent(consultar);
		vp2.addComponent(generar);
	
		
		hs.addGroup(hp1);
		hs.addGroup(hp2);
		vs.addGroup(vp1);
		vs.addGroup(vp2);
		vs.addGroup(vp3);
		
		layout.setHorizontalGroup(hs);
	    layout.setVerticalGroup(vs);

        consulta.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
		
		
		consultar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) { 
				c_cedula = Integer.parseInt(cedula.getText());
				try {
					  onConsultarButtonActionPerformed(e);
				} catch (SQLException e1) {
				System.out.println(e1);
			}}
		});
		
        
		return consulta;
	}
	
	
	private JPanel inserta()
	{
		JPanel inserta = new JPanel();
		
		GroupLayout layout = new GroupLayout(inserta);
		
		inserta.setLayout(layout);
		
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		
		insertar = new JButton("Guardar Cliente");
		
		JLabel medidas = new JLabel("Medidas");
		JLabel datos = new JLabel("Datos Personales");
		
		JLabel Ecedula = new JLabel("Cedula");
		JTextField cedula = new JTextField(10);
		JLabel Enombre = new JLabel("Nombre");
		JTextField nombre = new JTextField(20);
		JLabel Etelefono = new JLabel("Telefono");
		JTextField telefono = new JTextField(20);
		
		JLabel eLTD = new JLabel("Largo de Talle Delantero");
		JTextField LTD = new JTextField(10);
		
		JLabel eAH = new JLabel("Ancho de Hombro");
		JTextField AH = new JTextField(10);
		
		JLabel eAE = new JLabel("Ancho de Espalda");
		JTextField AE = new JTextField(10);
		
		JLabel eCB = new JLabel("Contorno de Busto");
		JTextField CB = new JTextField(10);
		
		JLabel eAB = new JLabel("Altura de Busto");
		JTextField AB = new JTextField(10);
		
		JLabel eCCin = new JLabel("Contorno de Cintura");
		JTextField CCin = new JTextField();
		
		JLabel eCCad = new JLabel("Contorno de Cadera");
		JTextField CCad = new JTextField();
		
		JLabel eAC = new JLabel("Altura de Cadera");
		JTextField AC = new JTextField();
		
		JLabel eDB = new JLabel("Distancia de Busto");
		JTextField DB = new JTextField();
		
		layout.setHorizontalGroup(
				   layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(datos)
				           .addComponent(Ecedula)
				           .addComponent(Enombre)
				           .addComponent(Etelefono)
				           .addComponent(medidas)
				           .addComponent(eLTD)
				           .addComponent(eAH)
				           .addComponent(eAE)
				           .addComponent(eCB)
				           .addComponent(eAB)
				           .addComponent(eCCin)
				           .addComponent(eCCad)
				           .addComponent(eAC)
				           .addComponent(eDB)
				           .addComponent(insertar))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(cedula)
					           .addComponent(nombre)
					           .addComponent(telefono)
					           .addComponent(LTD)
					           .addComponent(AH)
					           .addComponent(AE)
					           .addComponent(CB)
					           .addComponent(AB)
					           .addComponent(CCin)
					           .addComponent(CCad)
					           .addComponent(AC)
					           .addComponent(DB))
				);
				layout.setVerticalGroup(
				   layout.createSequentialGroup()
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(datos))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(Ecedula)
					           .addComponent(cedula))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(Enombre)
					           .addComponent(nombre))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(Etelefono)
					           .addComponent(telefono))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(medidas))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eLTD)
					           .addComponent(LTD))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eAH)
					           .addComponent(AH))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eAE)
					           .addComponent(AE))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eCB)
					           .addComponent(CB))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eAB)
					           .addComponent(AB))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eCCin)
					           .addComponent(CCin))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eCCad)
					           .addComponent(CCad))
				      .addGroup(layout.createParallelGroup()
					           .addComponent(eAC)
					           .addComponent(AC))
				      .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(eDB)
					           .addComponent(DB))
				      .addComponent(insertar)
				);
	
		inserta.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));

		insertar.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent e) { 
					cliente.cedula = Integer.parseUnsignedInt(cedula.getText().trim());
					System.out.println(cliente.cedula);
					cliente.nombre = nombre.getText();
					System.out.println(cliente.nombre);
					cliente.telefono = Long.parseLong(telefono.getText().trim());
					System.out.println(cliente.telefono);
					cliente.med.setLTD(Double.parseDouble(LTD.getText().trim()));
					System.out.println(cliente.med.getLTD());
					cliente.med.setAH(Double.parseDouble(AH.getText().trim()));
					System.out.print(cliente.med.getAH());
					cliente.med.setAE(Double.parseDouble(AE.getText().trim()));
					System.out.print(cliente.med.getAE());
					cliente.med.setCB(Double.parseDouble(CB.getText().trim()));
					System.out.print(cliente.med.getCB());
					cliente.med.setAB(Double.parseDouble(AB.getText().trim()));
					System.out.print(cliente.med.getAB());
					cliente.med.setCc(Double.parseDouble(CCin.getText().trim()));
					System.out.print(cliente.med.getCc());
					cliente.med.setCC(Double.parseDouble(CCad.getText().trim()));
					System.out.print(cliente.med.getCC());
					cliente.med.setAC(Double.parseDouble(AC.getText().trim()));
					System.out.print(cliente.med.getAC());
					cliente.med.setDB(Double.parseDouble(DB.getText().trim()));
					System.out.print(cliente.med.getDB());
				   try {   
						onInsertarButtonActionPerformed(e);
				   }catch (SQLException e1) {
				System.out.println(e1);
				}
			   }
		}); 
				
		return inserta;
	}
	
	private JPanel genera() throws SQLException
	{
		Panel genera = new Panel();
		
		Cliente cl = conexion.consultar_bd(c_cedula);
		
		genera.asignarCliente(cl);
		
		onConsultarButtonActionPerformed(null);
		
		//	a = (int)Math.round(escalaX * (aReal ) );
		// aReal = 1.0*a/escalaX;
		
		return genera;
	}

	protected void onInsertarButtonActionPerformed(ActionEvent e) throws SQLException {
		conexion.insertar(cliente.cedula, cliente.nombre, cliente.telefono, cliente.med.getLTD(), cliente.med.getAH(), cliente.med.getAE(), cliente.med.getCB(), cliente.med.getAB(), cliente.med.getCc(), cliente.med.getCC(), cliente.med.getAC(), cliente.med.getDB());
	}
	
	protected void onConsultarButtonActionPerformed(ActionEvent e) throws SQLException {
		
		Cliente cl = new Cliente();
		
		cl = conexion.consultar_bd(c_cedula);
		
		Wdatos.setSize(400,400);
		
		JPanel p = new JPanel();

		GroupLayout layout2 = new GroupLayout(p);
		
		p.setLayout(layout2);
		
		layout2.setAutoCreateGaps(true);
		layout2.setAutoCreateContainerGaps(true);
		
		JLabel medidas = new JLabel("Medidas");
		JLabel dat = new JLabel("Datos Personales");
		
		JLabel Ecedula = new JLabel("Cedula");
		JTextField cedula = new JTextField(10);
		cedula.setText(Integer.toString(cl.cedula));
		
		JLabel Enombre = new JLabel("Nombre");
		JTextField nombre = new JTextField(20);
		nombre.setText(cl.nombre);
		
		JLabel Etelefono = new JLabel("Telefono");
		JTextField telefono = new JTextField(20);
		telefono.setText(Long.toString(cl.telefono));
		
		JLabel eLTD = new JLabel("Largo de Talle Delantero");
		JTextField LTD = new JTextField(10);
		LTD.setText(Double.toString(cl.med.getLTD()));
		
		JLabel eAH = new JLabel("Ancho de Hombro");
		JTextField AH = new JTextField(10);
		AH.setText(Double.toString(cl.med.getAH()));
		
		JLabel eAE = new JLabel("Ancho de Espalda");
		JTextField AE = new JTextField(10);
		AE.setText(Double.toString(cl.med.getAE()));
		
		JLabel eCB = new JLabel("Contorno de Busto");
		JTextField CB = new JTextField(10);
		CB.setText(Double.toString(cl.med.getCB()));
		
		JLabel eAB = new JLabel("Altura de Busto");
		JTextField AB = new JTextField(10);
		AB.setText(Double.toString(cl.med.getAB()));
		
		JLabel eCCin = new JLabel("Contorno de Cintura");
		JTextField CCin = new JTextField();
		CCin.setText(Double.toString(cl.med.getCc()));
		
		JLabel eCCad = new JLabel("Contorno de Cadera");
		JTextField CCad = new JTextField();
		CCad.setText(Double.toString(cl.med.getCC()));
		
		JLabel eAC = new JLabel("Altura de Cadera");
		JTextField AC = new JTextField();
		AC.setText(Double.toString(cl.med.getAC()));
		
		JLabel eDB = new JLabel("Distancia de Busto");
		JTextField DB = new JTextField();
		DB.setText(Double.toString(cl.med.getDB()));
		
		layout2.setHorizontalGroup(
				   layout2.createSequentialGroup()
				      .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(dat)
				           .addComponent(Ecedula)
				           .addComponent(Enombre)
				           .addComponent(Etelefono)
				           .addComponent(medidas)
				           .addComponent(eLTD)
				           .addComponent(eAH)
				           .addComponent(eAE)
				           .addComponent(eCB)
				           .addComponent(eAB)
				           .addComponent(eCCin)
				           .addComponent(eCCad)
				           .addComponent(eAC)
				           .addComponent(eDB))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(cedula)
					           .addComponent(nombre)
					           .addComponent(telefono)
					           .addComponent(LTD)
					           .addComponent(AH)
					           .addComponent(AE)
					           .addComponent(CB)
					           .addComponent(AB)
					           .addComponent(CCin)
					           .addComponent(CCad)
					           .addComponent(AC)
					           .addComponent(DB))
				);
				layout2.setVerticalGroup(
				   layout2.createSequentialGroup()
				      .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.LEADING)
				           .addComponent(dat))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(Ecedula)
					           .addComponent(cedula))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(Enombre)
					           .addComponent(nombre))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(Etelefono)
					           .addComponent(telefono))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(medidas))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eLTD)
					           .addComponent(LTD))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eAH)
					           .addComponent(AH))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eAE)
					           .addComponent(AE))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eCB)
					           .addComponent(CB))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eAB)
					           .addComponent(AB))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eCCin)
					           .addComponent(CCin))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eCCad)
					           .addComponent(CCad))
				      .addGroup(layout2.createParallelGroup()
					           .addComponent(eAC)
					           .addComponent(AC))
				      .addGroup(layout2.createParallelGroup(GroupLayout.Alignment.BASELINE)
					           .addComponent(eDB)
					           .addComponent(DB))
				);
				
		Wdatos.setTitle("Cliente");
		Wdatos.setDefaultCloseOperation(1);
		Wdatos.setLocationRelativeTo(null);
		Wdatos.add(p);
		Wdatos.setVisible(true);
				
	}
	protected void onGenerarButtonActionPerformed(ActionEvent e) throws SQLException {
		if(panel.getTabCount() == 3)
			panel.remove(2);
		panel.add("Pantron Base", genera());
	}

}
