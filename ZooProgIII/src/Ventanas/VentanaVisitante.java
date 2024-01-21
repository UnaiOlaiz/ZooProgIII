package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Zoo.BordeadoTexto;
import Zoo.ImagePanel;
// import uk.co.caprica.vlcj.factory.discovery.NativeDiscovery;
// import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

public class VentanaVisitante extends JFrame{
	private static JFrame vActual;
	private JFrame vAnterior;
	private JButton btnEventos, btnMapa, btnInfoAnimales, btnVolver;
	private JPanel pnlNorte, pnlBotones;
	private JLabel lblTitulo;
//	private EmbeddedMediaPlayerComponent component;


	
	private static VentanaVisitante miVentana; 
	
	public VentanaVisitante(JFrame va) {
		super();
		setTitle( "INFORMACIÓN PARA LOS VISITANTES" );
		vActual = this;
		vAnterior = va;
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setBounds(250, 100, 1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		/*
		 * Para añadir el JScrollPane a toda la ventana vamos a crear un panel principal
		 */
		
		JPanel panelContenidoPrincipal = new JPanel( new BorderLayout());
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBackground(new Color(70, 130, 180));
		pnlTitulo.setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel lblTitulo = new JLabel( "BIENVENIDO A ZOOYARZABAL" );
        lblTitulo.setFont(new Font("Times New Roman", Font.BOLD, 40));
        lblTitulo.setForeground(Color.white);
        pnlTitulo.add(lblTitulo);
        panelContenidoPrincipal.add(pnlTitulo, BorderLayout.NORTH);

        JPanel pnlSur = new JPanel();
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        
        
        JTextArea areaTexto = new JTextArea();
        areaTexto.setOpaque(false);
        areaTexto.setRows(10);
        areaTexto.setColumns(30);
        areaTexto.setText(
                "¡Bienvenidos al Zoológico Zooyarzabal!\n\n" +
                "Estamos emocionados de presentarles nuestro zoológico, donde podrán experimentar " +
                "la diversidad y belleza de la vida animal. Algunas de las atracciones destacadas incluyen:\n\n" +
                "- Safari Africano: Observa a majestuosos leones, elefantes, jirafas y rinocerontes en su hábitat natural.\n" +
                "- Acuario Marino : Sumérgete en las profundidades del océano y descubre una variedad de peces tropicales, tiburones y corales vibrantes.\n" +
                "- Selva Amazónica : Explora la rica biodiversidad de la selva amazónica, desde coloridos loros hasta intrigantes jaguares y perezosos.\n" +
                "- Habitat Polar : Experimenta el frío ártico mientras observas a osos polares, pingüinos y otras criaturas adaptadas a las condiciones extremas.\n\n" +
                "Además de nuestras atracciones principales, ofrecemos espectáculos diarios, charlas educativas y actividades interactivas para toda la familia. " +
                "Esperamos que disfruten de esta aventura única y se lleven recuerdos inolvidables de su visita a Zooyarzabal."
        );
        areaTexto.setEditable(false);
        areaTexto.setWrapStyleWord(true);
        areaTexto.setLineWrap(true);
        Font fuenteLetra = new Font("Times New Roman", Font.BOLD, 17);
        areaTexto.setFont(fuenteLetra);
        areaTexto.setForeground(new Color(70, 130, 180));
        
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        imagePanel.setBackground(Color.WHITE);
        imagePanel.add(areaTexto, BorderLayout.NORTH);
        
        
        panelPrincipal.add(imagePanel);
        panelPrincipal.setBackground(new Color(173, 217, 230));
        panelContenidoPrincipal.add(panelPrincipal, BorderLayout.CENTER);
        
        
        JPanel panelSurNorte = new JPanel(new GridLayout(5, 2));
        panelSurNorte.setBackground(Color.white);
        
        JPanel panel1 = new JPanel();
        JLabel label1 = new JLabel( "" );
        panel1.add(label1);
        panel1.setBackground(new Color(70, 130, 180));
        panelSurNorte.add(panel1);
        
        JPanel panel2 = new JPanel();
        JLabel label2 = new JLabel( "" );
        panel2.add(label2);
        panel2.setBackground(new Color(70, 130, 180));
        panelSurNorte.add(panel2);
        
        JLabel labelEventos = new JLabel( "Consulta los eventos disponibles en nuestro ZOO" );
        labelEventos.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelEventos.setForeground(new Color(70, 130, 180));
        panelSurNorte.add(labelEventos);
        
        btnEventos = new JButton( "EVENTOS" );
        btnEventos.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnEventos.setForeground(new Color(70, 130, 180));
        panelSurNorte.add(btnEventos);
        
        JLabel labelMapa = new JLabel( "Aquí puedes conseguir el mapa de nuestro ZOO" );
        labelMapa.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelMapa.setForeground(new Color(70, 130, 180));
        panelSurNorte.add(labelMapa);
        
        JButton botonMapa = new JButton( "MAPA" );
        botonMapa.setFont(new Font("Times New Roman", Font.BOLD, 17));
        botonMapa.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción de Mapa", "MAPA", JOptionPane.INFORMATION_MESSAGE);
			new VentanaMapa(vActual);
			vActual.dispose();
		});
        botonMapa.setFont(new Font("Times New Roman", Font.BOLD, 14));
        botonMapa.setForeground(new Color(70, 130, 180));
        panelSurNorte.add(botonMapa);
        
