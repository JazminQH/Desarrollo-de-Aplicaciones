package vista;
/**
 * importacion de librerias
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import base.Conexion;
import modelo.Actualizar;
import modelo.Eliminar;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author Jazmin Quezada
 *
 */
public class VentanaContacto extends JFrame implements ActionListener {
	/**
	 * Declaracion de variables (elementos de la ventana de contacto
	 */
	
	private JLabel lblTitulo=new JLabel("Contacto");
	
	private JLabel lblTelefono=new JLabel("Numero: ");
	public JTextField txtTelefono= new JTextField("");
	
	private JLabel lblNombre=new JLabel("Nombre: ");
	public JTextField txtNombre=new JTextField("");
	
	private JLabel lblApellidos=new JLabel("Apellidos: ");
	public JTextField txtApellidos=new JTextField("");
	
	private JLabel lblCorreo=new JLabel("Correo: ");
	public JTextField txtCorreo=new JTextField("");
	
	private JButton btnModificar=new JButton("Modificar");
	private JButton btnBuscar=new JButton("Buscar");
	private JButton btnGuardar=new JButton("Guardar");
	private JButton btnCancelar=new JButton("Cancelar");
	private JButton btnCambiar=new JButton("Cambiar");
	private JButton btnMenu=new JButton("Regresar");
	private JButton btnEliminar =new JButton("Eliminar");
	

	
	public Container c=getContentPane();
	Actualizar vtnA=new Actualizar();
	Eliminar vtnE=new Eliminar();
	public JFrame vtn;
	
	/**
	 * Caracteristica de la dimension de la ventana de contacto
	 */
	public VentanaContacto(){
		
		super.setTitle("Buscar Contacto");
		super.setSize(300,300);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
	/**
	 * Carga los controles a la ventana ademas de determinar la dimension y posicion en el contenedor
	 */
	public void cargarControles() {
		// TODO Auto-generated method stub
		c.setLayout(null);
		lblTitulo.setBounds(81, 11, 121, 25);
		lblTelefono.setBounds(10,33,72,25);
		txtTelefono.setEditable(false);
		txtTelefono.setBounds(81,35,102,20);
				
		lblNombre.setBounds(10,69,72,25);
		txtNombre.setEditable(false);
		txtNombre.setBounds(81,69,102,20);
		
		lblApellidos.setBounds(10,105,72,25);
		txtApellidos.setEditable(false);
		txtApellidos.setBounds(81,105,102,20);
		
		lblCorreo.setBounds(10,141,72,25);
		txtCorreo.setEditable(false);
		txtCorreo.setBounds(81,143,102,20);
		
		btnModificar.setBounds(10,192,121,20);
		btnBuscar.setBounds(10,192,121,20);
		btnBuscar.setVisible(false);
		btnGuardar.setBounds(10,192,121,20);
		btnGuardar.setVisible(false);
		btnCancelar.setBounds(153,192,121,20);
		btnEliminar.setBounds(153,192,121,20);
		btnCancelar.setVisible(false);
		btnCambiar.setBounds(193,35,81,20);
		btnMenu.setBounds(153,223,121,20);
		
		
		c.add(lblTitulo);
		c.add(lblTelefono);
		c.add(txtTelefono);
		c.add(lblNombre);
		c.add(txtNombre);
		c.add(lblApellidos);
		c.add(txtApellidos);
		c.add(lblCorreo);
		c.add(txtCorreo);
		c.add(btnModificar);
		c.add(btnBuscar);
		c.add(btnGuardar);
		c.add(btnCancelar);
		c.add(btnEliminar);
		c.add(btnCambiar);
		c.add(btnMenu);
		/**
		 * Acccion del boton de modificar
		 */
		btnModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtNombre.setEditable(true);
				txtApellidos.setEditable(true);
				txtCorreo.setEditable(true);
				btnModificar.setVisible(false);
				btnGuardar.setVisible(true);
				btnCambiar.setVisible(false);
				btnEliminar.setVisible(false);
				//btnCancelar.setVisible(true);
				
			}

			

		});
		/**
		 * Accion del boton Cambiar
		 */
		btnCambiar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtTelefono.setEditable(true);
				txtNombre.setEditable(false);
				txtApellidos.setEditable(false);
				txtCorreo.setEditable(false);
				btnBuscar.setVisible(true);
				btnModificar.setVisible(false);
				limpiarCajas();
				
			}

			

		});
		/**
		 * Accion del boton guardar
		 */
		btnGuardar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				vtnA.Datos(txtTelefono.getText(), txtNombre.getText(), txtApellidos.getText(), txtCorreo.getText());
				txtNombre.setEditable(false);
				txtApellidos.setEditable(false);
				txtCorreo.setEditable(false);
				btnGuardar.setVisible(false);
				btnModificar.setVisible(true);
				btnCambiar.setVisible(true);
				//btnCancelar.setVisible(false);
			}

			

		});
		/**
		 * Accion del boton buscar
		 */
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				recibe(txtTelefono.getText());
				txtTelefono.setEditable(false);
				btnBuscar.setVisible(false);
				btnModificar.setVisible(true);
				btnEliminar.setVisible(true);
			}

			

		});
		/**
		 * boton que manda a llamar un metodo de la misma clase 
		 */
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				menu();
				
			}

			

		});
		/**
		 * Accion del boton de eliminar
		 */
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				eliminar();
				
			}

			

		});
		
		/*btnCancelar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				recibe(txtTelefono.getText());
				
			}

			

		});*/
	}
	/**
	 * crea un objeto de la clase de menu para activar la visibilidad de esta clase y activar la de la principal
	 */
	public void menu(){
		vtn=new VentanaP();
		vtn.setVisible(true);
		this.setVisible(false);
	}

/**
 * 
 * @param numero recibe el parametro del numero del contacto para poder realizar la consulta
 */
	public void recibe(String numero){
		try{
			
			Connection conecta= (Connection) Conexion.conectar();
			java.sql.Statement sql=conecta.createStatement();
			ResultSet registro=sql.executeQuery("Select * from contacto where numero='"+numero+"'");
			if(registro.next()==true){
				txtTelefono.setText(registro.getString(1));
				txtNombre.setText(registro.getString(2));
				txtApellidos.setText(registro.getString(3));
				txtCorreo.setText(registro.getString(4));
				
				
			}else{
				JOptionPane.showMessageDialog(null, "No existe ese contacto");
				txtTelefono.setEditable(true);
				btnBuscar.setVisible(true);
				btnModificar.setVisible(false);
				btnEliminar.setVisible(false);
			}
			conecta.close();
		}catch(SQLException ex){
			System.out.println(ex);
		}
	}
	/**
	 * metodo que pregunta al usuario que si esta seguro de eliminar un contacto, de ser asi manda marametros a la clase eliminar 
	 */
	public void eliminar(){
		int opcion=JOptionPane.showConfirmDialog(null, "Estas seguro de eliminar el contacto de : '"+txtNombre.getText()+"' '"+txtApellidos.getText()+"'");
		
		if(opcion==JOptionPane.YES_OPTION){
			vtnE.Datos(txtTelefono.getText(), null, null, null);
			limpiarCajas();
		}else{
			JOptionPane.showMessageDialog(null, "No se hicieron cambios");
			recibe(txtTelefono.getText());
			
		}
		
	}
	
/**
 * Metodo que limpia las cajas de texto de esta ventana
 */
	public void limpiarCajas(){
		txtTelefono.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtCorreo.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		
	}
}
