package dressmakapp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import com.mysql.jdbc.Statement;
import com.sun.istack.internal.logging.Logger;

public class PruebaConexion {
	
	private Statement stm;
	private ResultSet rs, rs2;
	private Conexion con;
	private Connection conexion;
	
	public void cerrar(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

    public void conectar() {
        con = new Conexion();
        conexion = con.getMYSQLConnection();
        if(conexion == null){
            System.out.println("Error con la conexion a la BD!!");
        }
      else{
            try {
                System.out.println("Conexion a la BD correcta!!");
                stm = (Statement) conexion.createStatement();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName(), null).log(Level.SEVERE, null, ex);
            }
      }     
    }
    
    
	public Cliente consultar_bd(int cedula) throws SQLException {
		conectar();
    	Medidas medidas = new Medidas();
    	Cliente client = new Cliente();
    	try{
        	rs2 = stm.executeQuery("SELECT * FROM medida WHERE cliente_cedula = '" + cedula + "'");
        	rs2.next();
        	medidas.setLTD(rs2.getDouble(2));
        	medidas.setAH(rs2.getDouble(3));
        	medidas.setAE(rs2.getDouble(4));
        	medidas.setCB(rs2.getDouble(5));
        	medidas.setAB(rs2.getDouble(6));
        	medidas.setCc(rs2.getDouble(7));
        	medidas.setCC(rs2.getDouble(8));
        	medidas.setAC(rs2.getDouble(9));
        	medidas.setDB(rs2.getDouble(10));
    		rs = stm.executeQuery("SELECT * FROM cliente WHERE cedula = '" + cedula + "'");
    		rs.next();
    		client.asignar(medidas,rs.getInt(1),rs.getString(2),rs.getLong(3));
    	}catch(SQLException ex){System.out.println(ex);}
    	cerrar();
    	return client;
    }
    
    public void insertar(int n_cedula, String n_nombre, long n_telefono, double n_ltd, double n_ah, double n_ae, double n_cb, double n_ab, double n_ccin, double n_ccad, double n_ac, double n_db)	{
    	conectar();
    	try {
    		stm.execute("INSERT INTO cliente (cedula, nombre, telefono) VALUES ('"+ n_cedula + "','" + n_nombre + "','" + n_telefono + "')");
    		stm.execute("INSERT INTO medida (cliente_cedula,ltd,ah,ae,cb,ab,ccin,ccad,ac,db) VALUES ('"+ n_cedula + "','" + n_ltd + "','" + n_ah + "','" + n_ae + "','" + n_cb + "','" + n_ab + "','" + n_ccin + "','" + n_ccad + "','" + n_ac + "','" + n_db + "')");
    	} catch (SQLException ex) {
    		System.out.println(ex);
    	}
    	cerrar();
    }

    public void eliminar(int cedula)	{
    	try {
    		stm.execute("DELETE FROM cliente" + " WHERE cedula='" + cedula + "'");
    	} catch (SQLException ex) {
    	System.out.println(ex);
    	}
    }
    
}
