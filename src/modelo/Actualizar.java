/**
 * Paquete al que pertenece la clase actualizar
 */
package modelo;
/**
 * importacion de librerias
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import base.Conexion;
/**
 * 
 * @author Jazmin Quezada
 *
 */
public class Actualizar implements Datos {
@Override
/**
 * Metodo que recibe 4 parametros tipo String que actualiza los registros de la tabla contacto
 */
	public void Datos(String numero, String nombre, String apellidos, String correo) {
		try {
			Connection conecta= (Connection) Conexion.conectar();
			java.sql.Statement sql=conecta.createStatement();
	          int i = sql.executeUpdate("update contacto set nombre='" + nombre + "'," + "apellidos='" + apellidos + "'," +"correo='" + correo + "' where numero="+numero);
	          if (i==1) {
	        	  JOptionPane.showMessageDialog(null, "se actualizaron los datos");
	          } else {
	        	  JOptionPane.showMessageDialog(null, "upss! algo salio mal");
	          }
	          conecta.close();
	          
		} catch(SQLException ex){
	          System.out.println(ex);
		}                
	}

	

}
