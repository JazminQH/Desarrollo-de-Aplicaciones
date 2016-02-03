package vista;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.text.AbstractDocument.Content;
/**
 * 
 * @author Jazmin Quezada
 *
 */
public class VentanaP extends JFrame implements ActionListener{
	
	private JLabel lblTitulo=new JLabel("Agenda de Contactos");
	
	private JButton btnConsulta=new JButton("Buscar Contacto");
	private JLabel lblConsulta=new JLabel("Ingresa el numero del contacto");
	private JTextField txtConsulta=new JTextField("");
	
	private JButton btnAgregar=new JButton("Agregar Contacto");
	private JLabel lblAgregar=new JLabel("Ingresa el numero del contacto");
	private JTextField txtAgregar= new JTextField("");
	
	private Container c=getContentPane();
	
	public VentanaNuevo vtnN=new VentanaNuevo();
	public VentanaContacto vtnC=new VentanaContacto();
	/**
	 * Dimensiones de la ventana
	 */
	public VentanaP(){
		super.setTitle("Agenda de Contactos");
		super.setSize(300,200);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		cargarControles();
	}
	

	/**
	 * carga los elementos a la ventana
	 */
	private void cargarControles() {
		// TODO Auto-generated method stub
		c.setLayout(null);
		lblTitulo.setBounds(81, 11, 121, 25);
		lblConsulta.setBounds(10,33,155,25);
		txtConsulta.setBounds(20,52,102,20);
		btnConsulta.setBounds(132,52,121,20);
		
		lblAgregar.setBounds(10,98,155,25);
		txtAgregar.setBounds(20,115,102,20);
		btnAgregar.setBounds(132,115,121,20);
		
		c.add(lblTitulo);
		c.add(lblConsulta);
		c.add(txtConsulta);
		c.add(btnConsulta);
		
		c.add(lblAgregar);
		c.add(txtAgregar);
		c.add(btnAgregar);
	
	/**
	 * boton que activa el metodo agregar tras hacer un clic en el
	 */
		btnAgregar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				agregar();
			}

		});
		/**
		 * boton que activa el metodo consultar tras hacer un clic en el
		 */
		btnConsulta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				consultar();
			}

		});

	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * metodo que envia el numero a la clase ventananuevo para agregarlo a la base de datos
	 */
	public void agregar() {
		vtnN.numero(txtAgregar.getText());
		vtnN.setVisible(true);
		this.setVisible(false);
		
		
		
	}
	
	/**
	 * metodo que envia un numero a la clase ventanaContacto para consultar un registro
	 */
	public void consultar() {
		vtnC.setVisible(true);
		this.setVisible(false);
		vtnC.recibe(txtConsulta.getText());
	
		
		
	}

}
