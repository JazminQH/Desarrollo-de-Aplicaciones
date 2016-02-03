package modelo;
/**
 * imnportacion de librerias
 */
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Conexion;
import vista.VentanaContacto;
/**
 * 
 * @author Jazmin Quezada
 *
 */
public class Eliminar implements Datos {
	
	@Override
	/**
	 * metodo que implemente de la interfaz datos que recibe 4 parametros de tipo String que realiza la baja de un contacto
	 */
	public void Datos(String numero, String nombre, String apellidos, String correo) {
		try {
			Connection conecta= (Connection) Conexion.conectar();
			Statement comando=(Statement) conecta.createStatement();
	          int cantidad = comando.executeUpdate("delete from contacto where numero="+numero);
	          if (cantidad==1) {
	        	JOptionPane.showMessageDialog(null, "Contacto Eliminado");
	        	
	        	
	          } else {
	        	JOptionPane.showMessageDialog(null, "Contacto no encontrado");
	          }
	          conecta.close();
	     } catch(SQLException ex){
	    	 JOptionPane.showMessageDialog(null, ex);
	     }        
	}

}
