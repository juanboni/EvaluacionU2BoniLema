package ec.edu.ups.pweb.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ec.edu.ups.pweb.model.Vehiculo;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;

public class ventanavehiculo extends JFrame {

	
	private DefaultListModel mdl=new  DefaultListModel();
	private JPanel contentPane;
	private JTextField txtbuscar;
	private JTable table;
	private JLabel lblNewLabel_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanavehiculo frame = new ventanavehiculo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void cargarmodel(String buscar) {
		vistavehiculo v=new vistavehiculo();
		List<Vehiculo> listav=v.mostrarvehiculo(buscar);
		for(int i=0;i < listav.size();i++) {
			mdl.addElement(listav.get(i));
		}
	}
	 public void mostrar() {
		 
	 }
	 
	/**
	 * Create the frame.
	 */
	public ventanavehiculo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 401, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(30, 187, 340, 182);
		contentPane.add(textArea);
		
		JButton btnbuscar = new JButton("buscar");
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistavehiculo v=new vistavehiculo();
				try {
					v.conectar();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				v.mostrarvehiculos(txtbuscar.getText());
				
				textArea.setText("");
				
				List<Vehiculo> listav=v.mostrarvehiculo(txtbuscar.getText());
				for(Vehiculo v1 : listav) {
				//textArea.setText(v1.getMarca());
					//response.getWriter().append("<Strong>"+v1.getMarca()+"</strong>");
					textArea.append(v1.getMarca()+"\t"+v1.getModelo()+"\t"+v1.getAnio()+"\n");
					
					
				}
				
				
			}
		});
		btnbuscar.setBounds(30, 136, 85, 21);
		contentPane.add(btnbuscar);
		
		txtbuscar = new JTextField();
		txtbuscar.setBounds(30, 100, 126, 19);
		contentPane.add(txtbuscar);
		txtbuscar.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Ingrese marca , modelo o anio");
		lblNewLabel.setBounds(30, 77, 198, 13);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Lista de Vehiculos");
		lblNewLabel_1.setBounds(30, 167, 103, 13);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
