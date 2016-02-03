/**
 * Paquete al que pertenece a esta clase
 */
package base;
/**
 * importacion de librerias
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jazmin Quezada Herrera
 *
 */
public class Conexion {
	
	/**
	 * Metodo que conecta a la base de datos
	 */
	public static Connection conectar(){
		Connection conexion=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/agenda";
            String usu="root";
            String pass="";
            conexion= DriverManager.getConnection(url,usu,pass);
			
		 }
        catch(ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error1 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error2 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex, "Error3 en la Conexión con la BD "+ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            conexion=null;
        }
        finally
        {
            return conexion;
        }
	
	}
}
