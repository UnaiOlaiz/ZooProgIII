package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * En esta ventana habrá algún tipo de input y al accionarlo se registrará el día de 
 * la semana y se mostrarán qué eventos tiene el guía en cuestión. Utilizaremos un 
 * hashMap que registre los días de la semana con algo más como estructura de datos
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VentanaGuia extends JFrame{
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pSur;
	private Map<String, ArrayList<String>> eventosPorDia;
	private JTextArea areaEventos;
	private JTextField textFieldDiaDeLaSemana;

	public VentanaGuia(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana del Guia");
		setBounds(500, 300, 700, 250);
		setBounds(500, 300, 700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setBackground(Color.WHITE);
        // Vamos con el mapa
        eventosPorDia = new HashMap<>();
        eventosPorDia.put("lunes", new ArrayList<>());
        eventosPorDia.put("martes", new ArrayList<>());
        eventosPorDia.put("miércoles", new ArrayList<>());
        eventosPorDia.put("jueves", new ArrayList<>());
        eventosPorDia.put("viernes", new ArrayList<>());
        eventosPorDia.put("sábado", new ArrayList<>());
        eventosPorDia.put("domingo", new ArrayList<>());

        eventosPorDia.get("lunes").add("Maravillas acuáticas - 13:30");
        eventosPorDia.get("miércoles").add("Maravillas acuáticas - 10:00");
        eventosPorDia.get("martes").add("Majestuosos Leones en acción - 12:30");
        eventosPorDia.get("viernes").add("Aventura ártica en directo - 15:00");
        eventosPorDia.get("sábado").add("Aventura ártica en directo - 15:00");
        eventosPorDia.get("martes").add("El hábitat del Tigre en Vivo - 13:00");
        eventosPorDia.get("miércoles").add("El hábitat del Tigre en Vivo - 13:00");
        eventosPorDia.get("jueves").add("El hábitat del Tigre en Vivo - 13:00");
        eventosPorDia.get("lunes").add("Tortugas en acción - 14:00");
        eventosPorDia.get("viernes").add("Tortugas en acción - 14:00");

//        for (ArrayList<String> evento : eventosPorDia.values()) {
//        	System.out.println(evento);
//        }

        textFieldDiaDeLaSemana = new JTextField();
        textFieldDiaDeLaSemana.setForeground(new Color(70, 130, 180));
        textFieldDiaDeLaSemana.setFont(new Font("Times New Roman", Font.BOLD, 14));
        textFieldDiaDeLaSemana.setPreferredSize(new Dimension(100, 30));

        JButton botonEventos = new JButton("Mostrar Eventos");
        botonEventos.setFont(new Font("Times New Roman", Font.BOLD, 14));
        botonEventos.setForeground(new Color(70, 130, 180));
        botonEventos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarEventos();
			}
		});

        areaEventos = new JTextArea(10, 40);
        areaEventos.setFont(new Font("Times New Roman", Font.BOLD, 14 ));
        areaEventos.setForeground(new Color(70, 130, 180));
        areaEventos.setEditable(false);

        JPanel panelCentro = new JPanel(new FlowLayout());
        panelCentro.setBackground(Color.WHITE);
        JLabel label = new JLabel("Día de la semana: ");
        label.setFont(new Font("Times New Roman", Font.BOLD, 14));
        label.setForeground(new Color(70, 130, 180));
        panelCentro.add(label);
        panelCentro.add(textFieldDiaDeLaSemana);
        panelCentro.add(botonEventos);
        panelCentro.add(new JScrollPane(areaEventos));
        getContentPane().add(panelCentro, BorderLayout.CENTER);


        btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.setForeground(new Color(70, 130, 180));
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
        	vActual.dispose();
        });
        pSur = new JPanel();
        pSur.setBackground(new Color(70, 130, 180));
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnVolver);

        setVisible(true);
	}

	protected void mostrarEventos() {
		if (textFieldDiaDeLaSemana == null) {
			System.out.println("Eror");
		} else {
			try {
	            String diaDeLaSemana = textFieldDiaDeLaSemana.getText().toLowerCase();  
				ArrayList<String> eventosDeEseDia = eventosPorDia.get(diaDeLaSemana);
				if (eventosDeEseDia!=null) {
					StringBuilder eventosTexto = new StringBuilder("Eventos para " + diaDeLaSemana + ":\n");
					eventosDeEseDia.forEach(evento -> {
						eventosTexto.append(evento).append("\n");
					});
					areaEventos.setText(eventosTexto.toString());
				} else {
	                areaEventos.setText("No hay eventos programados para " + diaDeLaSemana + ".");
				}
			} catch (IllegalArgumentException e) {
				areaEventos.setText("Por favor, ingrese el día de la semana válidamente");
			}
		}
	}

}