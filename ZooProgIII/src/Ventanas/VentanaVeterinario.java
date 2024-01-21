package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.border.Border;

import BaseDeDatos.VisualizarBD;
import Zoo.Animal;
import Zoo.AnimalAntiguo;
import Zoo.AsignacionVet_Ani;
import Zoo.Empleado;
import Zoo.Puesto;
import Zoo.Trabajador;
import Zoo.ZOO;

public class VentanaVeterinario extends JFrame {
    // Algunos Componentes

    protected JButton botonAsignar;
    protected JTextArea textoAsignaciones;
    protected JComboBox<Empleado> comboVeterinarios;
    protected JComboBox<Animal> comboAnimalesEnfermos;
    protected JComboBox<AsignacionVet_Ani> comboHistorialDeAsignaciones;
    protected JFrame vActual, vAnterior;

    public VentanaVeterinario(JFrame va) {
    	super();
		vActual = this;
		vAnterior = va;
		setResizable(false);
        // Atributos principales de la ventana
        setTitle("Ventana de Veterinario");
        setLocationRelativeTo(null);
        setBounds(500, 300, 700, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panelMensaje = new JPanel();
        panelMensaje.setBackground(new Color(70, 130, 180));
        JLabel labelMensaje = new JLabel("Regular asignaciones de animales enfermos a cada veterinario");
        labelMensaje.setForeground(Color.WHITE);
        labelMensaje.setFont(new Font("Times New Roman", Font.BOLD, 20));
        panelMensaje.add(labelMensaje);

        JPanel panelCombos = new JPanel();
        panelCombos.setBackground(new Color(70, 130, 180));
        panelCombos.setLayout(new GridLayout(1, 2));

        comboAnimalesEnfermos = new JComboBox<Animal>();
        Border bordeAnimalesEnfermos = BorderFactory.createTitledBorder("Animales enfermos: ");
        
        comboAnimalesEnfermos.setBorder(bordeAnimalesEnfermos);
        panelCombos.add(comboAnimalesEnfermos);
        ArrayList<Animal> animalesEnfermos = VisualizarBD.cargarAnimalesEnfermos();
        animalesEnfermos.forEach(animal -> {
        	comboAnimalesEnfermos.addItem(animal);
        });

        comboVeterinarios = new JComboBox<Empleado>();
        Border bordeVeterinarios = BorderFactory.createTitledBorder("Veterinarios disponibles: ");
        comboVeterinarios.setBorder(bordeVeterinarios);
        panelCombos.add(comboVeterinarios);
        Empleado vet1 = new Empleado();
        vet1.setNombreEmpleado("Carlos Rodriguez");
        vet1.setPuestoEmpleado("Veterinario");
        comboVeterinarios.addItem(vet1);

        // Parte del textArea
        JPanel panelTexto = new JPanel();
        textoAsignaciones = new JTextArea(10, 30);
        textoAsignaciones.setLineWrap(true);
        textoAsignaciones.setWrapStyleWord(true);
        JScrollPane paneTexto = new JScrollPane(textoAsignaciones);

        JPanel panelBotones = new JPanel();
        botonAsignar = new JButton("Asignar veterinario");
        botonAsignar.setForeground(new Color(70, 130, 180));
        botonAsignar.setFont(new Font("Times New Roman", Font.BOLD, 14));
        botonAsignar.setEnabled(true);
        botonAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Animal animalEnfermoSeleccionado = (Animal) comboAnimalesEnfermos.getSelectedItem();
            	Empleado vetSeleccionado = (Empleado) comboVeterinarios.getSelectedItem();
            	
            	if (animalEnfermoSeleccionado != null && vetSeleccionado != null) {
            		Date fechaHoy = new Date(System.currentTimeMillis());
                    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String fechaFinal = formatoFecha.format(fechaHoy);
                    String asignacion = String.format("[%s] Asignación: Veterinario - %s, Animal - %s\n", fechaFinal,
                            vetSeleccionado.getNombreEmpleado(), animalEnfermoSeleccionado.getNombre());
            		
            		textoAsignaciones.append(asignacion);
            		
            		comboAnimalesEnfermos.removeItem(animalEnfermoSeleccionado); // Quitamos al animal al ser curado
            		// Al vet no ya que ha de seguir trabajando
            	
            	} else if (comboAnimalesEnfermos.getItemCount() == 0) {
            		JOptionPane.showMessageDialog(null, "No quedan más animales a atender.",
                            "Error de asignación", JOptionPane.ERROR_MESSAGE);
            	} else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un animal y un veterinario.",
                            "Error de asignación", JOptionPane.ERROR_MESSAGE);
                }
            	
            }
        });
        
        JButton botonVolver = new JButton("Volver");
        botonVolver.setForeground(new Color(70, 130, 180));
        botonVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        botonVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
			vActual.dispose();
        });
        
        panelBotones.add(botonAsignar);
        panelBotones.setBackground(new Color(70, 130, 180));
        panelBotones.add(botonVolver);
        
        setLayout(new GridLayout(4, 1));
        add(panelMensaje);
        add(panelCombos);
        add(paneTexto);
        add(panelBotones);

        setVisible(true);
    }

    
}