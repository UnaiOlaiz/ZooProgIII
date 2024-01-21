package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class VentanaSeguridad extends JFrame {
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver, botonEmpezarJornada;
	protected JPanel pSur;
	protected ArrayList<String> titulosAudios;
	protected Thread hilo;
	protected Player player;
	protected boolean estaReproduciendose = false;
	protected JTextArea area;

	
	/*
	 * En esta ventana que se ejecutará tanto al registrar un nuevo trabajador con función de guardia de seguridad, o al 
	 * iniciar sesión como uno ya registrado, tiene el objetivo de simular un "walkee talkee" que dispone un guardia de seguridad
	 * en este tipo de empresas y establecimientos. El guardia recibirá aleatoriamente una serie de alertas ya sea que un animal se haya
	 * escapado, que alguien haya entrado sin entrada, ... etc mediante una serie de audios customizados para simular lo más fielmente
	 * posible las órdenes y mensajes que recibe uno en la vida real.
	 */
	
	public VentanaSeguridad(JFrame va) { // Luego aquí insertar JFrame va
		super();
		vActual = this;
		vAnterior = va;
		setTitle("Ventana de Seguridad");
		setResizable(true);
		setLocationRelativeTo(null);
		setBounds(500, 300, 800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        titulosAudios = new ArrayList<>();
    	// Primero rellenemos el array de títulos
    	titulosAudios.add("AudioLeon.mp3");
    	titulosAudios.add("AudioMono.mp3");
    	titulosAudios.add("TheoryOfEverything.mp3");
    	
    	// Panel donde irán las explicaciones de como llevar a cabo el trabajo como guarda de seguridad del ZOO
    	JPanel panelNorte = new JPanel(new GridLayout(4,1));
    	
    	JPanel panelExplicacion0 = new JPanel();
	    panelExplicacion0.setBackground(new Color(70, 130, 180));
	    JLabel labelExplicacion0 = new JLabel( "RECORDATORIO");
	    labelExplicacion0.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    labelExplicacion0.setForeground(Color.WHITE);
	    panelExplicacion0.add(labelExplicacion0);
    	
    	JPanel panelExplicacion1 = new JPanel();
	    panelExplicacion1.setBackground(new Color(70, 130, 180));
	    JLabel labelExplicacion1 = new JLabel( "Bienvenido al panel de control de la seguridad del ZOO");
	    labelExplicacion1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelExplicacion1.setForeground(Color.WHITE);
	    panelExplicacion1.add(labelExplicacion1);
	    
	    JPanel panelExplicacion2 = new JPanel();
	    panelExplicacion2.setBackground(new Color(70, 130, 180));
	    JLabel labelExplicacion2 = new JLabel( "Se le notificarán todo tipo de problemas dentro de ZOOyarzabal" );
	    labelExplicacion2.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelExplicacion2.setForeground(Color.WHITE);
	    panelExplicacion2.add(labelExplicacion2);
	    
	    JPanel panelExplicacion3 = new JPanel();
	    panelExplicacion3.setBackground(new Color(70, 130, 180));
	    JLabel labelExplicacion3 = new JLabel( "Intente responder y actuar de la mejor manera posible, la seguridad del recinto depende de usted");
	    labelExplicacion3.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelExplicacion3.setForeground(Color.WHITE);
	    panelExplicacion3.add(labelExplicacion3);
	    
	    panelNorte.add(panelExplicacion0);
	    panelNorte.add(panelExplicacion1);
	    panelNorte.add(panelExplicacion2);
	    panelNorte.add(panelExplicacion3);
	    
	    getContentPane().add(panelNorte, BorderLayout.NORTH);
	    
	    JPanel panelCentro = new JPanel();
	    panelCentro.setBackground(new Color(70, 130, 180));
	    ImageIcon icono = new ImageIcon("fotoRadio.png"); 
        Image imagen = icono.getImage();
        Image nuevaImagen = imagen.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon nuevoIcono = new ImageIcon(nuevaImagen);
        JLabel labelImagen = new JLabel(nuevoIcono);
        panelCentro.add(labelImagen);
	    getContentPane().add(panelCentro, BorderLayout.CENTER);
    	
    	

        // Panel donde irá el botón
	    botonEmpezarJornada = new JButton( "ATENDER PROBLEMAS" );
	    botonEmpezarJornada.setFont(new Font("Times New Roman", Font.BOLD, 14));
        botonEmpezarJornada.setForeground(new Color(70, 130, 180));
        btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.setForeground(new Color(70, 130, 180));
        JButton botonSolucionarProblemas = new JButton( "SOLUCIONAR PROBLEMAS" );
        botonSolucionarProblemas.setFont(new Font("Times New Roman", Font.BOLD, 14));
        botonSolucionarProblemas.setForeground(new Color(70, 130, 180));
        
        btnVolver.addActionListener((e)->{
        	vAnterior.setVisible(true);
        	vActual.dispose();
        });
        pSur = new JPanel();
        pSur.setBackground(new Color(70, 130, 180));
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(botonEmpezarJornada);
        pSur.add(botonSolucionarProblemas);
        pSur.add(btnVolver);
        
        botonSolucionarProblemas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (estaReproduciendose) {
					return;
				}
				if (player != null) {
					player.close();
					player = null;
				}
				
			}
		});
        
        botonEmpezarJornada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				estaReproduciendose = true;
				botonEmpezarJornada.setEnabled(false);
				/*
				 * Vamos a esperar un rato de tiempo aleatorio (poco tiempo) hasta que suene la alarma y
				 * salga la alerta de que hay un problema, luego se reproducirá el audio
				 */
				Random random = new Random();
				int tiempoAleatorio = random.nextInt(5000) + 1000;
				
				try {
					Thread.sleep(tiempoAleatorio);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				if (!titulosAudios.isEmpty()) {
					// Que se reproduzca el audio de alarma
					try {
						ReproducirAudioMp3("SonidoAlarma.mp3");
					} catch (JavaLayerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				String audioAleatorio = ElegirArchivoAleatorio(titulosAudios);
				try {
					ReproducirAudioMp3(audioAleatorio);
				} catch (JavaLayerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				titulosAudios.remove(audioAleatorio);
				System.out.println(audioAleatorio);
				botonEmpezarJornada.setEnabled(true);
			}
		});
        
        setVisible(true);
		
	}
	
	/*
	 * A continuación vamos a programar el método que se encargará de reproducir los audios
	 * Seguramente sea implentado en algún tipo de hilo.
	 */
	
	public String ElegirArchivoAleatorio(ArrayList<String> arrayList) {
	    if (!arrayList.isEmpty()) {
	        Random random = new Random();
	        int indiceAleatorio = random.nextInt(arrayList.size());
	        
	        String tituloAleatorio = arrayList.get(indiceAleatorio);
	        
	        if (tituloAleatorio != null) {
	            switch (tituloAleatorio) {
	                case "AudioLeon.mp3":
	                    JOptionPane.showMessageDialog(null, "¡ALERTA CÓDIGO 14!", "Alerta", JOptionPane.WARNING_MESSAGE);
	                    break;
	                case "AudioMono.mp3":
	                    JOptionPane.showMessageDialog(null, "¡ALERTA CÓDIGO 12!", "Alerta", JOptionPane.WARNING_MESSAGE);
	                    break;
	                default:
	                    break;
	            }
	            return tituloAleatorio;
	        } else {
	            System.err.println("El título aleatorio es null");
	        }
	    } else {
	        System.err.println("El array está ya vacío");
	        JOptionPane.showMessageDialog(null, "NO HAY PROBLEMAS QUE SOLUCIONAR");
	    }
	    return null;
	}

	
	public void ReproducirAudioMp3(String nombreArchivo) throws JavaLayerException {
		if (nombreArchivo != null) {
			try {
				FileInputStream fileInputStream = new FileInputStream(nombreArchivo);
				player = new Player(fileInputStream);
				player.play();
				player.close();
				estaReproduciendose = false;
				botonEmpezarJornada.setEnabled(true);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.err.println("Error al recibir el nombre del archivo");
		}
	}
	
	
	
	

}