package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import Zoo.BordeadoTexto;
import Zoo.Empleado;
import Zoo.ImagePanel;
import Zoo.Trabajador;
import Zoo.ZOO;

public class VentanaTrabajador extends JFrame{
	private JLabel lblDniR, lblnomR, lblConR, lblPuestoR, lblDniIS, lblconIS;
	private JButton btnVolver, btnInicio, btnRegistro;
	private JTextField txtDniR, txtnomR, txtDniIS;
	private JPasswordField txtconR, txtconIS;
	private JPanel pNorte, pCentro, pCentrodch, pCentroizq;
	private JFrame vActual, vAnterior;
	private JComboBox<String> comboOficios;
	
	public VentanaTrabajador (JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setBounds(500, 300, 700, 250);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setResizable(false);
		
		JLabel lblTitulo = new JLabel("INICIO DE SESIÓN TRABAJADOR");
		lblTitulo.setForeground(new Color(70, 130, 180));
	    lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));


	    pNorte = new JPanel();
	    pNorte.setBackground(Color.WHITE);
//	    getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(30, 144, 255))); No pongamos color azul aquí, no creo que quede bien
	    getContentPane().add(pNorte, BorderLayout.NORTH);
	    pNorte.add(lblTitulo);

	    pCentro = new JPanel(new GridLayout(2, 2));
	    pCentro.setBackground(Color.white);
//	    pCentro.setBackground(new Color(240, 240, 240));
	    pCentrodch = new JPanel(new GridLayout(2, 2));
	    pCentrodch.setBackground(Color.white);
	    pCentroizq = new JPanel(new GridLayout(4, 4));
	    pCentroizq.setBackground(Color.white);
