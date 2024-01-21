package Ventanas;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;

public class VentanaMapa extends JFrame {
    private JFrame vActual, vAnterior;
    private JButton btnVolver;
    private JPanel pSur;
    private JLabel labelImagen;  

    public VentanaMapa(JFrame va) {
        super();
        vActual = this;
        vAnterior = va;
        setSize(825, 545);
        setResizable(false);
        setTitle( "MAPA DEL ZOO" );
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        ImageIcon icono = new ImageIcon("mapaZoo.png");
        Image imagen = icono.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        ImageIcon nuevoIcono = new ImageIcon(imagen);
        labelImagen = new JLabel(nuevoIcono);
        labelImagen.setHorizontalAlignment(JLabel.CENTER);
        labelImagen.setVerticalAlignment(JLabel.CENTER);
        getContentPane().add(labelImagen, BorderLayout.CENTER);

        /*
         * A continuación el código para que la imagen se ajuste bien a la ventana
         */
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                int nuevaAnchura = getWidth();
                int nuevaAltura = getHeight();

                Image imagenOriginal = icono.getImage();
                double proporcionAncho = (double) nuevaAnchura / imagenOriginal.getWidth(null);
                double proporcionAltura = (double) nuevaAltura / imagenOriginal.getHeight(null);

                double escala = Math.min(proporcionAncho, proporcionAltura);

                int anchoEscalado = (int) (imagenOriginal.getWidth(null) * escala);
                int alturaEscalada = (int) (imagenOriginal.getHeight(null) * escala);

                Image imagenEscalada = imagenOriginal.getScaledInstance(anchoEscalado, alturaEscalada, Image.SCALE_SMOOTH);
                ImageIcon nuevoIcono = new ImageIcon(imagenEscalada);

                labelImagen.setIcon(nuevoIcono);
            }
        });
        btnVolver = new JButton("VOLVER");
        btnVolver.setFont(new Font("Times New Roman", Font.BOLD, 14));
        btnVolver.setForeground(new Color(70, 130, 180));

        pSur = new JPanel();
        pSur.setBackground(new Color(70, 130, 180));
        getContentPane().add(pSur, BorderLayout.SOUTH);
        pSur.add(btnVolver);

        btnVolver.addActionListener((e) -> {
            vAnterior.setVisible(true);
            vActual.dispose();  
        });
        setVisible(true);

    };
//    public static void main(String[] args) {
//		new VentanaMapa();
//	}
    
}
