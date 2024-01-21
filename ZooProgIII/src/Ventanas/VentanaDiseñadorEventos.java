package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import BaseDeDatos.VisualizarBD;
import Zoo.Animal;

/*
 * En esta ventana, simularemos el trabajo que tiene que realizar el diseñador de eventos del
 * zoo. Para esto tiene que tener a mano la lista de eventos y los animales necesarios para
 * éste. Los animales los seleccionará directamente de la BD.
 */

public class VentanaDiseñadorEventos extends JFrame {
	private static final long serialVersionUID = 1L;
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pSur;
	private Map<String, ArrayList<String>> mapaEventos;
	private JTextField textFieldEvento;
	private JButton botonLlevarAnimales;
	private JComboBox<String> comboEventos;
	private JTextArea areaAnimales;
	
	public VentanaDiseñadorEventos(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana del Diseñador");
		setBounds(500, 300, 700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        // Mapa creado
        mapaEventos = new HashMap<>();
        mapaEventos.put("acuático", new ArrayList<>());
        mapaEventos.put("leones", new ArrayList<>());
        mapaEventos.put("tigre", new ArrayList<>());
        mapaEventos.put("tortugas", new ArrayList<>());
        
        mapaEventos.get("acuático").add("Maravillas acuáticas");
        mapaEventos.get("acuático").add("Aventura ártica en directo");
        mapaEventos.get("leones").add("Majestuosos Leones en acción");
        mapaEventos.get("tigre").add("El hábitat del Tigre en Vivo");
        mapaEventos.get("tortugas").add("Tortugas en acción");
        
//        for(ArrayList<String> s : mapaEventos.values()) {
//        	System.out.println(s);
//        }
        
        textFieldEvento = new JTextField();
        textFieldEvento.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        textFieldEvento.setPreferredSize(new Dimension(150, 30));
        
        comboEventos = new JComboBox<String>(new String[] {"Maravillas acuáticas", "Majestuosos leones en acción", "El hábitat del tigre en vivo", "Tortugas en acción", "Aventura Ártica en Directo"});
        
        areaAnimales = new JTextArea(10, 40);
        areaAnimales = new JTextArea(10, 40);
        areaAnimales.setFont(new Font("Times New Roman", Font.BOLD, 14 ));
        areaAnimales.setForeground(new Color(70, 130, 180));
        areaAnimales.setEditable(false);
        
        botonLlevarAnimales = new JButton("Llevar animales");
        botonLlevarAnimales.setFont(new Font("Times New Roman", Font.BOLD, 14));
        botonLlevarAnimales.setForeground(new Color(70, 130, 180));
        botonLlevarAnimales.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String eventoSeleccionado = comboEventos.getSelectedItem().toString();
				if (eventoSeleccionado.equals("Maravillas acuáticas")) {
					llevarAnimalesAcuáticos();
				} else if (eventoSeleccionado.equals("Majestuosos leones en acción")) {
					llevarLeones();
				} else if (eventoSeleccionado.equals("El hábitat del tigre en vivo")) {
					llevarTigres();
				} else if (eventoSeleccionado.equals("Tortugas en acción")) {
					llevarTortugas();
				} else if (eventoSeleccionado.equals("Aventura Ártica en Directo")) {
					llevarAnimalesArticos();
				}
			}
		});
        
        JPanel panelCentro = new JPanel();
        panelCentro.setBackground(Color.WHITE);
        JLabel labelEvento = new JLabel("Seleccione el evento: ");
        labelEvento.setForeground(new Color(70, 130, 180));
        labelEvento.setFont(new Font("Times New Roman", Font.BOLD, 14));
        panelCentro.add(labelEvento);
        panelCentro.add(comboEventos);
        panelCentro.add(botonLlevarAnimales);
        panelCentro.add(areaAnimales);
        getContentPane().add(panelCentro, BorderLayout.CENTER);
        
        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
        	vActual.dispose();
        });
        pSur = new JPanel();
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.setForeground(new Color(70, 130, 180));
        pSur.setBackground(new Color(70, 130, 180));
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnVolver);
        
        setVisible(true);
		
	}

	protected void llevarAnimalesArticos() {
		ArrayList<Animal> arrayArticos = VisualizarBD.obtenerAnimalesArticos();
		StringBuilder animalesTexto = new StringBuilder("Animales necesarios para el evento: \n");
		arrayArticos.forEach(animal -> {
			animalesTexto.append(animal).append("\n");
		});
		areaAnimales.setText(animalesTexto.toString());
	}


	protected void llevarTortugas() {
		ArrayList<Animal> arrayTortugas = VisualizarBD.obtenerTortugas();
		StringBuilder animalesTexto = new StringBuilder("Animales necesarios para el evento: \n");
		arrayTortugas.forEach(animal -> {
			animalesTexto.append(animal).append("\n");
		});
		areaAnimales.setText(animalesTexto.toString());
	}


	protected void llevarTigres() {
		ArrayList<Animal> arrayTigres = VisualizarBD.obtenerTigres();
		StringBuilder animalesTexto = new StringBuilder("Animales necesarios para el evento: \n");
		arrayTigres.forEach(animal -> {
			animalesTexto.append(animal).append("\n");
		});
		areaAnimales.setText(animalesTexto.toString());
	}


	protected void llevarAnimalesAcuáticos() {
		ArrayList<Animal> arrayAcuaticos = VisualizarBD.obtenerAnimalesAcuaticos();
		StringBuilder animalesTexto = new StringBuilder("Animales necesarios para el evento: \n");
		arrayAcuaticos.forEach(animal -> {
			animalesTexto.append(animal).append("\n");
		});
		areaAnimales.setText(animalesTexto.toString());
	}


	protected void llevarLeones() {
		ArrayList<Animal> arrayLeones = VisualizarBD.obtenerLeones();
		StringBuilder animalesTexto = new StringBuilder("Animales necesarios para el evento: \n");
		arrayLeones.forEach(animal -> {
			animalesTexto.append(animal).append("\n");
		});
		areaAnimales.setText(animalesTexto.toString());
	}


	


	

	
	

}