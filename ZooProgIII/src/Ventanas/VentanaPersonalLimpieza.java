package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class VentanaPersonalLimpieza extends JFrame{
	protected JFrame vActual, vAnterior;
	 protected JButton btnVolver, btnComenzar, btnFinalizar;
	 protected JPanel pSur;
	 protected JList<String> listaTareas;
	 protected DefaultListModel<String> listModel;
	 protected JProgressBar progressOficinas, progressPapeleras, progressBanyos, progressHabitats;
	 protected JCheckBox boxOficinas, boxPapeleras, boxBanyos, boxHabitats;
	 
	 
	 
	 public VentanaPersonalLimpieza( JFrame va ) {
		 super();
	        vActual = this;
	        vAnterior = va;
	        setTitle("Ventana de Limpieza");
	        setLocationRelativeTo(null);
	        setBounds(500, 300, 700, 400); // Ajuste el tamaño de la ventana según sea necesario
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        JPanel panelTitulo = new JPanel();
	        panelTitulo.setBackground(new Color(70, 130, 180));
	        JLabel lblTitulo = new JLabel("Tareas de limpieza");
			lblTitulo.setForeground(Color.white);
		    lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 30));
		    panelTitulo.add(lblTitulo);
		    getContentPane().add(panelTitulo, BorderLayout.NORTH);
		    
		    JPanel panelTareas = new JPanel(new GridLayout(4,3, 10, 10));
		    
		    JLabel lblOficina = new JLabel( "Limpiar oficinas" );
		    lblOficina.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        lblOficina.setForeground(new Color(70, 130, 180));
		    panelTareas.add(lblOficina);
		    progressOficinas = new JProgressBar( 0, 100 );
		    progressOficinas.setStringPainted(true);
		    panelTareas.add(progressOficinas);
		    boxOficinas = new JCheckBox();
		    boxOficinas.setEnabled(false);
		    panelTareas.add(boxOficinas);
		    
		    JLabel lblPapeleras = new JLabel( "Limpiar papeleras" );
		    lblPapeleras.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        lblPapeleras.setForeground(new Color(70, 130, 180));
		    panelTareas.add(lblPapeleras);
		    progressPapeleras = new JProgressBar( 0, 100 );
		    progressPapeleras.setStringPainted(true);
		    panelTareas.add(progressPapeleras);
		    boxPapeleras = new JCheckBox();
		    boxPapeleras.setEnabled(false);
		    panelTareas.add(boxPapeleras);
		    
		    JLabel lblBanyos = new JLabel( "Limpiar baños" );
		    lblBanyos.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        lblBanyos.setForeground(new Color(70, 130, 180));
		    panelTareas.add(lblBanyos);
		    progressBanyos = new JProgressBar( 0, 100 );
		    progressBanyos.setStringPainted(true);
		    panelTareas.add(progressBanyos);
		    boxBanyos = new JCheckBox();
		    boxBanyos.setEnabled(false);
		    panelTareas.add(boxBanyos);
		    
		    JLabel lblHabitats = new JLabel( "Limpiar hábitats de animales" );
		    lblHabitats.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        lblHabitats.setForeground(new Color(70, 130, 180));
		    panelTareas.add(lblHabitats);
		    progressHabitats = new JProgressBar( 0, 100 );
		    progressHabitats.setStringPainted(true);
		    panelTareas.add(progressHabitats);
		    boxHabitats = new JCheckBox();
		    boxHabitats.setEnabled(false);
		    panelTareas.add(boxHabitats);
		
		    
		    
		    getContentPane().add(panelTareas, BorderLayout.CENTER);
		    
		    JButton botonComenzar = new JButton( "COMENZAR TAREAS" );
		    botonComenzar.setForeground(new Color(70, 130, 180));
	        botonComenzar.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        botonComenzar.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					inicializarBarraProgreso1();
					inicializarBarraProgreso2();
					inicializarBarraProgreso3();
					inicializarBarraProgreso4();
				}
			});
		    
		    btnVolver = new JButton("VOLVER");
		    btnVolver.setForeground(new Color(70, 130, 180));
	        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
	        btnVolver.addActionListener((e)->{
	        	vAnterior.setVisible(true);
	        	vActual.dispose();
	        });
	        pSur = new JPanel();
	        pSur.setBackground(new Color(70, 130, 180));
	        getContentPane().add(pSur, BorderLayout.SOUTH);
	        pSur.add(botonComenzar);
	        pSur.add(btnVolver);
	        
	        
	        setVisible(true);
	 }

	protected void inicializarBarraProgreso1() {
		// TODO Auto-generated method stub
		SwingWorker<Void, Integer> swingWorker = new SwingWorker<Void, Integer>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				// Para que tarde un tiempo aleatorio en completarse el JProgressBar
				Random random = new Random();
				int progresoHastaElMomento = 0;
				
				while(progresoHastaElMomento < 100) {
					int i = random.nextInt(500) + 100;
					Thread.sleep(i);
					progresoHastaElMomento += random.nextInt(5) + 1;
					progresoHastaElMomento = Math.min(progresoHastaElMomento, 100);
					publish(progresoHastaElMomento);
				}
				
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// TODO Auto-generated method stub
				int ultimoProceso = chunks.get(chunks.size() -1 );
				progressOficinas.setValue(ultimoProceso);
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				boxOficinas.setSelected(true);
				boxOficinas.setEnabled(true);
			}
			
			
		};
		
		swingWorker.execute();
	}
	protected void inicializarBarraProgreso2() {
		// TODO Auto-generated method stub
		SwingWorker<Void, Integer> swingWorker = new SwingWorker<Void, Integer>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				// Para que tarde un tiempo aleatorio en completarse el JProgressBar
				Random random = new Random();
				int progresoHastaElMomento = 0;
				
				while(progresoHastaElMomento < 100) {
					int i = random.nextInt(500) + 100;
					Thread.sleep(i);
					progresoHastaElMomento += random.nextInt(5) + 1;
					progresoHastaElMomento = Math.min(progresoHastaElMomento, 100);
					publish(progresoHastaElMomento);
				}
				
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// TODO Auto-generated method stub
				int ultimoProceso = chunks.get(chunks.size() -1 );
				progressPapeleras.setValue(ultimoProceso);
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				boxPapeleras.setSelected(true);
				boxPapeleras.setEnabled(true);
			}
			
			
		};
		
		swingWorker.execute();
	}
	protected void inicializarBarraProgreso3() {
		// TODO Auto-generated method stub
		SwingWorker<Void, Integer> swingWorker = new SwingWorker<Void, Integer>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				// Para que tarde un tiempo aleatorio en completarse el JProgressBar
				Random random = new Random();
				int progresoHastaElMomento = 0;
				
				while(progresoHastaElMomento < 100) {
					int i = random.nextInt(500) + 100;
					Thread.sleep(i);
					progresoHastaElMomento += random.nextInt(5) + 1;
					progresoHastaElMomento = Math.min(progresoHastaElMomento, 100);
					publish(progresoHastaElMomento);
				}
				
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// TODO Auto-generated method stub
				int ultimoProceso = chunks.get(chunks.size() -1 );
				progressBanyos.setValue(ultimoProceso);
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				boxBanyos.setSelected(true);
				boxBanyos.setEnabled(true);
			}
			
			
		};
		
		swingWorker.execute();
	}protected void inicializarBarraProgreso4() {
		// TODO Auto-generated method stub
		SwingWorker<Void, Integer> swingWorker = new SwingWorker<Void, Integer>(){

			@Override
			protected Void doInBackground() throws Exception {
				// TODO Auto-generated method stub
				// Para que tarde un tiempo aleatorio en completarse el JProgressBar
				Random random = new Random();
				int progresoHastaElMomento = 0;
				
				while(progresoHastaElMomento < 100) {
					int i = random.nextInt(500) + 100;
					Thread.sleep(i);
					progresoHastaElMomento += random.nextInt(5) + 1;
					progresoHastaElMomento = Math.min(progresoHastaElMomento, 100);
					publish(progresoHastaElMomento);
				}
				
				return null;
			}

			@Override
			protected void process(List<Integer> chunks) {
				// TODO Auto-generated method stub
				int ultimoProceso = chunks.get(chunks.size() -1 );
				progressHabitats.setValue(ultimoProceso);
			}

			@Override
			protected void done() {
				// TODO Auto-generated method stub
				boxHabitats.setSelected(true);
				boxHabitats.setEnabled(true);
			}
			
			
		};
		
		swingWorker.execute();
	}


}
