package Ventanas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

public class VentanaLimpieza extends JFrame {
    protected JFrame vActual, vAnterior;
    protected JButton btnVolver, btnComenzar, btnFinalizar;
    protected JPanel pSur;
    protected JList<String> listaTareas;
    protected DefaultListModel<String> listModel;
    protected JProgressBar barraProgreso;

    public VentanaLimpieza(JFrame va) {
        super();
        vActual = this;
        vAnterior = va;
        setTitle("Ventana de Limpieza");
        setBounds(500, 300, 700, 400); // Ajuste el tamaño de la ventana según sea necesario
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        

        // Crear lista de tareas
        listModel = new DefaultListModel<>();
        listModel.addElement("Limpiar oficina principal");
        listModel.addElement("Vaciar papeleras");
        listModel.addElement("Limpiar baños");
        listModel.addElement("Lavar ventanas");

        listaTareas = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(listaTareas);
        add(scrollPane, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        
        JButton botonCompletar = new JButton( "Completar" );
        botonCompletar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				completarTarea();
				
			}

			private void completarTarea() {
				// TODO Auto-generated method stub
				int indice = listaTareas.getSelectedIndex();
				if( indice != -1 ) {
					listModel.remove(indice);
					actualizarBarraProgreso();
				}else {
					JOptionPane.showMessageDialog(null, this, "Selecciona una tarea para completarla.", 0);
				}
			}

			
		});
        
        panel.add(botonCompletar);
        
        barraProgreso = new JProgressBar(0, listModel.size());
        barraProgreso.setStringPainted(true);
        actualizarBarraProgreso();
        
        panel.add(barraProgreso);
        add(panel, BorderLayout.SOUTH);
        
        setVisible(true);
}

	private void actualizarBarraProgreso() {
		// TODO Auto-generated method stub
		barraProgreso.setValue(listModel.size());
		barraProgreso.setString("Tareas completadas: " + listModel.size() + " de " + listModel.getSize());
	}}

	


