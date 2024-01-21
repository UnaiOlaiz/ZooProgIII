package Ventanas;

import java.awt.BorderLayout;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import Zoo.*;

public class VentanaCuidador extends JFrame{
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver;
	protected JPanel pSur;
	
	private JList<String> listaDeAnimales;
    private JTextArea informacionAnimal;
    private JButton botonModificar;
    private ArrayList<AnimalAntiguo> animalesDelZoo;
	
	public VentanaCuidador(JFrame va) {
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana del Cuidador");
		setBounds(500, 300, 700, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        btnVolver = new JButton("VOLVER");
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
        	vActual.dispose();
        });
        pSur = new JPanel();
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnVolver);

        animalesDelZoo = new ArrayList<>();
        // Llenar la lista de animales

        // Crea un DefaultListModel para la JList
        DefaultListModel<String> modeloListaAnimales = new DefaultListModel<>();
        for (AnimalAntiguo animal : animalesDelZoo) {
            modeloListaAnimales.addElement(animal.getNombre());
        }
        
        listaDeAnimales = new JList<>(modeloListaAnimales);
        listaDeAnimales.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        informacionAnimal = new JTextArea();
        informacionAnimal.setEditable(false);
        
        JScrollPane scrollInformacionAnimal = new JScrollPane(informacionAnimal);
        scrollInformacionAnimal.setPreferredSize(new Dimension(300, 400));

        botonModificar = new JButton("Modificar");
        botonModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Maneja la modificación del animal seleccionado aquí
                int indiceSeleccionado = listaDeAnimales.getSelectedIndex();
                if (indiceSeleccionado >= 0) {
                    AnimalAntiguo animalSeleccionado = animalesDelZoo.get(indiceSeleccionado);
                    // Implementa la lógica de modificación
                }
            }
        });
        
        //Organizar la ventana
        
        JPanel panelIzquierdo = new JPanel(new BorderLayout());
        panelIzquierdo.add(new JLabel("Animales del Zoo"), BorderLayout.NORTH);
        panelIzquierdo.add(new JScrollPane(listaDeAnimales), BorderLayout.CENTER);
        panelIzquierdo.add(botonModificar, BorderLayout.SOUTH);

        JPanel panelDerecho = new JPanel(new BorderLayout());
        panelDerecho.add(new JLabel("Información del Animal"), BorderLayout.NORTH);
        panelDerecho.add(scrollInformacionAnimal, BorderLayout.CENTER);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelIzquierdo, BorderLayout.WEST);
        panelPrincipal.add(panelDerecho, BorderLayout.CENTER);

        add(panelPrincipal);
        
        setVisible(true);
		
	}
	
	/*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaCuidador();
            }
        });

}*/

}
