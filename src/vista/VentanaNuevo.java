package vista;
/**
 * importacion de librerias
 */
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import base.Conexion;
import modelo.Insertar;
/**
 * 
 * @author Jazmin Quezada
 *
 */
public class VentanaNuevo extends JFrame implements ActionListener {
	/**
	 * declaracion de variables
	 */
	private JLabel lblTitulo=new JLabel("Nuevo Contacto");
	
	private JLabel lblTelefono=new JLabel("Numero: ");
	private JTextField txtTelefono= new JTextField("");
	
	private JLabel lblNombre=new JLabel("Nombre: ");
	private JTextField txtNombre=new JTextField("");
	
	private JLabel lblApellidos=new JLabel("Apellidos: ");
	private JTextField txtApellidos=new JTextField("");
	
	private JLabel lblCorreo=new JLabel("Correo: ");
	private JTextField txtCorreo=new JTextField("");
	
	private JButton btnAgregar=new JButton("Agregar Contacto");
	private JButton btnMenu=new JButton("Regresar");
	public String n;

	
	private Container c=getContentPane();
	
	public JFrame vtn;
	Insertar in= new Insertar();
	
	public void numero(String numero){
		n=numero;
		txtTelefono.setText(n);
		
	}
	/**
	 * se establecen dimensiones de la ventana
	 */
	public VentanaNuevo(){
		super.setTitle("Nuevo Contacto");
		super.setSize(300,300);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
	

	/**
	 * se cargan los componentes a la ventana
	 */
	private void cargarControles() {
		// TODO Auto-generated method stub
		c.setLayout(null);
		lblTitulo.setBounds(81, 11, 121, 25);
		lblTelefono.setBounds(10,33,155,25);
		txtTelefono.setBounds(81,35,102,20);
				
		lblNombre.setBounds(10,69,155,25);
		txtNombre.setBounds(81,69,102,20);
		
		lblApellidos.setBounds(10,105,155,25);
		txtApellidos.setBounds(81,105,102,20);
		
		lblCorreo.setBounds(10,141,155,25);
		txtCorreo.setBounds(81,143,102,20);
		
		btnAgregar.setBounds(10,192,121,20);
		btnMenu.setBounds(153,192,121,20);
		
		c.add(lblTitulo);
		c.add(lblTelefono);
		c.add(txtTelefono);
		c.add(lblNombre);
		c.add(txtNombre);
		c.add(lblApellidos);
		c.add(txtApellidos);
		c.add(btnMenu);
		c.add(btnAgregar);
		c.add(lblCorreo);
		c.add(txtCorreo);
		
		
		
		/**
		 * boton que activa el metodo enviar tras hacer un clic en el
		 */
		btnAgregar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				enviar();
				
			}

			

		});
		/**
		 * boton que activa el metodo regresa tras hacer un clic en el
		 */
		btnMenu.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				regresa();
				
			}

			

		});
	}
	
	/**
	 * metodo que envia parametros a la clase insertar para agregar los elementos a la base de datos
	 */
	public void enviar(){
		in.Datos(txtTelefono.getText(), txtNombre.getText(), txtApellidos.getText(), txtCorreo.getText());
		txtTelefono.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtCorreo.setText("");
		
	}
	
	/**
	 * metodo que te regresa a la ventana del menu
	 */
	public void regresa(){
		vtn=new VentanaP();
		this.setVisible(false);
		vtn.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
