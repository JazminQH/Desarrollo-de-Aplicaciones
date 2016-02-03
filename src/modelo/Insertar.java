package modelo;
/**
 * importacion de librerias
 */
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import base.Conexion;
/**
 * 
 * @author Jazmin Quezada
 *
 */
public class Insertar implements Datos{
	/**
	 * Metodo que implementa de la interfaz de Datos que recibe 4 parametros de tipo String ademas que realiza la insercion de un contacto en la base de datos
	 */
	public void Datos(String numero, String nombre, String apellidos, String correo) {

		Connection conecta= (Connection) Conexion.conectar();
		try{
			Statement comando=(Statement) conecta.createStatement();
						
			comando.execute("insert into contacto values ('"+numero+"','"+nombre+"','"+apellidos+"','"+correo+"')");
			JOptionPane.showMessageDialog(null, "Datos insertados");
			comando.close();
			conecta.close();
		}catch (Exception ex){
			JOptionPane.showMessageDialog(null, "Error "+ex.getMessage());
		}
	
		
	}

}
