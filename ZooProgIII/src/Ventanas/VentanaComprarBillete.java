package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import Zoo.CompraDeBilletes;
import Zoo.Visitante;
import Zoo.VisitanteZoo;

public class VentanaComprarBillete extends JFrame {
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pNorte, pSur;
	
	
	public VentanaComprarBillete(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Comprar billete");
		setResizable(false);
		setLocationRelativeTo(null);
		setBounds(200, 100, 1100, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Diseño de la ventana
        JLabel lblTitulo = new JLabel("Compra de billetes");
		lblTitulo.setForeground(new Color(70, 130, 180));
	    lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));

	    JPanel panelSuperior = new JPanel(new BorderLayout());
	    
	    pNorte = new JPanel();
	    pNorte.setBackground(Color.WHITE);
//	    getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, new Color(30, 144, 255))); No pongamos color azul aquí, no creo que quede bien
	    pNorte.add(lblTitulo);
	    panelSuperior.add(pNorte, BorderLayout.NORTH);
	    
	    JPanel panelExplicacion = new JPanel(new GridLayout(3,1));
	    
	    JPanel panelExplicacion1 = new JPanel();
	    panelExplicacion1.setBackground(new Color(70, 130, 180));
	    JLabel labelExplicacion1 = new JLabel( "He aquí donde se le facilitará la compra de los billetes.");
	    labelExplicacion1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelExplicacion1.setForeground(Color.WHITE);
	    panelExplicacion1.add(labelExplicacion1);
	    
	    JPanel panelExplicacion2 = new JPanel();
	    panelExplicacion2.setBackground(new Color(70, 130, 180));
	    JLabel labelExplicacion2 = new JLabel( "El precio de entrada son 15€.");
	    labelExplicacion2.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelExplicacion2.setForeground(Color.WHITE);
	    panelExplicacion2.add(labelExplicacion2);
	    
	    JPanel panelExplicacion3 = new JPanel();
	    panelExplicacion3.setBackground(new Color(70, 130, 180));
	    JLabel labelExplicacion3 = new JLabel( "Pero los menores de 10 años entrarán gratis y para los mayores de 60 sólo 10€.");
	    labelExplicacion3.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelExplicacion3.setForeground(Color.WHITE);
	    panelExplicacion3.add(labelExplicacion3);
	    
	    panelExplicacion.add(panelExplicacion1);
	    panelExplicacion.add(panelExplicacion2);
	    panelExplicacion.add(panelExplicacion3);
	    
	    panelSuperior.add(panelExplicacion, BorderLayout.SOUTH);
	    getContentPane().add(panelSuperior, BorderLayout.NORTH);

	    
	    JPanel panelCentro = new JPanel( new GridLayout(5, 2, 10, 10) );
	    panelCentro.setBackground(Color.white);
	    JLabel labelNombreCliente = new JLabel( "Ingrese su nombre: ( en caso de ser un grupo el nombre del supervisor) " );
	    labelNombreCliente.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelNombreCliente.setForeground(new Color(70, 130, 180));
	    panelCentro.add(labelNombreCliente);
	    JTextField textFieldNombreCliente = new JTextField( 20 );
	    panelCentro.add(textFieldNombreCliente);
	    
	    JLabel labelEdadCliente = new JLabel( "Ingrese la cantidad de adultos: ");
	    labelEdadCliente.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelEdadCliente.setForeground(new Color(70, 130, 180));
	    panelCentro.add(labelEdadCliente);
	    SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
	    JSpinner jSpinner = new JSpinner(spinnerModel);
	    panelCentro.add(jSpinner);
	    
	    JLabel labelEdadClienteMenores = new JLabel( "Ingrese la cantidad de visitantes menores de 10 años: ");
	    labelEdadClienteMenores.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelEdadClienteMenores.setForeground(new Color(70, 130, 180));
	    panelCentro.add(labelEdadClienteMenores);
	    SpinnerModel spinnerModelMenores = new SpinnerNumberModel(0, 0, 100, 1);
	    JSpinner jSpinnerMenores = new JSpinner(spinnerModelMenores);
	    panelCentro.add(jSpinnerMenores);
	    
	    JLabel labelEdadClienteAdultos = new JLabel( "Ingrese la cantidad de visitantes mayores de 60 años: ");
	    labelEdadClienteAdultos.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelEdadClienteAdultos.setForeground(new Color(70, 130, 180));
	    panelCentro.add(labelEdadClienteAdultos);
	    SpinnerModel spinnerModelAdultos = new SpinnerNumberModel(0, 0, 100, 1);
	    JSpinner jSpinnerAdultos = new JSpinner(spinnerModelAdultos);
	    panelCentro.add(jSpinnerAdultos);
	    