        JLabel labelInfoAnimales = new JLabel( "Mira el vídeo de bienvenida" );
        labelInfoAnimales.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelInfoAnimales.setForeground(new Color(70, 130, 180));
        panelSurNorte.add(labelInfoAnimales);
        
        btnInfoAnimales = new JButton("LINK VÍDEO");
        btnInfoAnimales.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnInfoAnimales.setForeground(new Color(70, 130, 180));
		panelSurNorte.add(btnInfoAnimales);
		
		JLabel labelBillete = new JLabel( "Compra las entradas online" );
        labelBillete.setFont(new Font("Times New Roman", Font.BOLD, 17));
        labelBillete.setForeground(new Color(70, 130, 180));
        panelSurNorte.add(labelBillete);
        
        JButton botonImprimirBillete = new JButton( "COMPRAR BILLETE" );
		botonImprimirBillete.setFont(new Font("Times New Roman", Font.BOLD, 17));
		botonImprimirBillete.setForeground(new Color(70, 130, 180));
		panelSurNorte.add(botonImprimirBillete);
        
		pnlSur.setLayout(new BorderLayout());
        pnlSur.add(panelSurNorte, BorderLayout.NORTH);
        
        
        JPanel pnlBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnlBotones.setBackground(new Color(70, 130, 180));
//        btnEventos = new JButton("EVENTOS");
////        btnEventos.setBackground(new Color(0, 128, 128));
//        btnEventos.setFont(new Font("Times New Roman", Font.BOLD, 14));
//        btnEventos.setForeground(new Color(70, 130, 180));
//        btnMapa = new JButton("MAPA");
////        btnMapa.setBackground(new Color(0, 128, 128));
//        btnMapa.setFont(new Font("Times New Roman", Font.BOLD, 14));
//        btnMapa.setForeground(new Color(70, 130, 180));
//		btnInfoAnimales = new JButton("INFORMACIÓN DE ANIMALES");
////		btnInfoAnimales.setBackground(new Color(0, 128, 128));
//		btnInfoAnimales.setFont(new Font("Times New Roman", Font.BOLD, 14));
//		btnInfoAnimales.setForeground(new Color(70, 130, 180));
		btnVolver = new JButton("VOLVER");
//		btnVolver.setBackground(new Color(0, 128, 128));
		btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnVolver.setForeground(new Color(70, 130, 180));
		
//		pnlBotones.add(btnEventos);
//		pnlBotones.add(btnMapa);
//		pnlBotones.add(btnInfoAnimales);
//		pnlBotones.add(botonImprimirBillete);
		pnlBotones.add(btnVolver, BorderLayout.CENTER);
		pnlSur.add(pnlBotones, BorderLayout.SOUTH);
		panelContenidoPrincipal.add(pnlSur, BorderLayout.SOUTH);
		
		btnEventos.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción de Eventos", "EVENTOS", JOptionPane.INFORMATION_MESSAGE);
			new VentanaEventos(vActual);
			vActual.dispose();
		});
		
		
		
		btnInfoAnimales.addActionListener((e)->{
			JOptionPane.showMessageDialog(null, "Has seleccionado la opción de reproducción del vídeo", "VÍDEO", JOptionPane.INFORMATION_MESSAGE);
//			new VentanaAnimales(vActual);
			new VentanaVideo(vActual);
			vActual.dispose();
		});
		
		btnVolver.addActionListener((e)->{
	        vAnterior.setVisible(true);
			vActual.dispose();
	    });
		
		botonImprimirBillete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Has seleccionado la opción de comprar billete", "COMPRAR BILLETE", JOptionPane.INFORMATION_MESSAGE);
				new VentanaComprarBillete(vActual);
				vActual.dispose();
			}
		});

		JScrollPane scrollPane = new JScrollPane(panelContenidoPrincipal);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		add(scrollPane);
		setVisible(true);
		
		

	
}

}
	
	