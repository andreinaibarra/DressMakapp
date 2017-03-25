package dressmakapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

public class PruebaConexion {

    public static void main(String[] args) {
        //Declaramos un objeto de la clase Conexion
        Conexion con = new Conexion();
        
        //Llamamos al metodo que nos crea la conexion 
        Connection conexion = con.getMYSQLConnection();
        //Comprobamos que la conexion no sea nula (es decir hay un error)
        if(conexion == null){
            System.out.println("Error con la conexion a la BD!!");
        }
        else{
            try {
                System.out.println("Conexion a la BD correcta!!");
                //Si la conexion es correta podemos usarla para hacer consultas sobre la BD
                
                //CONSULTAS AQUI
                
                //Al terminar de hacer las consultas siempre debemos de cerrar la conexion
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName(), null).log(Level.SEVERE, null, ex);
            }
        }     
    }

}