	    JLabel labelFecha = new JLabel( "Fecha actual: " );
	    labelFecha.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelFecha.setForeground(new Color(70, 130, 180));
	    panelCentro.add(labelFecha);
	    Date fechaCompra = new  Date();
	    SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd" );
	    String string = dateFormat.format(fechaCompra);
	    JLabel fecha = new JLabel(string);
	    fecha.setForeground(new Color(70, 130, 180));
	    panelCentro.add(fecha);
	    
	    getContentPane().add(panelCentro);
	    
        
        btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.setForeground(new Color(70, 130, 180));
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
        	vActual.dispose();
        });
        
        JButton botonComprar = new JButton( "COMPRAR" );
        botonComprar.setForeground(new Color(70, 130, 180));
        botonComprar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        
        botonComprar.addActionListener(new ActionListener() {
        	
        	/*
        	 * Al insertar los datos en los campos de información y pulsar el botón de comprar
        	 * se guardará en un fichero al visitante
        	 */
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nombreVisitante = textFieldNombreCliente.getText();
				String fechaDeCompra = string;
				int cantidadAdultos = (int) jSpinnerAdultos.getValue();
				int cantidadMenores = (int) jSpinnerMenores.getValue();
				int cantidadNormal = (int) jSpinner.getValue();
				int cantidadVisitantes = cantidadAdultos + cantidadMenores + cantidadNormal;
				
				ArrayList<VisitanteZoo> visitantes = new ArrayList<>();
				
				try {
					Scanner scanner = new Scanner(new FileReader( "Visitantes.csv" ));
					String linea;
					while (scanner.hasNext()) {
						linea = scanner.nextLine();
						// System.out.println( "Línea: " + linea );
						String[] partes = linea.split( ";" );
						int idVisitante = Integer.parseInt(partes[0]);
						String nombreVis = partes[1];
						int cantidad = Integer.parseInt(partes[2]);
						SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyy/MM/dd" );
						Date fecha = new Date();
						String string = dateFormat.format(fecha);
						VisitanteZoo visitante = new VisitanteZoo(idVisitante, nombreVis, cantidad, string);
						visitantes.add(visitante);
//						System.out.println(visitantes);
					}
				}catch (FileNotFoundException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
				
				int idVisitante = visitantes.size() + 1;

				VisitanteZoo visitante = new VisitanteZoo(idVisitante, nombreVisitante, cantidadVisitantes, fechaDeCompra);
				
				// Guardamos los visitantes
				
				if ( textFieldNombreCliente.getText().trim().isEmpty() || (cantidadAdultos + cantidadMenores + cantidadNormal == 0)) {
					JOptionPane.showMessageDialog(null, "No se ha podido registrar el visitante, compruebe que todos los campos estén rellenados.", "ERROR EN LA COMPRA DEL BILLETE", JOptionPane.ERROR_MESSAGE);
				} else {
					if(!visitantes.contains(visitante)) {
						try {
							PrintWriter printWriter = new PrintWriter(new FileWriter("Visitantes.csv", true));
							printWriter.println( idVisitante + ";" + nombreVisitante + ";" + cantidadVisitantes + ";" + fechaDeCompra );
							JOptionPane.showMessageDialog(null, "Visitante registrado correctamente","REGISTRADO CORRECTAMENTE",JOptionPane.INFORMATION_MESSAGE);
							visitantes.add(visitante);
							System.out.println(visitante.toString());
							
							// A calcular el precio total de las entradas
							CompraDeBilletes compraActual = new CompraDeBilletes();
							compraActual.setPrecio( cantidadNormal * 15 + cantidadMenores * 0 + cantidadAdultos * 10);
							compraActual.setFecha(fechaCompra);
							ArrayList<CompraDeBilletes> comprasHechas = compraActual.getCompras();
							comprasHechas.add(compraActual);
							JOptionPane.showMessageDialog(null, "Precio total de las entradas: " + compraActual.getPrecio() + "€" , "COMPRA REALIZADA",JOptionPane.INFORMATION_MESSAGE);

							
							
							// Después del registro
							textFieldNombreCliente.setText(null);
							jSpinner.setValue(0);
							jSpinnerAdultos.setValue(0);
							jSpinnerMenores.setValue(0);
							
							printWriter.flush();
							printWriter.close();
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null, "No se ha podido registrar el visitante, compruebe la ubicación del fichero.", "ERROR EN EL REGISTRO", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						System.err.println( "El visitante ya está registrado" );
					}
				}
			}
		});
        
        
        pSur = new JPanel();
        pSur.setBackground(new Color(70, 130, 180));
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(botonComprar);
        pSur.add(btnVolver);
        
        setVisible(true);
	}

}