//	    pCentroizq.setBackground(new Color(240, 240, 240));
		
		//Registro
		lblPuestoR = new JLabel("Puesto de trabajo:");
		lblPuestoR.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblPuestoR.setForeground(new Color(70, 130, 180));
		String[] opcionesArray = {"Elige una opcion", "LIMPIEZA", "VETERINARIO", "GUIA", "ADMINISTRADOR", "DISEÑADOR DE EVENTOS", "TAQUILLERO", "GUARDIA DE SEGURIDAD"};
        
		
		
		comboOficios = new JComboBox<>(opcionesArray);
        lblnomR = new JLabel("Nombre:");
        lblnomR.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblnomR.setForeground(new Color(70, 130, 180));
        txtnomR = new JTextField();
        lblDniR = new JLabel("DNI:");
        lblDniR.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblDniR.setForeground(new Color(70, 130, 180));
        txtDniR = new JTextField();
        lblConR = new JLabel("Contraseña:");
        lblConR.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblConR.setForeground(new Color(70, 130, 180));
        txtconR = new JPasswordField();
        pCentroizq.add(lblPuestoR);
        pCentroizq.add(comboOficios);
        pCentroizq.add(lblnomR);
        pCentroizq.add(txtnomR);
        pCentroizq.add(lblDniR);
        pCentroizq.add(txtDniR);
        pCentroizq.add(lblConR);
        pCentroizq.add(txtconR);
        getContentPane().add(pCentro, BorderLayout.CENTER);
        pCentro.add(pCentroizq);
        
        //Inicio sesion
        lblDniIS = new JLabel("DNI:");
        lblDniIS.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblDniIS.setForeground(new Color(70, 130, 180));
        txtDniIS = new JTextField();
        lblconIS = new JLabel("Contraseña:");
        lblconIS.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lblconIS.setForeground(new Color(70, 130, 180));
        txtconIS = new JPasswordField();
        pCentrodch.add(lblDniIS);
        pCentrodch.add(txtDniIS);
        pCentrodch.add(lblconIS);
        pCentrodch.add(txtconIS);
        pCentro.add(pCentrodch);
        
        //Boton Registro
        btnRegistro = new JButton("REGISTRARSE");
        btnRegistro.setForeground(new Color(70, 130, 180));
        pCentro.add(btnRegistro);
        
        //Boton Inicio sesion
        btnInicio = new JButton("INICIAR SESIÓN");
        pCentro.add(btnInicio);
        
        //Boton volver
        btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnInicio.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnInicio.setForeground(new Color(70, 130, 180));
        btnRegistro.setFont(new Font("Times New Roman", Font.BOLD, 14));

        
        JPanel pSur = new JPanel();
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.setBackground(new Color(70, 130, 180));
        pSur.add(btnVolver);
        
        // Zoo.cargarFicheroTrabajadoresEnLista("Trabajadores.csv");
		btnVolver.setForeground(new Color(70, 130, 180));
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
			vActual.dispose();
			Zoo.guardarListaTrabajadoresEnFichero("Trabajadores.csv");
        });
             
       
        //Boton Registrarse
        btnRegistro.addActionListener((e)->{
        	String p_tra = (String) comboOficios.getSelectedItem();
			String nom = txtnomR.getText();
			String dni = txtDniR.getText();
			@SuppressWarnings("deprecation")
			String con = txtconR.getText();
			Empleado t = new Empleado(dni, nom, p_tra, con);
//			System.out.println(t.toString()); Para pruebas
			
			ArrayList<Empleado> trabajadors = BaseDeDatos.VisualizarBD.visualizarEmpleados();
			
			if (!( txtnomR.getText().trim().isEmpty() || txtDniR.getText().trim().isEmpty() || txtconR.getText().trim().isEmpty() || comboOficios.getSelectedItem().equals("Elige una opcion"))) {
				if (!trabajadors.contains(t)) {
					try {
						
		 			PrintWriter pw = new PrintWriter(new FileWriter("Empleados.csv", true));
						pw.println( dni + ";" + nom + ";" + p_tra + ";" + con );
						JOptionPane.showMessageDialog(null, "Cliente registrado correctamente","REGISTRADO CORRECTAMENTE",JOptionPane.INFORMATION_MESSAGE);
						System.out.println(t.toString());
						pw.flush();
						pw.close();
						abrirVentana(p_tra);
					} catch (IOException e1) {
						// TODO: handle exception
						JOptionPane.showMessageDialog(null, "No se ha podido registrar el trabajador, compruebe la ubicación del fichero.", "ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);

					}
				} else {
					System.err.println( "El trabajador ya está registrado" );
				}
			} else {
				JOptionPane.showMessageDialog(null, "No se ha podido registrar el trabajador, compruebe que todos los campos estén rellenados.", "ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
			
//			if(Zoo.buscarTrabajador(dni) == null) {
//				Zoo.aniadirTrabajador(t);
//				JOptionPane.showMessageDialog(null, "Cliente registrado correctamente","REGISTRADO CORRECTAMENTE",JOptionPane.INFORMATION_MESSAGE);
//			} else {
//				JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese DNI", "ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
//			}
			limpiarCampos();
		});
        
        //Boton Inicio Sesion
        btnInicio.addActionListener((e)->{
        	String nombreEmpleado = txtnomR.getText();
        	String DNI = txtDniIS.getText();
        	String contrasena = txtconIS.getText();
        	
        	/*
        	 * Vamos a buscar dentro del fichero que usamos para guardar a los
        	 * empleados para ver si el trabajador ya está registrado, en este
        	 * caso el DNI será la clave. Cargaremos a todos los trabajadores 
        	 * de dentro del fichero, miraremos uno por uno los DNIs y si coinide
        	 * con el introducido lanzará un error diciendo que ya ha sido registrado
        	 * 
        	 */
        	
        	ArrayList<Empleado> empleadosExistentes = new ArrayList<>();
        	
        	if (!(txtDniIS.getText().trim().isEmpty() || txtconIS.getText().trim().isEmpty())) {
        		try {
            		Scanner sc = new Scanner(new FileReader( "Empleados.csv" ));
            		String linea;
            		while (sc.hasNext()) {
    					linea = sc.nextLine();
//    					System.out.println( "Línea: " + linea );
    					String [] partes = linea.split( ";" );
    					if (partes.length >= 4) {
    						String dni = partes[0];
        					String nombre = partes[1];
        					String puestoDeTrabajo = partes[2];
        					String contrasenyaEmpleado = partes[3]; // Aquí vamos a invadir un poco la privacidad del empleado para garantizar un registro de mayor seguridad
        					Empleado empleado = new Empleado(dni, nombre, puestoDeTrabajo, contrasenyaEmpleado);
        					empleadosExistentes.add(empleado);
//        					System.out.println(empleadosExistentes); // Para probar
    					} 
    					
    				}
            	}catch (FileNotFoundException e1) {
    				// TODO: handle exception
            		e1.printStackTrace();
    			}
        	}else {
				JOptionPane.showMessageDialog(null, "No se ha podido iniciar sesión, compruebe que todos los campos estén rellenados.", "ERROR EN EL INICIO DE SESION", JOptionPane.ERROR_MESSAGE);
			}
        	
        	// Ahora vamos a ver si está registrado o no
        	// Creo 2 arraylists auxiliares
        	ArrayList<String> DNI_Empleados = new ArrayList<>();
        	ArrayList<String> Contrasena_Empleados = new ArrayList<>();
        	
        	for( Empleado empleado : empleadosExistentes ) {
        		DNI_Empleados.add(empleado.getDNI());
        		Contrasena_Empleados.add(empleado.getContrasena());
        	}
        	
        	Empleado empleado = new Empleado();
        	for (Empleado empleado2 : empleadosExistentes) {
        		if(empleado2.getDNI().equals(DNI)) {
        			empleado = empleado2;
        		}
        	}
        	String puestoTrabajo = empleado.getPuestoEmpleado();
        	
        	if(DNI_Empleados.contains(DNI) && Contrasena_Empleados.contains(contrasena)) {
        		JOptionPane.showMessageDialog(null, "Bienvenido " + nombreEmpleado, "Inicio de sesión correcto", JOptionPane.INFORMATION_MESSAGE);
        		abrirVentana(puestoTrabajo);
        	}else {
        		JOptionPane.showMessageDialog(null, "El cliente no esta registrado", "Error en el inicio de sesion", JOptionPane.ERROR_MESSAGE);
			}
        	
        	
        	
        	
//			String dni = txtDniIS.getText();
//			@SuppressWarnings("deprecation")
//			String con = txtconIS.getText();
//			String tipoTrabajador = (String) comboOficios.getSelectedItem();
//			Trabajador t = Zoo.buscarTrabajador(dni);
//			if(t == null) {
//				JOptionPane.showMessageDialog(null, "El cliente no esta registrado", "Error en el inicio de sesion", JOptionPane.ERROR_MESSAGE);
//			} else if(t.getCon().equals(con)) {
//				JOptionPane.showMessageDialog(null, "Bienvenido "+t.getNombre(), "Inicio de sesion correcto", JOptionPane.INFORMATION_MESSAGE);
//				abrirVentana(tipoTrabajador);
//			} else {
//				JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error en el inicio de sesion", JOptionPane.ERROR_MESSAGE);
//			}
		});
        
        
        
        
        
		setVisible(true);
	}
	
	private void limpiarCampos() {
		txtDniIS.setText("");
		txtDniR.setText("");
		txtnomR.setText("");
		txtconR.setText("");
		txtconIS.setText("");
	}
	
    
	    protected void abrirVentana(String tipoTrabajador) {
		// TODO Auto-generated method stub
	        switch (tipoTrabajador) {
	            case "LIMPIEZA":
	                new VentanaPersonalLimpieza(vActual);
	                vActual.dispose();
	                break;
	            case "MANTENIMIENTO":
	                new VentanaMantenimiento(vActual);
	                vActual.dispose();
	                break;
	            case "CUIDADOR":
	                new VentanaCuidador(vActual);
	                vActual.dispose();
	                break;
	            case "VETERINARIO":
	                new VentanaVeterinario(vActual);
	                vActual.dispose();
	                break;
	            case "GUIA":
	                new VentanaGuia(vActual);
	                vActual.dispose();
	                break;
	            case "ADMINISTRADOR":
	                new VentanaAdministrador(vActual);
	                vActual.dispose();
	                break;
	            case "DISEÑADOR DE EVENTOS":
	                new VentanaDiseñadorEventos(vActual);
	                vActual.dispose();
	                break;
	            case "TAQUILLERO":
	                new VentanaTaquillero(vActual);
	                vActual.dispose();
	                break;
	            case "GUARDIA DE SEGURIDAD":
	                new VentanaSeguridad(vActual);
	                vActual.dispose();
	                break;
	            default:
	        }
		
	}
}