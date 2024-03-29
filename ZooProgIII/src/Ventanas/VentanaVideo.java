package Ventanas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VentanaVideo extends JFrame{
	protected JFrame vActual, vAnterior;
	protected JButton btnVolver, btnPlayPausa;
	protected JPanel pSur;
	private EmbeddedMediaPlayerComponent component;
	private JLabel labelInfo;
	
	public VentanaVideo(JFrame va) {
		super();
		// Características principales
		vActual = this;
		vAnterior = va;
		setResizable(false);
		setTitle("Vídeo de bienvenida");
		setSize(800,600);
		setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        
        labelInfo = new JLabel("");
        labelInfo.setHorizontalAlignment(JLabel.CENTER);
        labelInfo.setForeground(Color.RED);
        add(labelInfo, BorderLayout.NORTH);
        
        // Panel principal
        component = new EmbeddedMediaPlayerComponent();
        add(component, BorderLayout.CENTER);
        
        // Panel de abajo donde van los botones
        btnPlayPausa = new JButton("PLAY/PAUSA");
        btnPlayPausa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnPlayPausa.setForeground(new Color(70, 130, 180));
        
        btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.setForeground(new Color(70, 130, 180));
        btnVolver.addActionListener((e) -> {
            System.out.println("Botón Volver presionado");
            detenerReproduccion();
            vAnterior.setVisible(true);
            vActual.dispose();
        });
        pSur = new JPanel();
        pSur.setBackground(new Color(70, 130, 180));
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnPlayPausa);
        pSur.add(btnVolver);
		
        /* El reproductor de vídeo funcionará mediante listeners de la ventana
         * y botón, empezará al abrirse la ventana, se detendrá al 
         * cerrarla, ... etc.
         */
        getContentPane().setFocusable(true);
        configurarAccionesTeclado();
        
        
        this.addWindowListener(new WindowAdapter() {
        	
			
			@Override
			public void windowOpened(WindowEvent e) {
				btnVolver.requestFocus();
			}

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("Ventana cerrándose");
				detenerReproduccion();
				vAnterior.setVisible(true);
				vActual.dispose();
			}

		});
        
        // También programaremos la función de pausar/retomar el vídeo mediante la tecla Space
        getContentPane().addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (component.mediaPlayer().status().isPlaying()) {
						component.mediaPlayer().controls().pause();
						System.out.println("Vídeo pausado");
					} else {
						component.mediaPlayer().controls().play();
						System.out.println("Vídeo reanudado");
					}
				}
			}
		});

        btnPlayPausa.addActionListener(new ActionListener() {
			/*
			 * Si el reproductor está reproduciendose y le damos al botón, hará
			 * que pause el vídeo, y viceversa.
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if (component.mediaPlayer().status().isPlaying()) {
					component.mediaPlayer().controls().pause();
					System.out.println("Vídeo pausado");
				} else {
					component.mediaPlayer().controls().play();
					System.out.println("Vídeo reanudado");
				}
			}
		});
        
        setVisible(true);
         
        // Código extra para el vclj
//        NativeDiscovery n = new NativeDiscovery();
//        boolean encontrado = n.discover();
//        System.out.println(encontrado);
//        System.setProperty("jna.library.path", "C:/Program Files/VideoLAN/VLC");
        lanza("VideoIntro.mp4");
//        System.out.println(n.discoveredPath());
		
	}
	

    private void togglePlayPause() {
        if (component.mediaPlayer().status().isPlaying()) {
            component.mediaPlayer().controls().pause();
            System.out.println("Vídeo pausado");
        } else {
            component.mediaPlayer().controls().play();
            System.out.println("Vídeo reanudado");
        }
    }
	
	protected void detenerReproduccion() {
		if (component != null) {
			component.mediaPlayer().controls().stop();
			component.release();
		}
		
	}
	private void configurarAccionesTeclado() {
		javax.swing.Action playPauseAccion = new AbstractAction() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				togglePlayPause();
			}
		};
		
		javax.swing.Action volverAccion = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Botón Volver presionado");
				detenerReproduccion();
				vAnterior.setVisible(true);
				vActual.dispose();
			}
		};
		
		KeyStroke playPauseKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false);
        KeyStroke volverKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK, false);

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(playPauseKeyStroke, "PlayPause");
        getRootPane().getActionMap().put("PlayPause", playPauseAccion);

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(volverKeyStroke, "Volver");
        getRootPane().getActionMap().put("Volver", volverAccion);
	}
	
	// Método que lanzará el vídeo
	private void lanza(String pathDelVideo) {
		component.mediaPlayer().audio().setVolume(100);
		component.mediaPlayer().media().play(pathDelVideo);
	}
}
